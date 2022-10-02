package com.masai.Dao;



import java.util.List;

import com.masai.Bean.CoursePlan;
import com.masai.Bean.Faculty;
import com.masai.Exceptions.CoursePlanException;
import com.masai.Exceptions.FacultyException;

public interface CoursePlanDao {
 
	
	public String CreateCoursePlan(CoursePlan cp);
	public String UpdateCoursePlan(CoursePlan cp);
	public CoursePlan getCoursePlanByPlanId(int PlanId)throws CoursePlanException;
	public List<CoursePlan> getAllCoursePlanDetails() throws CoursePlanException;
}
