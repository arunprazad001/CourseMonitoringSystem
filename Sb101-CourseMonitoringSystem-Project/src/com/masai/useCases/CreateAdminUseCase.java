package com.masai.useCases;

import java.util.Scanner;

import com.masai.Bean.Admin;
import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;



public class CreateAdminUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter username ");
		 String user=sc.next();
		 System.out.println("Enter password ");
		String pass=sc.next();
		
		  Admin a=new Admin();
		  a.setUsername(user);
		  a.setPassword(pass);
		  AdminDao dao= new AdminDaoImpl();
		  String message=dao.CreateAdmin(a);
		  
		  System.out.println(message);

	}

}
