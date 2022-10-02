package com.masai.Dao;

import com.masai.Bean.Admin;
import com.masai.Exceptions.AdminException;

public interface AdminDao {
   
	public String CreateAdmin(Admin a);
	
	public Admin loginAdmin(String username, String password)throws AdminException;
}
