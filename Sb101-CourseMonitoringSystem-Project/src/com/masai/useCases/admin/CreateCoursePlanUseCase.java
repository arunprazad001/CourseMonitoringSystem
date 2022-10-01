package com.masai.useCases.admin;

import java.util.Scanner;

import com.masai.Bean.CoursePlan;
import com.masai.Dao.CoursePlanDao;
import com.masai.Dao.CoursePlanDaoImpl;



public class CreateCoursePlanUseCase {

	public static void CoursePlanCreate() {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter plan id: ");
		  int pid=sc.nextInt();
		 System.out.println("Enter batch id: ");
		 int bid=sc.nextInt();
		 System.out.println("Enter day number");
		 int dno=sc.nextInt();
		 System.out.println("Enter topic");
		 String topic=sc.next();
		 System.out.println("Enter status");
		 String stat=sc.next();
		  CoursePlan c=new CoursePlan();
		 c.setPlanId(pid);
		 c.setBatchId(bid);
		 c.setDaynumber(dno);
		 c.setTopic(topic);
		 c.setStatus(stat);
		  CoursePlanDao dao= new CoursePlanDaoImpl();
		  String message=dao.CreateCoursePlan(c);
		  
		  System.out.println(message);

	}

}
