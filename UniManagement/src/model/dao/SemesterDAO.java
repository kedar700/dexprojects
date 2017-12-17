package model.dao;

import java.sql.SQLException; 
import java.util.ArrayList;


import model.Semester;

public class SemesterDAO extends Dao{

	public Semester getSemester(String columnName, String value){
		Semester sem = null;  
		try {
			String sql= "select * from semesters where " + columnName +  "='" + value + "'";
			rs = executeFetchQuery (sql);			
			if (rs.next()){	
				sem = new Semester();
				sem.setSemesterId(rs.getInt("semester_id"));
				sem.setSemesterType(rs.getString("semester_type"));
				sem.setSemesterYear(rs.getString("semester_year"));
				if(rs.getInt("semester_status")==1){
				sem.setSemesterStatus(true);
				}else{
					sem.setSemesterStatus(false);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sem;
	}
	
	
	public ArrayList<Semester> getAllSemester(){	
		ArrayList <Semester> list = new ArrayList<Semester>();
		try {
			String sql= "select * from semesters where semester_status=1" ;
			rs = executeFetchQuery (sql);			

			while (rs.next()){	
				Semester st=new Semester();
				st.setSemesterId(rs.getInt("semester_id"));
				st.setSemesterType(rs.getString("semester_Type"));
				st.setSemesterYear(rs.getString("semester_year"));
				st.setSemesterStatus(true);
				list.add(st);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;		
	}

}
