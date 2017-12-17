package controller;

import java.io.IOException;  
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import model.Course;
import model.Faculty;
import model.StudentClass;
import model.dao.CourseDAO;
import model.dao.FacultyDAO;
import model.dao.StudentClassDao;



/**
 * Servlet implementation class Course Controller
 */
@WebServlet("/AdminClassController")
public class AdminClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter( "action" );
		String forward = "";
		StudentClassDao dao = new StudentClassDao();
		if( action.equalsIgnoreCase("index") ) {
	
			ArrayList<StudentClass>  StudentClass = dao.getAllClass();
			request.setAttribute("StudentClass",StudentClass);
			forward = "classIndex.jsp";
		}else if( action.equalsIgnoreCase( "delete" ) ) {
			forward = "classIndex.jsp";
			String classId = request.getParameter("classId");
			StudentClass StudentClass =  new StudentClass();
			StudentClass.setClassId(Integer.parseInt(classId));
			dao.deleteClasses(StudentClass);;
			request.setAttribute("StudentClass", dao.getAllClass());
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = "classEdit.jsp";
			String classId = request.getParameter("classId");
			StudentClass StudentClass=dao.getClass("class_Id", classId);
			request.setAttribute("StudentClass", StudentClass);
			CourseDAO courseDao = new CourseDAO();
			ArrayList<Course>  course = courseDao.getAllCourses();
			request.setAttribute("course", course);
			FacultyDAO facultydao = new FacultyDAO();
			ArrayList<Faculty>  faculty = facultydao.getAllFaculty();
			request.setAttribute("faculty", faculty);
		}    
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentClass StudentClass=new StudentClass();
		StudentClassDao dao=new StudentClassDao();
//		Course course = new Course();
//		CourseDAO dao = new CourseDAO();

		StudentClass.setCapacity(Integer.parseInt(request.getParameter("capacity")));
		StudentClass.setCourseid(Integer.parseInt(request.getParameter("courseId")));
		StudentClass.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
		String classId=request.getParameter("classId");
		

		if( classId == null || classId.isEmpty() )
			dao.addClass(StudentClass);
		else {
			StudentClass.setClassId(Integer.parseInt(classId));
			dao.updateClasses(StudentClass);
			//student.setUserId( Integer.parseInt(studentId));
			//dao.updateStudent(student);
		}
		RequestDispatcher view = request.getRequestDispatcher("classIndex.jsp");
		request.setAttribute("StudentClass", dao.getAllClass());
		view.forward(request, response);
	}
}
