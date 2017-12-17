package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.Department;
import model.Student;
import model.User;
import model.dao.AddressDAO;
import model.dao.DepartmentDao;
import model.dao.StudentDAO;

/**
 * Servlet implementation class Address
 */
@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter( "action" );
		String forward = "";
		HttpSession session = request.getSession(true); 
		if( action.equalsIgnoreCase( "edit" ) ) {
			forward = "addressEdit.jsp";
			action = request.getParameter("action" );
			User user = (User)session.getAttribute("currentUser");
			
			Address address = user.getAddress();
			request.setAttribute("address", address);

		}    
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		Address address = new Address();
		AddressDAO dao = new AddressDAO();
		address.setAddressline1(request.getParameter("addressline1"));
		address.setAddressline2(request.getParameter("addressline2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setPhone(request.getParameter("phone"));
		address.setZip(request.getParameter("zip"));
		User user = (User)session.getAttribute("currentUser");
		address.setUserId(user.getUserId());
		String addressId = request.getParameter("addressId");

		if( addressId == null || addressId.isEmpty() )
			dao.addAddress(address);
		else {
			address.setAddressId( Integer.parseInt(addressId));
			dao.updateAddress(address);
		}
		RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
		request.setAttribute("address", address);
		request.setAttribute("user",user);
		view.forward(request, response);

	}

}
