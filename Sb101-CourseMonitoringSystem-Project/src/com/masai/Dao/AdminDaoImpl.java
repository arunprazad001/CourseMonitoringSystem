package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Bean.Admin;
import com.masai.Exceptions.AdminException;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String CreateAdmin(Admin a) {
		 String message = "Not Registered..";
			
			
			
			
			try(Connection conn= DBUtil.ProvideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement
						("insert into Admin(username,password) values(?,?)");
				
				
				
				ps.setString(1, a.getUsername());
				ps.setString(2,a.getPassword() );
				
				
			
				int x= ps.executeUpdate();
				
				
				if(x > 0)
					message = "Admin added Sucessfully !";
				
				
				
			} catch (SQLException e) {
				message = e.getMessage();
			}
			
			
		
		
			
			return message;
	}

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException {
        Admin ad = null;
		
		try(Connection conn = DBUtil.ProvideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from Admin where username = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				
				String u= rs.getString("username");
				String p= rs.getString("password");
				
				
			ad=new Admin(u,p);	
				
				
			}else
				throw new AdminException("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		
		
		return ad;
		
	}

}
