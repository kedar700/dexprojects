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

import model.Department;
import model.Student;
import model.dao.DepartmentDao;
import model.dao.StudentDAO;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/AdminDepartmentController")
public class AdminDepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter( "action" );
		String forward = "";
		DepartmentDao dao = new DepartmentDao();
		if((action == null) || action.equalsIgnoreCase("index") ) {
			ArrayList<Department>  departments = dao.getAllDepartments();
			request.setAttribute("departments", departments);
			forward = "departmentIndex.jsp";
		}else if( action.equalsIgnoreCase( "delete" ) ) {
			forward = "departmentIndex.jsp";
			String departmentId = request.getParameter("departmentId");
			Department department =  new Department();
			department.setDeptId(Integer.parseInt(departmentId));
			dao.deleteDepartment(department);
			request.setAttribute("departments", dao.getAllDepartments());
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = "departmentEdit.jsp";
			String departmentId = request.getParameter("departmentId");
			Department department = dao.getDepartment("dept_id", departmentId);
			request.setAttribute("department", department);
		}    
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Department dept =  new Department();
		DepartmentDao dao = new DepartmentDao();
		dept.setDeptName(request.getParameter( "deptName" ));
		String deptId = request.getParameter("departmentId");

		if( deptId == null || deptId.isEmpty() )
			dao.addDepartment(dept);
		else {
			dept.setDeptId( Integer.parseInt(deptId));
			dao.updateDepartment(dept);
		}
		response.sendRedirect("department.do"); 
	}
}
