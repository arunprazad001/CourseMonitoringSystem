package com.masai.useCases.admin;
import java.util.Scanner;

import com.masai.Bean.Course;
import com.masai.Dao.CourseDao;
import com.masai.Dao.CourseDaoImpl;
import com.masai.Exceptions.CourseException;
public class UpdateCourseUseCase {
  
	
	public static void CourseUpdate() {
		Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter course Id");
		 int cid=sc.nextInt();
		 
		  Course c=new Course();
		 
		 c.setCourseId(cid);
		  CourseDao dao= new CourseDaoImpl();
		  String message=dao.UpdateCourse(c);
		  
		  System.out.println(message);
	}
}
