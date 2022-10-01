package com.masai.useCases.faculty;

import java.util.Scanner;

import com.masai.Bean.Faculty;
import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;
import com.masai.Exceptions.FacultyException;

public class LoginFacultyUseCase {

	public static boolean FacultyLogIn() {
		Scanner sc=new Scanner(System.in);
		  System.out.println("Enter username");
		  String username=sc.next();
		  System.out.println("Enter password");
		  String password=sc.next();
		  
		 
		 FacultyDao dao=new FacultyDaoImpl();
		  Faculty a;
		  boolean res = false;
		  try {
				a =dao.LoginFaculty(username, password);
				if(a!=null) {
					System.out.println("Welcome User:"+" "+a.getFacultyName());
					res = true;
				}else {
					System.out.println("User Doesnt Exist");
				}
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		 
            return res;
		}

	}


