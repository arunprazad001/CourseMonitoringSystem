package com.masai.useCases;
import java.util.Scanner;

import com.masai.Bean.Course;
import com.masai.Dao.CourseDao;
import com.masai.Dao.CourseDaoImpl;
public class CreateCourseUseCase {
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter course id: ");
		  int cid=sc.nextInt();
		 System.out.println("Enter courseName: ");
		 String cname=sc.next();
		 System.out.println("Enter course fee");
		 int cfee=sc.nextInt();
		 System.out.println("Enter course description");
		 String cdesc=sc.next();
		  Course c=new Course();
		  c.setCourseId(cid);
		  c.setCourseName(cname);
		  c.setFee(cfee);
		  c.setCourseDescription(cdesc);
		  CourseDao dao= new CourseDaoImpl();
		  String message=dao.CreateCourse(c);
		  
		  System.out.println(message);
	}
	
  
}
