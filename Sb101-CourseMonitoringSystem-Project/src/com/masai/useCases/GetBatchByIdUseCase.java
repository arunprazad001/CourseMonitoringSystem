package com.masai.useCases;

import java.util.Scanner;

import com.masai.Bean.Batch;
import com.masai.Dao.BatchDao;
import com.masai.Dao.BatchDaoImpl;
import com.masai.Exceptions.BatchException;
import com.masai.Exceptions.CourseException;

public class GetBatchByIdUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Enter batch id: ");
		  int bid=sc.nextInt();
		
		 
		 
		 
		 BatchDao dao= new BatchDaoImpl();
		  Batch b;
		try {
			b =dao.getBatchByBatchId(bid);
			if(b!=null) {
				System.out.println(b);
			}else {
				System.out.println("batch doesnt exist");
			}
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		  
	}
	

}
