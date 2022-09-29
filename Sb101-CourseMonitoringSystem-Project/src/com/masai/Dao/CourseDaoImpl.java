package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Bean.Course;
import com.masai.Exceptions.CourseException;
import com.masai.utility.DBUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public String CreateCourse(Course course) {

		String message = "Not Registered..";
		
			
		
			
			try(Connection conn= DBUtil.ProvideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement
						("insert into course(courseId,courseName,fee,courseDescription) values(?,?,?,?)");
				
				
				
				ps.setInt(1, course.getCourseId());
				ps.setString(2, course.getCourseName());
				ps.setInt(3, course.getFee());
				ps.setString(4, course.getCourseDescription());
				
				int x= ps.executeUpdate();
				
				
				if(x > 0)
					message = "Course Created Sucessfully !";
				
				
				
			} catch (SQLException e) {
				message = e.getMessage();
			}
			
			
		
		
			
			return message;
		
		
	}

	@Override
	public Course getCourseById(int courseId) throws CourseException {
		

		Course course =null;
		
		
		try (Connection conn= DBUtil.ProvideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from course where courseId=?");
			
			
			ps.setInt(1, courseId);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int r= rs.getInt("courseId");
				String n= rs.getString("courseName");
				int f= rs.getInt("fee");
				String cd= rs.getString("courseDescription");
				
				
				
			course=new Course(r, n, f, cd);	
				
				
			}else
				throw new CourseException("Course does not exist with id "+courseId);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new CourseException(e.getMessage());
			
			
		}
		
	
	
	
		return course;
		
		
	}

	@Override
	public String UpdateCourse(Course course) {
		String message = "Nothing to Update!";
		
		
		
		
		try(Connection conn= DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("update course set fee=fee+5000 where courseId=? ");
			ps.setInt(1,course.getCourseId());
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Updated Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		return message;
	
	}

	

}
