package com.YiDong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YiDong.dao.ToperatorDao;
import com.YiDong.pojo.Toperator;
import com.YiDong.util.MD5;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接调跳
		String login = request.getParameter("username");
		String pwd = request.getParameter("password");
		String remember = request.getParameter("remember");
		String md5Key = null;
		if (pwd.length() <= 16) {
			MD5 md5 = new MD5();
			md5Key = md5.getMD5ofStr(pwd);
		} else {
			md5Key = pwd;
		}
		if ("yes".equals(remember)) {
			Cookie cl = new Cookie("username", login);
			Cookie cp = new Cookie("password", md5Key);
			Cookie cr = new Cookie("remember", remember);
			cl.setMaxAge(60 * 60 * 24 * 3);
			cp.setMaxAge(60 * 60 * 24 * 3);
			cr.setMaxAge(60 * 60 * 24 * 3);
			response.addCookie(cl);
			response.addCookie(cp);
			response.addCookie(cr);
		}
		ToperatorDao td = new ToperatorDao();
		Toperator t = td.login(login, md5Key);
		if (t == null) {
			request.setAttribute("msg", "<script type='text/javascript'>alert('用户名或密码不正确！');</script>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", t);
			// 转发
			request.getRequestDispatcher("main.jsp").forward(request, response);
			// 重定向
			// response.sendRedirect("main.jsp");
		}
	}

}