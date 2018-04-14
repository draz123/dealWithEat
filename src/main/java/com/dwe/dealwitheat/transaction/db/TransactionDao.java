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
        String query = "SELECT sum(t.count) FROM transaction t " +
                "            LEFT JOIN offer o ON (o.id=t.offer_id) " +
                "            LEFT JOIN restaurant r ON (r.id=o.restaurant_id) " +
                "            LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id) " +
                "WHERE e.email=\'" + email + "\'";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public int countByState(String email, String state) {
        String query = "SELECT sum(t.count) FROM transaction t " +
                "LEFT JOIN offer o ON (o.id=t.offer_id) " +
                "LEFT JOIN restaurant r  ON (r.id=o.restaurant_id) " +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id) " +
                "WHERE e.email=\'" + email + "\' AND t.state=\'" + state + "\'";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }


    public double countTakings(String email, long type) {
        String query;
        if (type == 0) {
            query = "SELECT sum(o.price) FROM offer o\n" +
                    "LEFT JOIN transaction t ON (t.offer_id=o.id)\n" +
                    "            LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                    "            LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)\n" +
                    "WHERE email = '" + email + "';";
        } else {
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime() - type);
            query = "SELECT sum(o.price) FROM offer o\n" +
                    "LEFT JOIN transaction t ON (t.offer_id=o.id)\n" +
                    "            LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                    "            LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)\n" +
                    "WHERE email = \'" + email + "\' " +
                    "AND date > \'" + date.toString() + "\'";
        }
        Double result = jdbcTemplate.queryForObject(query, Double.class);
        return result == null ? 0 : result;
    }

    public List<Order> getPendingOrdersForRestaurant(String email, int limit, int offset) {
        String query = "SELECT t.date,o.price,t.id,o.description, t.receive_time, t.code \n" +
                "FROM offer o\n" +
                "LEFT JOIN transaction t ON (t.offer_id=o.id)\n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)\n" +
                "                   WHERE email = \'" + email + "\'\n" +
                "                   AND state='PENDING' " +
                "LIMIT " + limit + " offset " + offset + ";";
        return jdbcTemplate.query(query, ((rs, rowNum) -> {
            CurrentOrder result = new CurrentOrder();
            result.setId(rs.getInt(3));
            result.setOrderTime(rs.getTimestamp(1).toLocalDateTime().toString());
            result.setReceiveTime(rs.getTimestamp(5).toLocalDateTime().toString());
            result.setPrice(rs.getDouble(2));
            result.setName(rs.getString(4));
            result.setPaymentCode(rs.getString(6));
            return result;
        }));
    }

    public List<Order> findAllByRestaurant(String email, int limit, int offset) {
        String query = "SELECT t.date,o.price,t.id,o.description, t.receive_time, t.state, t.code \n" +
                "FROM transaction t\n" +
                "LEFT JOIN offer o ON (t.offer_id=o.id)\n" +
                "LEFT JOIN restaurant r ON (r.id=o.restaurant_id)\n" +
                "LEFT JOIN restaurant_employee e ON (r.id=e.restaurant_id)\n" +
                "                   WHERE email = '" + email + "' " +
                "LIMIT " + limit + " offset " + offset + ";";
        return jdbcTemplate.query(query, ((rs, rowNum) -> {
            HistoricOrder result = new HistoricOrder();
            result.setId(rs.getInt(3));
            result.setOrderTime(rs.getTimestamp(1).toLocalDateTime().toString());
            result.setReceiveTime(rs.getTimestamp(5).toLocalDateTime().toString());
            result.setPrice(rs.getDouble(2));
            result.setName(rs.getString(4));
            result.setState(rs.getString(6));
            result.setPaymentCode(rs.getString(6));
            return result;
        }));
    }

}
