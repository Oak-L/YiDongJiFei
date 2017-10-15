package com.YiDong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YiDong.dao.TcustomerDao;
import com.YiDong.pojo.Tcustomer;

public class NewCustomer1Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Tcustomer tc = (Tcustomer) session.getAttribute("currentCustomer");
		tc.setTcustomerAddress(request.getParameter("T4"));
		tc.setTcustomerSex(request.getParameter("R1"));
		tc.setTcustomerName(request.getParameter("T1"));
		tc.setTcustomerBirthday(request.getParameter("T3"));
		TcustomerDao td = new TcustomerDao();
		int i = td.update(tc);
		if (i > 0) {
			System.out.println("新客户创建1：" + i);
			session.setAttribute("currentCustomer", tc);
			request.setAttribute("msg", "客户信息更新成功!");
			request.getRequestDispatcher("NewUser.jsp").forward(request, response);
		} else {
			System.out.println("新客户创建1：" + i);
			session.setAttribute("currentCustomer", tc);
			request.setAttribute("msg", "客户信息更新成功!");
			request.getRequestDispatcher("NewCustomer1.jsp").forward(request, response);
		}
	}
}
