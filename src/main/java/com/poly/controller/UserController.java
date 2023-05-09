package com.poly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.service.EmailSerVice;
import com.poly.service.UserService;
import com.poly.service.impl.EmailServiceImpl;
import com.poly.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login", "/logout", "/register","/forgotpass"})
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
	private EmailSerVice emailservice = new EmailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(req, resp);
			break;
			
		case "/register":
			doGetRegister(req, resp);
			break;
			
		case "/logout":
			doGetLogOut(session, req, resp);
			break;
		case "/forgotpass":
			doGetForgotpass( req, resp);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, req, resp);
			break;

		case "/register":
			doPostRegister(session, req, resp);
			break;
		case "/forgotpass":
			doPostForgotpass( req, resp);
			break;
		
		}
	}
	
//-----------------------------------------
	
	//-----------------doGetLogin
	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/login.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	//-----------------doGetRegister
	private void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		  // TODO Auto-generated method stub
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/register.jsp");
			requestDispatcher.forward(req, resp);
		}
	
	private void doGetForgotpass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		  // TODO Auto-generated method stub
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/forgotpass.jsp");
			requestDispatcher.forward(req, resp);
		}
	
	//-----------------doGetLogOut
	 private void doGetLogOut(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		 // TODO Auto-generated method stub
			session.removeAttribute(SessionAttr.CURRENT_USER);
			resp.sendRedirect("index");
	  }
	  
//-----------------------------------------
	 
	//-----------------doPostLogin
	private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = userService.login(username, password);
		
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		} else {
			resp.sendRedirect("login");
		}
	}
	
	//-----------------doPostRegister
	private void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		User user = userService.register(username, password, email);
		
		if (user != null) {
			emailservice.sendEmail(getServletContext(), user, "wellcome");
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		} else {
			resp.sendRedirect("register");
		}
	}
	private void doPostForgotpass( HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
		resp.setContentType("application/json");
		String email = req.getParameter("email");
		User userWithNewPass = userService.resetPassword(email);
		if(userWithNewPass!=null) {
			emailservice.sendEmail(getServletContext(), userWithNewPass, "forgot");
			resp.setStatus(204);
		}else {
			resp.setStatus(400);
		}
	}
}
