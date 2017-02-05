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
 * Servlet implementation class StudentController
 */
@WebServlet("/AdminStudentController")
public class AdminStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter( "action" );
		String forward = "";
		StudentDAO dao = new StudentDAO();
		if( (action == null) || action.equalsIgnoreCase("index") ) {
			ArrayList<Student>  students = dao.getAllStudents();
			request.setAttribute("students", students);
			forward = "StudentIndex.jsp";
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}else if( action.equalsIgnoreCase( "delete" ) ) {
			String studentId = request.getParameter("studentId");
			Student student =  new Student();
			student.setUserId(Integer.parseInt(studentId));
			dao.deleteStudent(student);
			response.sendRedirect("student.do"); 
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = "StudentEdit.jsp";
			String studentId = request.getParameter("studentId");
			Student student = dao.getStudent("user_id", studentId);
			request.setAttribute("student", student);
			DepartmentDao deptDao = new DepartmentDao();
			ArrayList<Department>  departments = deptDao.getAllDepartments();
			request.setAttribute("departments", departments);
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}    

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		StudentDAO dao = new StudentDAO();

		student.setFirstName( request.getParameter( "firstName" ) );
		student.setLastName( request.getParameter( "lastName" ) );
		student.setEmail( request.getParameter("email"));
		student.setCwId(request.getParameter("cwId"));
		student.setDeptId(Integer.parseInt(request.getParameter("departmentId")));
		student.setDob(Date.valueOf(request.getParameter("Dob")));
		student.setPassword( request.getParameter("password"));
		student.setPhone(request.getParameter("phone"));
		student.setUserType("Student");
		String studentId = request.getParameter("studentId");
		

		if( studentId == null || studentId.isEmpty() )
			dao.addStudent(student);
		else {
			student.setUserId( Integer.parseInt(studentId));
			dao.updateStudent(student);
		}
		response.sendRedirect("student.do"); 
	}
}
