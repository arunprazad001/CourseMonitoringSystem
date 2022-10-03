package com.masai.useCases.faculty;
import com.masai.Bean.Faculty;
import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;
import com.masai.Exceptions.FacultyException;

import java.util.Scanner;

public class FacultyUpdatePassword {

	public static void passwordUpdate() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter current password");
		String currpass=sc.next();
	    System.out.println("Enter new password");
	    String newpass=sc.next();
	    
	    FacultyDao dao=new FacultyDaoImpl();
	    Faculty f=new Faculty();
		try {
			f = dao.LoginFaculty(username, currpass);
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    if(username.equalsIgnoreCase(f.getUserName()) && currpass.equalsIgnoreCase(f.getPassword())) {
//	    	dao.UpdatePassword(f, newpass);
//	    }
		dao.UpdatePassword(f, newpass);
	}

}
