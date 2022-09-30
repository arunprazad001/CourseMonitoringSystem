package com.masai.useCases;
import java.util.Scanner;

import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;
public class ShowFacultyAllocatedUseCase {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter course name");
	String course=sc.next();
	
	FacultyDao dao=new FacultyDaoImpl();
	  String c=dao.ShowFacultyAllocated(course);
	  System.out.println(c);

	}

}
