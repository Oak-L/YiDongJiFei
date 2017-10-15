package com.YiDong.dao;

import java.sql.ResultSet;

import com.YiDong.pojo.Tcustomer;
import com.YiDong.util.DbUtil;

public class TcustomerDao {
	public Tcustomer find(String idType, String idNumber) {
		String sql = "select * from Tcustomer where ID_TYPE=? and ID_NUMBER=?";
		ResultSet rs = DbUtil.executeQuery(sql, idType, idNumber);
		Tcustomer t = null;
		try {
			while (rs.next()) {
				t = new Tcustomer();
				t.setTcustomerId(rs.getInt("CUSTOMER_ID"));
				t.setTcustomerIdType(rs.getString("ID_TYPE"));
				t.setTcustomerIdNumber(rs.getString("ID_NUMBER"));
				t.setTcustomerName(rs.getString("CUSTOMER_NAME"));
				t.setTcustomerBirthday(rs.getString("CUSTOMER_BIRTYDAY"));
				t.setTcustomerSex(rs.getString("CUSTOMER_SEX"));
				t.setTcustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeAll();
		}
		return t;
	}

	public int add(String idType, String idNumber) {
		String sql = "INSERT INTO TCUSTOMER(ID_TYPE,ID_NUMBER) VALUES (?，?)";
		int i = DbUtil.executeUpdate(sql, idType, idNumber);
		DbUtil.closeAll();
		return i;
	}

	public int update(Tcustomer tc) {
		String sql = "update TCUSTOMER set CUSTOMER_NAME=?, CUSTOMER_SEX=? ,CUSTOMER_BIRTYDAY=? ,CUSTOMER_ADDRESS=? where ID_NUMBER=?";
		int i = DbUtil.executeUpdate(sql, tc.getTcustomerName(), tc.getTcustomerSex(), tc.getTcustomerBirthday(),
				tc.getTcustomerAddress(), tc.getTcustomerIdNumber());
		DbUtil.closeAll();
		return i;
	}

	public static void main(String[] args) {
		TcustomerDao t = new TcustomerDao();
		// int i = t.add("身份证", "13123123123132");
		Tcustomer tc = t.find("身份证", "510104199509012373");

		System.out.println(tc);
	}
}
