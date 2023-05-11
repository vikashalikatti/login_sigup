package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_dao;
import dto.User_dto;

@WebServlet("/userlogin")
public class User_login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User_dao userDao = new User_dao();

		User_dto userInfo = userDao.login(username);
		if (userInfo == null) {
			resp.getWriter().print("<h1>Invalid username</h1>");
			req.getRequestDispatcher("user_login.html").include(req, resp);
		} else {
			if (userInfo.getPassword().equals(password)) {
				req.getSession().setAttribute("userInfo", userInfo);
				resp.sendRedirect("login_success.html");
				
			} else {
				resp.getWriter().print("<h1>Invalid password</h1>");
				req.getRequestDispatcher("user_login.html").include(req, resp);
			}
		}
	}
}
