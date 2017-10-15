package com.YiDong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YiDong.dao.TcustomerDao;
import com.YiDong.pojo.Tcustomer;

public class NewCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tcustomerIdType = request.getParameter("D1");
		String tcustomerIdNumber = request.getParameter("T2");
		TcustomerDao td = new TcustomerDao();
		Tcustomer tc = td.find(tcustomerIdType, tcustomerIdNumber);
		if (tc == null) {
			int addTc = td.add(tcustomerIdType, tcustomerIdNumber);
			System.out.println("新客户创建：" + addTc);
			tc = td.find(tcustomerIdType, tcustomerIdNumber);
		}
		HttpSession session = request.getSession();
		session.setAttribute("currentCustomer", tc);
		request.getRequestDispatcher("newCustomer1.jsp").forward(request, response);
	}
}
