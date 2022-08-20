package com.productapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoJdbcImpl implements ProductDao {

	private DataSource dataSource;

	
	
	@Autowired
	public ProductDaoJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> getAll() {
		List<Product> productList = new ArrayList<Product>();
		Product product = null;

		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from product_table");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setAvailable(rs.getInt(4)==1);

				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public Product getById(Integer id) {
		Product product = null;

		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement = 
					connection.prepareStatement("select * from product_table where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setAvailable(rs.getInt(4)==1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product addProduct(Product product) {
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement = 
			connection.
			prepareStatement("insert into product_table(id, name, price, isAvailable) values(?,?,?,?)");
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setBigDecimal(3, product.getPrice());
			preparedStatement.setInt(4, (product.isAvailable())?1:0);
			
			preparedStatement.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return product;
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product product=getById(id);
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement = 
			connection.
			prepareStatement("delete from product_table where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return product;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate=getById(id);
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement = 
			connection.
			prepareStatement("update product_table set price =? ,isAvailable=? where id=?");
			preparedStatement.setBigDecimal(1, product.getPrice());
			preparedStatement.setInt(2, (product.isAvailable())?1:0);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return product;
	}

}
