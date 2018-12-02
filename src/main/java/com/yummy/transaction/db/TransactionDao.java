package com.yummy.transaction.db;

import com.yummy.transaction.model.CurrentOrder;
import com.yummy.transaction.model.HistoricOrder;
import com.yummy.transaction.model.Order;
import com.yummy.transaction.model.TransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;


@Repository
public class TransactionDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int countAll(long restaurantId) {
        String query = "SELECT count(*) FROM\n" +
                "(\n" +
                "SELECT \n" +
                "t.id\n" +
                "FROM transaction t   \n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.transaction_id=t.id)\n" +
                "LEFT JOIN offer o ON (o.id=tol.offer_id)             \n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)             \n" +
                "WHERE r.id=\'" + restaurantId + "\' " +
                "GROUP BY t.id\n" +
                ") AS temp";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

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

    public int countByState(long restaurantId, String state) {
        String query = "SELECT count(*) FROM\n" +
                "(\n" +
                "SELECT t.id FROM transaction t \n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.transaction_id=t.id)\n" +
                "LEFT JOIN offer o ON (o.id=tol.offer_id) \n" +
                "LEFT JOIN restaurant r  ON (r.id=o.restaurant_id) \n" +
                "WHERE r.id=\'" + restaurantId + "\' AND t.transaction_state=\'" + state + "\' " +
                "GROUP BY t.id\n" +
                ") AS temp;";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public StringBuilder in(List<String> list) {
        StringBuilder result = new StringBuilder();
        result.append("(");
        for (int i = 0; i < list.size() - 1; i++) {
            result.append(list.get(i) + ",");
        }
        result.append(list.get(list.size() - 1) + ")");
        return result;
    }

    public double countTakings(long restaurantId, long type) {
        String transactionIdsQuery = "SELECT distinct toc.transaction_id FROM offer o\n" +
                "LEFT JOIN transaction_offer_link toc ON (toc.offer_id=o.id)\n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "WHERE r.id = '" + restaurantId + "';";
        List<String> transactionsIds = jdbcTemplate.query(transactionIdsQuery, ((rs, rowNum) -> {
            return Integer.toString(rs.getInt(1));
        }));
        if (transactionsIds.isEmpty()) {
            return 0;
        }
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

    public List<Order> getPendingOrdersForRestaurant(long restaurantId, int limit, int offset) {
        String query = "SELECT t.order_time,o.price,t.id,o.description, t.receive_time, t.code \n" +
                "FROM offer o\n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.offer_id=o.id)" +
                "left join transaction t on (t.id=tol.transaction_id)" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)\n" +
                "WHERE r.id = \'" + restaurantId + "\'\n" +
                "AND t.transaction_state='PENDING' " +
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

    public List<Order> findAllByRestaurant(long userId, int limit, int offset) {
        String query = "SELECT t.order_time,o.price,t.id,o.description, t.receive_time, t.transaction_state, t.code \n" +
                "FROM transaction t\n" +
                "LEFT JOIN transaction_offer_link tol ON (tol.transaction_id=t.id)\n" +
                "LEFT JOIN offer o ON (tol.offer_id=o.id)\n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)" +
                "WHERE user_id = '" + userId + "' " +
                "LIMIT " + limit + " offset " + offset + ";";
        return jdbcTemplate.query(query, ((rs, rowNum) -> {
            HistoricOrder result = new HistoricOrder();
            result.setId(rs.getInt(3));
            result.setOrderTime(rs.getTimestamp(1).toLocalDateTime());
            result.setReceiveTime(rs.getTimestamp(5).toLocalDateTime());
            result.setTransactionState(TransactionState.valueOf(rs.getString(6)));
            result.setPaymentCode(rs.getString(7));
            return result;
        }));
    }

}
