package com.YiDong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.YiDong.util.DbUtil;

public class MobileNumberDao {
	public boolean choose(long startNumber, long endNumber, String type) {
		int[] rs = null;
		String sql = "insert into TMobiles values(?,?,'123123','可用')";
		Connection connection = null;
		try {
			connection = DbUtil.getConn();
			connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(sql);
			int count = 0;
			for (long i = startNumber; i <= endNumber; i++) {
				ps.setLong(1, i);
				ps.setString(2, type);
				ps.addBatch();
				count++;
				if (count >= 50000 || i == endNumber) {
					rs = ps.executeBatch();
					connection.commit();
					System.out.println(rs.toString() + "---" + rs.length);
					count = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DbUtil.closeAll();
		}
		return (rs != null);
	}

	public static void main(String[] args) {
		MobileNumberDao dao = new MobileNumberDao();
		boolean b = dao.choose(0L, 151234L, "sim");
		System.out.println(b);
	}
}
