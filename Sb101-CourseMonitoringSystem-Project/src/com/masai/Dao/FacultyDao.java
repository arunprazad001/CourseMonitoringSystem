package com.masai.Dao;


import com.masai.Bean.Admin;
import com.masai.Bean.Course;
import com.masai.Bean.Faculty;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.CourseException;
import com.masai.Exceptions.FacultyException;

public interface FacultyDao {

	
	public String CreateFaculty(Faculty faculty);
	public Faculty LoginFaculty(String username, String password)throws FacultyException;
	public String UpdateFaculty(Faculty faculty);
	public Faculty GetFacultyById(int facultyId)throws FacultyException;
	public String ShowFacultyAllocated(String s);
}
