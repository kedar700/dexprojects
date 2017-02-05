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

import model.Course;
import model.Department;
import model.Faculty;
import model.Semester;
import model.dao.CourseDAO;
import model.dao.DepartmentDao;
import model.dao.FacultyDAO;
import model.dao.SemesterDAO;


/**
 * Servlet implementation class Course Controller
 */
@WebServlet("/AdminCourseController")
public class AdminCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter( "action" );
		String forward = "";
		CourseDAO dao = new CourseDAO();
		if( (action == null) || action.equalsIgnoreCase("index") ) {
			ArrayList<Course>  course = dao.getAllCourses();
			request.setAttribute("courses", course);
			forward = "courseIndex.jsp";
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}else if( action.equalsIgnoreCase( "delete" ) ) {
			forward = "courseIndex.jsp";
			String courseId = request.getParameter("courseId");
			Course course =  new Course();
			course.setCourseId(Integer.parseInt(courseId));
			dao.deleteCourse(course);
			response.sendRedirect("course.do"); 
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = "courseEdit.jsp";
			String courseId = request.getParameter("courseId");
			Course course=dao.getCourse("course_id", courseId);
			request.setAttribute("course", course);
			DepartmentDao deptDao = new DepartmentDao();
			ArrayList<Department>  departments = deptDao.getAllDepartments();
			request.setAttribute("departments", departments);
			FacultyDAO factDao = new FacultyDAO();
			ArrayList<Faculty>  faculty = factDao.getAllFaculty();
			request.setAttribute("faculty", faculty);
			SemesterDAO semDao = new SemesterDAO();
			ArrayList<Semester>  semesters = semDao.getAllSemester();
			request.setAttribute("semesters", semesters);
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}    

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course course = new Course();
		CourseDAO dao = new CourseDAO();

		course.setCourseName(request.getParameter("courseName"));
		course.setCapacity(Integer.parseInt(request.getParameter("capacity")));
		course.setSemesterId(Integer.parseInt(request.getParameter("semesterId")));
		course.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
		course.setStartDate(Date.valueOf(request.getParameter("startDate")));
		course.setEndDate(Date.valueOf(request.getParameter("endDate")));
		course.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		String courseId=request.getParameter("courseId");
		System.out.println(courseId);

		if( courseId == null || courseId.isEmpty() )
			dao.addCourse(course);
		else {
			course.setCourseId(Integer.parseInt(courseId));
			dao.updateCourses(course);
		}
		response.sendRedirect("course.do"); 
	}
}
