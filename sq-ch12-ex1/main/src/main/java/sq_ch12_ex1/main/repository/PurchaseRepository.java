package sq_ch12_ex1.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sq_ch12_ex1.main.model.Purchase;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    // Spring injects JdbcTemplate here.
    // I don’t need to create it myself, Spring gives it to me from the context.
    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Save one purchase into the database
    public void storePurchase(Purchase purchase){

        // SQL insert statement.
        // I use NULL for id because the DB will auto-generate it.
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";

        // jdbc.update() sends the INSERT to the database.
        // The "?" are placeholders -> they get replaced by my object’s values.
        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    // Get all purchases from the database
    public List<Purchase> findAllPurchases() {

        // Simple SELECT to fetch all rows
        String sql = "SELECT * FROM purchase";

        // RowMapper tells JdbcTemplate how to turn each row into a Purchase object.
        // "r" is the ResultSet (row data from DB), "i" is the row number.
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        // Execute query and return the list of Purchase objects
        return jdbc.query(sql, purchaseRowMapper);
    }
}
