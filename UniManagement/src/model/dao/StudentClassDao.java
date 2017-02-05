package model.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import model.StudentClass;

public class StudentClassDao extends Dao {
	public StudentClass getClass(String columnName, String value){
		StudentClass classes = null; 
		try {
			String sql= "select * from classess where " + columnName +  "='" + value + "'";
			rs = executeFetchQuery (sql);			
			if (rs.next()){	
				classes = new StudentClass();
				classes.setClassId(Integer.parseInt(rs.getString("class_id")));
				classes.setCapacity(Integer.parseInt("capacity"));
				classes.setCourseid(Integer.parseInt(rs.getString("course_id")));
				classes.setFacultyId(Integer.parseInt(rs.getString("faculty_id")));
				
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return classes;
	}

	public ArrayList<StudentClass> getAllClass(){	
		ArrayList <StudentClass> list = new ArrayList<StudentClass>();
		try {
			String sql= "select * from classes'" ;
			rs = executeFetchQuery (sql);			

			while (rs.next()){	
				StudentClass classes = new StudentClass();
				classes.setClassId(Integer.parseInt(rs.getString("class_id")));
				classes.setCapacity(Integer.parseInt("capacity"));
				classes.setCourseid(Integer.parseInt(rs.getString("course_id")));
				list.add(classes);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;		
	}


	public boolean addClass(StudentClass classes){
		try {
			String sql= "INSERT INTO classes(class_id,capacity,faculty_id,course_id) values('" +
					classes.getClassId() + "','" + classes.getCapacity() + "','"  + classes.getFacultyId()+ "','" + classes.getCourseid()+ "')";
			executeModifySelectQuery(sql);				
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	public void updateClasses(StudentClass classes){
		try {
			String sql= "UPDATE courses SET class_id = '" + classes.getClassId() + "',capacity='" + classes.getCapacity() + "', faculty_id='" + classes.getFacultyId() + "', course_id='" + classes.getCourseid() + "' ";
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void deleteClasses(StudentClass classes){
		try {
			String sql= "DELETE FROM classes WHERE class_id = " + classes.getClassId();
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
