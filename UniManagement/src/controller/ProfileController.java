package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.Enrollment;
import model.Student;
import model.User;
import model.dao.EnrollmentDAO;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		String action = request.getParameter( "action" );
		User user = (User)session.getAttribute("currentUser");
		String forward = "";
		EnrollmentDAO dao = new EnrollmentDAO();
		if( action.equalsIgnoreCase("profile") ) {
			Address address = user.getAddress();
			request.setAttribute("user", user);
			request.setAttribute("address", address);
			forward = "profile.jsp";
		}  
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}


}
