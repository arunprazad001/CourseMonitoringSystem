package com.masai.useCases;
import java.util.Scanner;

import com.masai.Bean.Admin;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BatchException;
public class LoginAdminUseCase {

	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter username");
	  String username=sc.next();
	  System.out.println("Enter password");
	  String password=sc.next();
	  
	 
	  AdminDao dao=new AdminDaoImpl();
	  Admin a;
	  try {
			a =dao.loginAdmin(username, password);
			if(a!=null) {
				System.out.println("Welcome User");
			}else {
				System.out.println("User Doesnt Exist");
			}
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	 

	}

}
