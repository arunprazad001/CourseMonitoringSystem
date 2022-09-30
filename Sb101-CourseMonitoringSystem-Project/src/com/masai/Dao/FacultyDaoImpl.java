package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Bean.Admin;
import com.masai.Bean.Course;
import com.masai.Bean.Faculty;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.CourseException;
import com.masai.Exceptions.FacultyException;
import com.masai.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public String CreateFaculty(Faculty faculty) {
		String message = "Not Registered..";
		
		
		
		
		try(Connection conn= DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into faculty(facultyId,facultyName,facultyAddress,mobile,email,username,password) values(?,?,?,?,?,?,?)");
			
			
			
			ps.setInt(1, faculty.getFacultyId());
			ps.setString(2,faculty.getFacultyName() );
			ps.setString(3,faculty.getFacultyAddress() );
			ps.setString(4,faculty.getMobile() );
			ps.setString(5,faculty.getEmail() );
			ps.setString(6,faculty.getUserName()) ;
			ps.setString(7,faculty.getPassword() );
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Faculty Created Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		return message;
	
	}

	@Override
	public String UpdateFaculty(Faculty faculty) {
     String message = "Nothing to Update!";
		
		
		
		
		try(Connection conn= DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("update faculty set facultyaddress='TVM' where facultyId=? ");
			ps.setInt(1,faculty.getFacultyId());
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Updated Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		return message;
	}

	@Override
	public Faculty GetFacultyById(int facultyId) throws FacultyException {

		Faculty f =null;
		
		
		try (Connection conn= DBUtil.ProvideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from faculty where facultyId=?");
			
			
			ps.setInt(1, facultyId);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int fid= rs.getInt("facultyId");
				String fname= rs.getString("facultyName");
				String fadd=rs.getString("facultyAddress");
				String fmob= rs.getString("mobile");
				String fe= rs.getString("email");
				String fuser= rs.getString("username");
				String fpass= rs.getString("password");
				
				
			f=new Faculty(fid,fname,fadd,fmob,fe,fuser,fpass);
				
				
			}else
				throw new FacultyException("Faculty does not exist with id "+facultyId);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new FacultyException(e.getMessage());
			
			
		}
		
	
	
	
		return f;
		
		
	}

	@Override
	public Faculty LoginFaculty(String username, String password) throws FacultyException {
		Faculty fa = null;
			
			try(Connection conn = DBUtil.ProvideConnection()) {
				
				
				PreparedStatement ps= conn.prepareStatement("select * from Faculty where username = ? AND password = ?");			
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				ResultSet rs= ps.executeQuery();
				
				
					if(rs.next()) {
					
					int fid=rs.getInt("facultyId");
					String fname= rs.getString("facultyName");
					String fad= rs.getString("facultyAddress"); 
					String fmob=rs.getString("mobile");
					String femail=rs.getString("email");
					String u= rs.getString("username");
					String p= rs.getString("password");
					
					
				fa=new Faculty(fid,fname,fad,fmob,femail,u,p);	
					
					
				}else
					throw new FacultyException("Invalid Username or password.. ");
				
				
				
				
			} catch (SQLException e) {
				throw new FacultyException(e.getMessage());
			}
			
			
			
			return fa;
	}

	

	@Override
	public String ShowFacultyAllocated(String s) {
		String message="No faculties allocated!";
		try(Connection conn = DBUtil.ProvideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select f.facultyId,f.facultyName,b.batchId,b.courseId from Faculty f "
					+"INNER JOIN batch b INNER JOIN course c ON b.facultyId=f.facultyId AND c.courseId=b.courseId AND"
					+ "c.courseName=? ");			
			
			ps.setString(1, s);
			
			
			ResultSet rs= ps.executeQuery();
			
			
				while(rs.next()) {
				
				message="faculty details :"	;
				int fid=rs.getInt("facultyId");
				String fname= rs.getString("facultyName");
				String fad= rs.getString("facultyAddress"); 
				int bid=rs.getInt("batchId");
				int cid=rs.getInt("courseId");
				
				
			System.out.println("Faculty id  :"+fid);
			System.out.println("Faculty name  :"+fname);
			System.out.println("Batch id  :"+bid);
			System.out.println("course id  :"+cid);
				
				
		  }
			
			
			
		} catch (SQLException e) {
//			throw new FacultyException(e.getMessage());
			System.out.println(e.getMessage());
		}
		
		
		
		return message;
	}

}
