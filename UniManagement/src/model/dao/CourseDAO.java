package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Course;

public class CourseDAO extends Dao{

		public Course getCourse(String columnName, String value){
			Course course = null;  
			try {
				String sql= "select * from courses where " + columnName +  "='" + value + "'";
				rs = executeFetchQuery (sql);			
				if (rs.next()){	
					course = new Course();
					course.setCourseId(Integer.parseInt(rs.getString("course_id")));
					course.setCourseName(rs.getString("course_name"));
					course.setDeptId(rs.getInt("dept_id"));
					course.setStartDate(rs.getDate("startdate"));
					course.setEndDate(rs.getDate("enddate"));
					course.setSemesterId(rs.getInt("semester_id"));
					course.setFacultyId(rs.getInt("faculty_id"));
					course.setCapacity(rs.getInt("capacity"));
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			return course;
		}

		public ArrayList<Course> getAllCourses(){	
			ArrayList <Course> list = new ArrayList<Course>();
			try {
				String sql= "select * from courses" ;
				rs = executeFetchQuery (sql);			

				while (rs.next()){	
					Course course =  new Course();
					course.setCourseId(Integer.parseInt(rs.getString("course_id")));
					course.setCourseName(rs.getString("course_name"));
					course.setDeptId(rs.getInt("dept_id"));
					course.setStartDate(rs.getDate("startdate"));
					course.setEndDate(rs.getDate("enddate"));
					course.setSemesterId(rs.getInt("semester_id"));
					course.setFacultyId(rs.getInt("faculty_id"));
					course.setCapacity(rs.getInt("capacity"));
					list.add(course);
				}

			} 
			catch (SQLException e) {
				e.printStackTrace();
			}	
			return list;		
		}

		public ArrayList<Course> getAllCourses(String columnName, String value){	
			ArrayList <Course> list = new ArrayList<Course>();
			try {
				String sql= "select * from courses where " + columnName +  "='" + value + "'" ;
				rs = executeFetchQuery (sql);			

				while (rs.next()){	
					Course course =  new Course();
					course.setCourseId(Integer.parseInt(rs.getString("course_id")));
					course.setCourseName(rs.getString("course_name"));
					course.setDeptId(rs.getInt("dept_id"));
					course.setStartDate(rs.getDate("startdate"));
					course.setEndDate(rs.getDate("enddate"));
					course.setSemesterId(rs.getInt("semester_id"));
					course.setFacultyId(rs.getInt("faculty_id"));
					course.setCapacity(rs.getInt("capacity"));
					list.add(course);
				}

			} 
			catch (SQLException e) {
				e.printStackTrace();
			}	
			return list;		
		}

		public boolean addCourse(Course course){
			try {
				String sql= "INSERT INTO courses(course_name,dept_id,startdate,enddate,faculty_id,capacity,semester_id) values('" +
						course.getCourseName() + "','" + course.getDeptId()+"','" +course.getStartDate()+"','" +
						course.getEndDate()+"','" +course.getFacultyId()+"','"+ course.getCapacity()+"','"+course.getSemesterId()+ "')";
				executeModifySelectQuery(sql);				
			} 
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return true;
		}

		public void updateCourses(Course course){
			try {
				String sql= "UPDATE courses SET course_name='" + course.getCourseName() +
						"', dept_id='" + course.getDeptId() +"', startdate='" + course.getStartDate() +"', enddate='" + course.getEndDate() +
						 "', faculty_id='" + course.getFacultyId() + "', capacity='" + course.getCapacity() +"', semester_id='" + course.getSemesterId() +"'where course_id="+course.getCourseId();
				executeModifySelectQuery(sql);					
			} 
			catch (Exception e) {
				e.printStackTrace();
			}

		}


		public void deleteCourse(Course course){
			try {
				String sql= "DELETE FROM courses WHERE course_id = " + course.getCourseId();
				executeModifySelectQuery(sql);					
			} 
			catch (Exception e) {
				e.printStackTrace();
			}

		}

	}



