package com.dwe.dealwitheat.transaction.db;

import com.dwe.dealwitheat.transaction.model.CurrentOrder;
import com.dwe.dealwitheat.transaction.model.HistoricOrder;
import com.dwe.dealwitheat.transaction.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;


@Repository
public class TransactionDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countAll(String email) {
        String query = "SELECT count(*) FROM\n" +
                "(\n" +
                "SELECT \n" +
                "t.id\n" +
                "FROM transaction t   \n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.transaction_id=t.id)\n" +
                "LEFT JOIN offer o ON (o.id=tol.offer_id)             \n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)             \n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id) \n" +
                "WHERE e.email=\'" + email + "\' " +
                "GROUP BY t.id\n" +
                ") AS temp";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public int countByState(String email, String state) {
        String query = "SELECT count(*) FROM\n" +
                "(\n" +
                "SELECT t.id FROM transaction t \n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.transaction_id=t.id)\n" +
                "LEFT JOIN offer o ON (o.id=tol.offer_id) \n" +
                "LEFT JOIN restaurant r  ON (r.id=o.restaurant_id) \n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id) \n" +
                "WHERE e.email=\'" + email + "\' AND t.state=\'" + state + "\' " +
                "GROUP BY t.id\n" +
                ") AS temp;";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public StringBuilder in(List<String> zipCodeList) {
        StringBuilder zipCodes = new StringBuilder();
        zipCodes.append("(");
        for (int i = 0; i < zipCodeList.size() - 1; i++) {
            zipCodes.append(zipCodeList.get(i) + ",");
        }
        zipCodes.append(zipCodeList.get(zipCodeList.size() - 1) + ")");
        return zipCodes;
    }

    public double countTakings(String email, long type) {
        String transactionIdsQuery = "SELECT distinct toc.transaction_id FROM offer o\n" +
                "LEFT JOIN transaction_offer_link toc ON (toc.offer_id=o.id)\n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)\n" +
                "WHERE email = '" + email + "';";
        List<String> transactionsIds = jdbcTemplate.query(transactionIdsQuery, ((rs, rowNum) -> {
            return Integer.toString(rs.getInt(1));
        }));
        String query;
        if (type == 0) {
            query = "SELECT sum(o.price) FROM offer o where id in " + in(transactionsIds).toString() + " ";
        } else {
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime() - type);
            query = "SELECT sum(o.price) FROM offer o " +
                    "left join transaction_offer_link toc on (toc.offer_id=o.id)  " +
                    "left join transaction t on (toc.transaction_id=t.id) " +
                    "where t.id in " + in(transactionsIds).toString() + " " +
                    "AND t.order_time > \'" + date.toString() + "\'";
        }
        Double result = jdbcTemplate.queryForObject(query, Double.class);
        return result == null ? 0 : result;
    }

    public List<Order> getPendingOrdersForRestaurant(String email, int limit, int offset) {
        String query = "SELECT t.order_time,o.price,t.id,o.description, t.receive_time, t.code \n" +
                "FROM offer o\n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.offer_id=o.id)" +
                "left join transaction t on (t.id=tol.transaction_id)" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)\n" +
                "WHERE email = \'" + email + "\'\n" +
                "AND state='PENDING' " +
                "LIMIT " + limit + " offset " + offset + ";";
        return jdbcTemplate.query(query, ((rs, rowNum) -> {
            CurrentOrder result = new CurrentOrder();
            result.setId(rs.getInt(3));
            result.setOrderTime(rs.getTimestamp(1).toLocalDateTime().toString());
            result.setReceiveTime(rs.getTimestamp(5).toLocalDateTime().toString());
            result.setPaymentCode(rs.getString(6));
            return result;
        }));
    }

    public List<Order> findAllByRestaurant(String email, int limit, int offset) {
        String query = "SELECT t.order_time,o.price,t.id,o.description, t.receive_time, t.state, t.code \n" +
                "FROM transaction t\n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.transaction_id=t.id)\n" +
                "LEFT JOIN offer o ON (tol.offer_id=o.id)\n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)" +
                "WHERE email = '" + email + "' " +
                "LIMIT " + limit + " offset " + offset + ";";
        return jdbcTemplate.query(query, ((rs, rowNum) -> {
            HistoricOrder result = new HistoricOrder();
            result.setId(rs.getInt(3));
            result.setOrderTime(rs.getTimestamp(1).toLocalDateTime().toString());
            result.setReceiveTime(rs.getTimestamp(5).toLocalDateTime().toString());
            result.setState(rs.getString(6));
            result.setPaymentCode(rs.getString(6));
            return result;
        }));
    }

}
