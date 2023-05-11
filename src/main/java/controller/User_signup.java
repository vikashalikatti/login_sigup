package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_dao;
import dto.User_dto;

@WebServlet("/UserSignup")
public class User_signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User_dto dto = new User_dto();
		User_dao dao = new User_dao();
		
		dto.setName(req.getParameter("name"));
		dto.setUser_name(req.getParameter("username"));
		dto.setEmail(req.getParameter("email"));
		dto.setPassword(req.getParameter("password"));
		dto.setPhone_number(Long.parseLong(req.getParameter("phone")));
		dto.setGender(req.getParameter("gender"));
		
		dao.save(dto);
		
		resp.sendRedirect("user_login.html");
		
	}
}
