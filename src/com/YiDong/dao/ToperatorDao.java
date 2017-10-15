package com.YiDong.dao;

import java.sql.ResultSet;

import com.YiDong.pojo.Toperator;
import com.YiDong.util.DbUtil;

public class ToperatorDao {
	public Toperator login(String id, String pwd) {
		String sql = "select * from toperator where operator_id=? and operator_pwd=?";
		ResultSet rs = DbUtil.executeQuery(sql, id, pwd);
		Toperator t = null;
		try {
			while (rs.next()) {
				t = new Toperator();
				t.setOperatorId(rs.getInt("operator_id"));
				t.setOperatorName(rs.getString("operator_name"));
				t.setOperatorPassword(rs.getString("operator_pwd"));
				t.setIsAdmin(rs.getInt("is_Admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeAll();
		}
		return t;
	}
}
