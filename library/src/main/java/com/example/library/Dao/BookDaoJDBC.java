package com.example.library.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.library.Entity.Book;
import com.example.library.Entity.RequestVO;
import com.example.library.Entity.User;
import com.example.library.util.DBConnectionPool;

@Repository
public class BookDaoJDBC {

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();

		String sql = "SELECT * FROM book";

		try (Connection conn = DBConnectionPool.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Book book = new Book();
				book.setiSBN(rs.getString("iSBN"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setIntroduction(rs.getString("introduction"));
				book.setAvailable(rs.getInt("available"));
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public int updateBookStatus(String isbn, int available1, int available2) throws SQLException {
		int rows = 0;
		String sql = "UPDATE book SET available = ? WHERE iSBN = ? and available=?";

		try (Connection conn = DBConnectionPool.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			// 設定參數
			stmt.setInt(1, available1);
			stmt.setString(2, isbn);
			stmt.setInt(3, available2);

			// 執行更新
			rows = stmt.executeUpdate();
			System.out.println("更新" + rows + " 筆資料");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return rows;

	}

	public void insertBorrowingRecord(User user, RequestVO requestVO) {
		String sql = "INSERT INTO borrowingrecord(user_id, iSBN, borrowing_time, status) "
				+ "VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnectionPool.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql)) {

			Timestamp now = new Timestamp(System.currentTimeMillis());
			stmt.setInt(1, user.getUserId());
			stmt.setString(2, requestVO.getiSBN());
			stmt.setTimestamp(3, now );
			stmt.setInt(4, 1);


			int rows = stmt.executeUpdate();
			System.out.println("成功插入 " + rows + " 筆資料。");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBorrowingRecord(User user,RequestVO requestVO) {
		String sql = "UPDATE borrowingrecord SET status = ?, return_time= ? "
				+ "WHERE user_id=? and iSBN = ? and status =1";

		try (Connection conn = DBConnectionPool.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql)) {

			Timestamp now = new Timestamp(System.currentTimeMillis());

			stmt.setInt(1,0);
			stmt.setTimestamp(2, now);
			stmt.setInt(3, user.getUserId() );
			stmt.setString(4, requestVO.getiSBN());


			int rows = stmt.executeUpdate();
			System.out.println("成功更新 " + rows + " 筆資料。");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
