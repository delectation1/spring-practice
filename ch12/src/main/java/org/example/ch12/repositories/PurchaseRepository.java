package org.example.ch12.repositories;

import org.example.ch12.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // takes a param that represents data to be stored, query is written as string
    // ? replace queries' parameter values -> id null as DBMS configured to generate this val
    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase VALUES (null, ?, ?)";
        // jdbc update send squery to db server, first param is query, next is values same order
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice()); // as ? in query
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * from purchase";

        // r -> ResultSet, i -> int representing row number
        RowMapper<Purchase> purchaseRowMapper = (r, i ) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject; // convert into purchase object
        };
        // run select query and provide rowmapper to jdbctemplate so it can transform data
        return jdbc.query(sql, purchaseRowMapper);
    }
}