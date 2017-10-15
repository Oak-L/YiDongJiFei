package com.YiDong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {

	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}

	public static int executeUpdate(String sql, Object... pars) {
		int result = -1;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < pars.length; i++) {
				ps.setObject(i + 1, pars[i]);
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ResultSet executeQuery(String sql, Object... pars) {
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < pars.length; i++) {
				ps.setObject(i + 1, pars[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs;
	}

	public static void closeAll() {
		if (rs != null) {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}
}
