package com.masai.useCases.faculty;

import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Course;
import com.masai.Dao.CourseDao;
import com.masai.Dao.CourseDaoImpl;
import com.masai.Exceptions.CourseException;

public class FacultyViewAllCoursesUseCase {

	public static void AllCoursesInFaculty() {
		
		
		CourseDao dao=new CourseDaoImpl();
		 try {
			List<Course>course=dao.getAllStudentDetails();
			course.forEach(c->System.out.println(c));
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
