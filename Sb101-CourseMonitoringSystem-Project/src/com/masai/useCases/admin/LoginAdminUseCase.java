package com.masai.useCases.admin;
import java.util.Scanner;

import com.masai.Bean.Admin;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.AdminException;



public class LoginAdminUseCase {

	public static boolean AdminLogin() {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter username");
	  String username=sc.next();
	  System.out.println("Enter password");
	  String password=sc.next();
	  
	 
	  AdminDao dao=new AdminDaoImpl();
	  Admin a;
	  boolean res = false;
	  try {
			a =dao.loginAdmin(username, password);
			if(a!=null) {
				System.out.println("Welcome User");
				res = true;
			}else {
				System.out.println("User Doesnt Exist");
			}
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	return res;
	 

	}

}
