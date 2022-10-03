package com.masai.main;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.useCases.admin.*;
import com.masai.useCases.faculty.*;

public class Main {
	
	
	public static void exitApp() {
		System.out.println("Thankyou");
		
		
	}

	public static void main(String[] args) {
		
System.out.println("Welcome to Course Management System..");
System.out.println("Login user-> 1:admin/2:faculty ");
Scanner sc=new Scanner(System.in);
System.out.println("Enter your choice");
 int choice=sc.nextInt();

   switch(choice) {
   
   case 1:  boolean Alogin = LoginAdminUseCase.AdminLogin();
            if(Alogin) {
            	System.out.println("Enter your choice ");
            	System.out.println("1 : create course \n"
            			+ "2: update course \n"
            			+ "3: view course by id \n"
            			+ "4: view all courses \n"
            			+ "5: create batch \n"
            			+ "6: update batch \n"
            			+ "7: view batch by id \n"
            			+ "8: view all batches \n"
            			+ "9:create faculty \n"
            			+ "10: update faculty \n"
            			+ "11: view faculty by id \n"
            			+ "12: view all faculties \n"
            			+ "13: create course plan \n"
            			+ "14: update course plan \n"
            			+ "15: view course plan by id\n"
            			+ "16: view course plan by id\n "
            			+ "17 : Generate report of every batch \n"
            			+ "18: Exit");
            	System.out.println("Enter your choice");
            	 choice=sc.nextInt();
            	 switch(choice) {
            	 case 1: CreateCourseUseCase.CourseCreation();
            	 break;
            	 case 2: UpdateCourseUseCase.CourseUpdate();
            	 break;
            	 case 3: GetCourseByIdUseCase.ViewCourseById();
            	 break;
            	 case 4: ViewAllCoursesUseCase.AllCourses();
            	 break;
            	 case 5: CreateBatchUseCase.BatchCreate();
            	 break;
            	 case 6: UpdateBatchUseCase.BatchUpdate();
            	 break;
            	 case 7: GetBatchByIdUseCase.ViewBatchById();
            	 break;
            	 case 8: ViewAllBatchesUseCase.AllBatches();
            	 break;
            	 case 9: CreateFacultyUseCase.FacultyCreate();
            	 break;
            	 case 10: UpdateFacultyUseCase.FacultyUpdate();
            	 break;
            	 case 11: GetFacultyByIdUseCase.ViewFacultyById();
            	 break;
            	 case 12: ViewAllFacultiesUseCase.AllFaculties();
            	 break;
            	 case 13: CreateCoursePlanUseCase.CoursePlanCreate();
            	 break;
            	 case 14: UpdateCoursePlanUseCase.CoursePlanUpdate();
            	 break;
            	 case 15: GetCoursePlanByIdUseCase.CoursePlanById();
            	 break;
            	 case 16: ViewAllCoursePlansUseCase.AllCoursePlans();
            	 break;
            	 case 17: ViewAllBatchesUseCase.AllBatches();
            	 break;
            	 case 18: Main.exitApp();
            	 break;
            	 }
            	
            }
            break;
           
   case 2:  boolean Flogin=LoginFacultyUseCase.FacultyLogIn();
            if(Flogin) {
            	System.out.println("Enter your choice");
            	System.out.println("1: view course by id\n"
            			+ "2: view all courses \n"
            			+ "3: update password \n"
            			+ "4: Exit");
            	System.out.println("Enter your choice");
           	   choice=sc.nextInt();
           	   switch(choice) {
           	   case 1: FacultyGetCourseByIdUseCase.CourseById();
           	   break;
           	   case 2: FacultyViewAllCoursesUseCase.AllCoursesInFaculty();
           	   break;
           	   case 3: FacultyUpdatePassword.passwordUpdate();
           	   break;
               case 4: Main.exitApp();
       	       break;
           	   }
            }
          
      break;
      
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
