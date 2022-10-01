package com.masai.Dao;

import java.util.List;

import com.masai.Bean.Course;
import com.masai.Exceptions.CourseException;

public interface CourseDao {
    
	
	public String CreateCourse(Course course);
	
	public String UpdateCourse(Course course);
	
	public Course getCourseById(int courseId)throws CourseException;
	
	public List<Course> getAllStudentDetails() throws CourseException;
}
