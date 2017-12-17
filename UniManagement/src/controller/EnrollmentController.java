package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Course;
import model.Enrollment;
import model.Semester;
import model.Student;
import model.User;
import model.dao.CourseDAO;
import model.dao.EnrollmentDAO;
import model.dao.SemesterDAO;

/**
 * Servlet implementation class EnrollmentController
 */
@WebServlet("/EnrollmentController")
public class EnrollmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */	
	public EnrollmentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		String action = request.getParameter( "action" );
		User student = (User)session.getAttribute("currentUser");
		CourseDAO courseDao = new CourseDAO();
		String forward = "";
		EnrollmentDAO dao = new EnrollmentDAO();

		if(action == null)
		{
			ArrayList<Enrollment>  enrollment = dao.getAllEnrollment(student);
			request.setAttribute("enrollments", enrollment);
			RequestDispatcher view = request.getRequestDispatcher("enrollmentIndex.jsp");
			view.forward(request, response);
		}else if( action.equalsIgnoreCase( "delete" ) ) {
			String enrollmentId = request.getParameter("enrollmentId");
			Enrollment enrollment =  new Enrollment();
			enrollment.setEnrollId((Integer.parseInt(enrollmentId)));
			dao.deleteEnrollments(enrollment);
			response.sendRedirect("enrollment.do"); 
		}
		else if( action.equalsIgnoreCase( "enroll" ) ) {
			String courseId = request.getParameter("courseId");
			Course course = courseDao.getCourse("course_id", courseId);
			if(course!=null){
				Enrollment enrollment =  new Enrollment();
				enrollment.setStudentId(student.getUserId());
				enrollment.setCourseId(Integer.parseInt(courseId));
				enrollment.setCourseName(course.getCourseName());
				enrollment.setStartDate(course.getStartDate());
				enrollment.setEndDate(course.getEndDate());
				enrollment.setSemesterId(course.getSemesterId());
				enrollment.setGrade(0.0);
				dao.addEnrollment(enrollment);
				response.sendRedirect("enrollment.do"); 
			}

		}else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = "enrollmentEdit.jsp";
			SemesterDAO semDao = new SemesterDAO();
			ArrayList<Semester>  semesters = semDao.getAllSemester();
			request.setAttribute("semesters", semesters);
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);

		}else if( action.equalsIgnoreCase( "courses" ) ) {
			String semId = request.getParameter("semId");
			ArrayList<Enrollment>  enrollments = dao.getAllEnrollment(student);
			ArrayList<Course> courses =courseDao.getAllCourses("semester_id", semId);
			String json  = getCourseJSON(courses,enrollments);
			response.getWriter().write(json);

		}
	}




	private String getCourseJSON(ArrayList<Course> courses, ArrayList<Enrollment> enrollments){
		ArrayList<CourseData> courseData = new  ArrayList<CourseData>();	
		Iterator<Course> coursesIt = courses.iterator();
		
		ArrayList<Integer> enrolledCourseIds =  new  ArrayList<Integer>();;
		for (Enrollment enrollment : enrollments ){
			enrolledCourseIds.add(enrollment.getCourseId());
		}
		
		            
		String json;
		while (coursesIt.hasNext()) {
			Course course = coursesIt.next();
			CourseData cData = new CourseData();
			cData.courseId = course.getCourseId();
			cData.capacity = course.getCapacity();
			cData.courseName = course.getCourseName();
			cData.facultyName = course.getFacultyName();
			cData.startDate = course.getStartDate().toString();
			cData.endDate = course.getEndDate().toString();
			cData.isEnrolled = enrolledCourseIds.contains(course.getCourseId());
			courseData.add(cData);		
		}
		if(courseData.size() != 0){
			json = new Gson().toJson(new SuccessData(courseData));
		}else {
			json = new Gson().toJson(new FailData());
		}

		return json;
	}

}

class SuccessData{
	Boolean success;
	ArrayList<CourseData> courseData;

	public SuccessData( ArrayList<CourseData> courseData){
		this.success = true;
		this.courseData = courseData;
	}	
}

class FailData{
	Boolean success;

	public FailData(){
		this.success = false;

	}	
}

class CourseData{
	Integer courseId;
	String courseName;
	String facultyName;
	Integer capacity;
	String startDate;
	String endDate;
	Boolean isEnrolled;
}
