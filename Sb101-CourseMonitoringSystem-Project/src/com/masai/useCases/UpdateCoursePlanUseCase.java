package com.masai.useCases;

import java.util.Scanner;

import com.masai.Bean.CoursePlan;
import com.masai.Bean.Faculty;
import com.masai.Dao.CoursePlanDao;
import com.masai.Dao.CoursePlanDaoImpl;
import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;

public class UpdateCoursePlanUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter plan Id");
		 int pid=sc.nextInt();
		 
		 CoursePlan cp=new CoursePlan();
		 
		cp.setPlanId(pid);
		  CoursePlanDao dao= new CoursePlanDaoImpl();
		  String message=dao.UpdateCoursePlan(cp);
		  
		  System.out.println(message);

	}

}
