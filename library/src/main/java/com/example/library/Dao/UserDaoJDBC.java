package com.example.library.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import com.example.library.Entity.User;
import com.example.library.util.DBConnectionPool;

@Repository
public class UserDaoJDBC {
	
	public User findUserById(int user_id) {
		String sql = "SELECT * FROM user where user_id= ?";
		

		try (Connection conn = DBConnectionPool.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			stmt.setInt(1,user_id );
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				return user;
			}else{
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	public User findUserByPhoneNumber(String phonenumber) {
		String sql = "SELECT * FROM user where phone_number= ?";
		

		try (Connection conn = DBConnectionPool.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			stmt.setString(1,phonenumber);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setPassword(rs.getString("password"));
				return user;
			}else{
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void insertNewUser(User user) {
		String sql = "INSERT INTO user(phone_number,password,user_name, registration_time) "
				+ "VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnectionPool.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql)) {

			Timestamp now = new Timestamp(System.currentTimeMillis());
			stmt.setString(1, user.getPhoneNumber());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUserName());
			stmt.setTimestamp(4, now );

			int rows = stmt.executeUpdate();
			System.out.println("成功插入 " + rows + " 筆會員資料。");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
