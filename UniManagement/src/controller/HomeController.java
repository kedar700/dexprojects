package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		User user = (User)session.getAttribute("currentUser"); 
		if(user.getUserType().toLowerCase().equals("faculty")){
			response.sendRedirect("facultyHome.do"); 
		}else if(user.getUserType().toLowerCase().equals("student")){
			response.sendRedirect("enrollment.do"); 
		}else if(user.getUserType().toLowerCase().equals("admin")){
			response.sendRedirect("adminUserHome.jsp"); 
		}else{
			response.sendRedirect("Login.jsp"); 
		}
	}



}
