package com.masai.useCases.admin;

import java.util.Scanner;

import com.masai.Bean.Batch;
import com.masai.Bean.Course;
import com.masai.Dao.BatchDao;
import com.masai.Dao.BatchDaoImpl;
import com.masai.Dao.CourseDao;
import com.masai.Dao.CourseDaoImpl;

public class UpdateBatchUseCase {
    public static void BatchUpdate() {
    	Scanner sc=new Scanner(System.in);
   	 
   	 System.out.println("Enter course id:");
   	 int cid=sc.nextInt();
   	 
   	 Batch b=new Batch();
   	 b.setCourseId(cid);
   	  
   	  BatchDao dao= new BatchDaoImpl();
   	  String message=dao.UpdateBatch(b);   	  
   	  System.out.println(message);
	}
	
}
