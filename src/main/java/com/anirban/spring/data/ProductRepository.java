package com.anirban.spring.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anirban.spring.model.Product;
import com.anirban.spring.model.ProductCategory;

@Repository
public class ProductRepository {

	@Autowired
	private JdbcTemplate template;

	public List<Product> getAllProducts() {
		String sql = "select * from password.Products";
		List<Product> products = template.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				String productId = rs.getString("productId");
				String productDescription = rs.getString("productDescription");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				Product p = new Product();
				p.setCategory(ProductCategory.valueOf(category));
				p.setPrice(price);
				p.setProductDescription(productDescription);
				p.setProductId(productId);
				return p;
			}

		});
		return products;
	}

	public Product getProduct(String productId) {
		String sql = "select * from password.Products where productId=?";
		Product p = template.query(sql, new ResultSetExtractor<Product>() {

			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				String productId = rs.getString("productId");
				String productDescription = rs.getString("productDescription");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				Product p = new Product();
				p.setCategory(ProductCategory.valueOf(category));
				p.setPrice(price);
				p.setProductDescription(productDescription);
				p.setProductId(productId);
				return p;
			}
			
		}, productId);
		return p;
	}

}
