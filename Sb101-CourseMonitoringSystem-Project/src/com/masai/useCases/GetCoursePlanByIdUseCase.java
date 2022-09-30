package com.masai.useCases;

import java.util.Scanner;

import com.masai.Bean.CoursePlan;
import com.masai.Dao.CoursePlanDao;
import com.masai.Dao.CoursePlanDaoImpl;
import com.masai.Exceptions.CoursePlanException;



public class GetCoursePlanByIdUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter course id: ");
		  int pid=sc.nextInt();
		
		 
		 
		 
		 CoursePlanDao dao= new CoursePlanDaoImpl();
		  CoursePlan cp;
		try {
			cp = dao.getCoursePlanByPlanId(pid);
			if(cp!=null) {
				System.out.println(cp);
			}else {
				System.out.println("courseplan doesnt exist");
			}
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		  

	}

}
