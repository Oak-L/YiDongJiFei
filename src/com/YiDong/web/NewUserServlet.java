package com.YiDong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YiDong.dao.TuserDao;
import com.YiDong.pojo.Tcustomer;

public class NewUserServlet extends HttpServlet {

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
		long number = Long.parseLong(request.getParameter("T1"));
		String roaming = request.getParameter("R1");
		String level = request.getParameter("R2");
		String cid = request.getParameter("T2");
		TuserDao tud = new TuserDao();
		int i = tud.add(number, roaming, level, cid);
		if (i > 0) {
			System.out.println("新用户创建1：" + i);
			session.setAttribute("currentCustomer", tc);
			request.setAttribute("msg", "新用户创建成功！");
			request.getRequestDispatcher("NewUser.jsp").forward(request, response);
		} else {
			System.out.println("新用户创建1：" + i);
			// HttpSession session = request.getSession();
			// session.setAttribute("currentCustomer", tc);
			request.setAttribute("msg", "新用户创建失败！");
			request.getRequestDispatcher("NewUser.jsp").forward(request, response);
		}
	}
}
