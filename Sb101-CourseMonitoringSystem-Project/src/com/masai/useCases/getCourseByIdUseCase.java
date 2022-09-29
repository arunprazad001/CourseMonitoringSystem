package com.masai.useCases;
import java.util.Scanner;

import com.masai.Bean.Course;

import com.masai.Dao.CourseDao;
import com.masai.Dao.CourseDaoImpl;
import com.masai.Exceptions.CourseException;
public class getCourseByIdUseCase {
   
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter course id: ");
		  int cid=sc.nextInt();
		
		 
		 
		 
		 CourseDao dao= new CourseDaoImpl();
		  Course cr;
		try {
			cr = dao.getCourseById(cid);
			if(cr!=null) {
				System.out.println(cr);
			}else {
				System.out.println("course doesnt exist");
			}
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		  
	}
}
