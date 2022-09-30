package com.masai.useCases;

import java.util.Scanner;

import com.masai.Bean.Faculty;
import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;



public class UpdateFacultyUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter Faculty Id");
		 int fid=sc.nextInt();
		 
		 Faculty f=new Faculty();
		 
		f.setFacultyId(fid);
		  FacultyDao dao= new FacultyDaoImpl();
		  String message=dao.UpdateFaculty(f);
		  
		  System.out.println(message);

	}

}
