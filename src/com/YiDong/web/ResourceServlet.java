package com.YiDong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YiDong.dao.MobileNumberDao;

public class ResourceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long startNumber = Long.parseLong(request.getParameter("T1"));
		long endNumber = Long.parseLong(request.getParameter("T2"));
		String mobileType = request.getParameter("R1");
		if (startNumber < 10000000000L || startNumber > 20000000000L || endNumber < 10000000000L
				|| endNumber > 20000000000L) {
			request.setAttribute("msg", "错误：请正确输入号段，号码有11位");
			request.getRequestDispatcher("Resource.jsp").forward(request, response);
		} else {
			if (endNumber < startNumber) {
				request.setAttribute("msg", "错误：请正确输入号段，后面的号段需要比前面大");
				request.getRequestDispatcher("Resource.jsp").forward(request, response);
			} else {
				MobileNumberDao mobileNumberDao = new MobileNumberDao();
				boolean rs = mobileNumberDao.choose(startNumber, endNumber, mobileType);
				if (rs) {
					request.setAttribute("msg", "申请号段成功");
					request.getRequestDispatcher("Resource.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "申请号段失败");
					request.getRequestDispatcher("Resource.jsp").forward(request, response);
				}
			}
		}
	}
}
