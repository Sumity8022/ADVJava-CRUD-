package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter wrt = resp.getWriter();

		String email = req.getParameter("email");
		String pwd = req.getParameter("pass");

		UserService us = (UserService) new UserServiceImpl();
		User user = us.getUserByEmail(email, pwd);

		if (user != null && user.getRole().equalsIgnoreCase("admin")) {

			HttpSession session = req.getSession();
			session.setAttribute("loggedinUSer", user);
			resp.sendRedirect("admin.jsp");

		} else if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedinUSer", user);
			resp.sendRedirect("courses.jsp");

		} else {
			String msg = "Invalid credentials !!!";
			HttpSession session = req.getSession();
			session.setAttribute("loginmsg", msg);
			resp.sendRedirect("login.jsp");
		}

	}

}