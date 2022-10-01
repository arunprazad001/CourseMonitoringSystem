package com.masai.useCases.admin;

import java.util.Scanner;

import com.masai.Bean.Course;
import com.masai.Bean.Faculty;
import com.masai.Dao.CourseDao;
import com.masai.Dao.CourseDaoImpl;
import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;
import com.masai.Exceptions.CourseException;
import com.masai.Exceptions.FacultyException;

public class GetFacultyByIdUseCase {

	public static void ViewFacultyById() {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter faculty id: ");
		  int fid=sc.nextInt();
		
		 
		 
		 
		FacultyDao dao= new FacultyDaoImpl();
		  Faculty f;
		try {
			f = dao.GetFacultyById(fid);
			if(f!=null) {
				System.out.println(f);
			}else {
				System.out.println("faculty doesnt exist");
			}
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 

	}

}
