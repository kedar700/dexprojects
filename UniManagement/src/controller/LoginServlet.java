package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			UserDAO dao = new UserDAO();
			User user = dao.getUser("email", userName);
			if (user != null && (user.getEmail().toLowerCase().equals(userName.toLowerCase())  && user.getPassword().equals(password))) { 
				HttpSession session = request.getSession(true); 
				session.setAttribute("currentUser", user); 
				if(user.getUserType().equals("Student")){
					response.sendRedirect("enrollment.do"); 
				}else if(user.getUserType().equals("Admin")){
					response.sendRedirect("adminUserHome.jsp"); 
				}else if(user.getUserType().equals("Faculty")){

					response.sendRedirect("facultyHome.do"); 
				}
			} 
			else {
				request.setAttribute("errMsg", "Username/password is invalid.");
				request.getRequestDispatcher("Login.jsp").forward(request,response);
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
