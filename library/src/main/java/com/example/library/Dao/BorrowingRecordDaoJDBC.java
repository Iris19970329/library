package com.example.library.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.library.Entity.Borrowingrecord;
import com.example.library.util.DBConnectionPool;

@Repository
public class BorrowingRecordDaoJDBC {

	public List<Borrowingrecord> getBorrowingRecords(int userid) {
		List<Borrowingrecord> borrowingrecord = new ArrayList<>();

		String sql = "SELECT * FROM borrowingrecord br LEFT JOIN book b ON br.isbn = b.isbn "
				+ "WHERE br.user_id = ? ORDER BY br.borrowing_time DESC";

		try (Connection conn = DBConnectionPool.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			stmt.setInt(1,userid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Borrowingrecord br = new Borrowingrecord();
				br.setUserId(rs.getInt("user_id"));
				br.setiSBN(rs.getString("iSBN"));
				
				Timestamp rtime = rs.getTimestamp("return_time");
				LocalDateTime returntime = (rtime != null) ? rtime.toLocalDateTime() : null;
				br.setReturnTime(returntime);
				
				Timestamp btime = rs.getTimestamp("borrowing_time");
				LocalDateTime borrowtime = (btime != null) ? btime.toLocalDateTime() : null;
				br.setBorrowingTime(borrowtime);
				
				br.setStatus(rs.getInt("status"));
				br.setBookname(rs.getString("name"));
				borrowingrecord.add(br);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowingrecord;
	}
}
