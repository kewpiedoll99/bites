package com.barclayadunn.database;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.core.SqlParameter;
import javax.sql.DataSource;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.barclayadunn.product.Product;

public class ProductManagerDaoJdbc implements ProductManagerDao {

    protected final Log logger = LogFactory.getLog(getClass());
    private DataSource ds;

    public List getProductList() {
        logger.info("Getting products!");
        ProductQuery pq = new ProductQuery(ds);
        return pq.execute();
    }

    public void increasePrice(Product prod, int pct) {
        logger.info("Increasing price by " + pct + "%");
        SqlUpdate su =
            new SqlUpdate(ds, "update products set price = price * (100 + ?) / 100 where id = ?");
        su.declareParameter(new SqlParameter("increase", Types.INTEGER));
        su.declareParameter(new SqlParameter("ID", Types.INTEGER));
        su.compile();
        Object[] oa = new Object[2];
        oa[0] = new Integer(pct);
        oa[1] = new Integer(prod.getId());
        int count = su.update(oa);
        logger.info("Rows affected: " + count);
    }

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }


    class ProductQuery extends MappingSqlQuery {

        ProductQuery(DataSource ds) {
            super(ds, "SELECT id, description, price from products");
            compile();
        }

        protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product prod = new Product();
            prod.setId(rs.getInt("id"));
            prod.setDescription(rs.getString("description"));
            prod.setPrice(new Double(rs.getDouble("price")));
            return prod;
        }
    }
}