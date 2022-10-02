package com.masai.useCases.admin;

import java.util.Scanner;

import com.masai.Bean.Batch;
import com.masai.Bean.Course;
import com.masai.Dao.BatchDao;
import com.masai.Dao.BatchDaoImpl;
import com.masai.Dao.CourseDao;
import com.masai.Dao.CourseDaoImpl;

public class CreateBatchUseCase {

	public static void BatchCreate() {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter batch id: ");
		  int bid=sc.nextInt();
		 System.out.println("Enter course id ");
		  int cid=sc.nextInt();
		 System.out.println("Enter faculty id");
		 int fid=sc.nextInt();
		 System.out.println("Enter no of students");
		 int no=sc.nextInt();
		 System.out.println("Enter batch start date");
		 String date=sc.next();
		 System.out.println("Enter duration");
		 String dur=sc.next();
		  Batch b=new Batch();
		  b.setBatchId(bid);
		  b.setCourseId(cid);
		  b.setFacultyId(fid);
		  b.setNumberofStudents(no);
		  b.setBatchstartDate(date);
		  b.setDuration(dur);
		  BatchDao dao= new BatchDaoImpl();
		  String message=dao.CreateBatch(b);
		  
		  System.out.println(message);

	}

}
