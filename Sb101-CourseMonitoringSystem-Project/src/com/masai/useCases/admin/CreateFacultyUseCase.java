package com.masai.useCases.admin;

import java.util.Scanner;

import com.masai.Bean.Course;
import com.masai.Bean.Faculty;

import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;

public class CreateFacultyUseCase {

	public static void FacultyCreate() {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter faculty id: ");
		  int fid=sc.nextInt();
		 System.out.println("Enter facultyName: ");
		 String fname=sc.next();
		 System.out.println("Enter faculty address");
		String fa=sc.next();
		 System.out.println("Enter mobile number");
		 String fmob=sc.next();
		 System.out.println("Enter email");
		 String fe=sc.next();
		 System.out.println("Enter username");
		 String fuser=sc.next();
		 System.out.println("Enter password");
		 String fpass=sc.next();
		  Faculty f=new Faculty();
		 f.setFacultyId(fid);
		 f.setFacultyName(fname);
		 f.setFacultyAddress(fa);
		 f.setMobile(fmob);
		 f.setEmail(fe);
		 f.setUserName(fuser);
		 f.setPassword(fpass);
		 
		  FacultyDao dao= new FacultyDaoImpl();
		  String message=dao.CreateFaculty(f);
		  
		  System.out.println(message);

	}

}
