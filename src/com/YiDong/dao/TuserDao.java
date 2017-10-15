package com.YiDong.dao;

import com.YiDong.util.DbUtil;

public class TuserDao {
	public int add(long number, String roaming, String level, String cid) {
		String sql = "INSERT INTO TUSER(MOBILE_NUMBER,ROAMING_STATUS,COM_LEVEL,CUSTOMER_ID,IS_AVAILABLE) VALUES (?，?，?，?，'正在使用')";
		int i = DbUtil.executeUpdate(sql, number, roaming, level, cid);
		DbUtil.closeAll();
		return i;
	}

	public static void main(String[] args) {
		TuserDao tud = new TuserDao();
		int i = tud.add(18583826786L, "level", "level", "12311313");
		System.out.println(i);
	}
}
