package com.masai.Dao;



import com.masai.Bean.CoursePlan;
import com.masai.Exceptions.CoursePlanException;

public interface CoursePlanDao {
 
	
	public String CreateCoursePlan(CoursePlan cp);
	public String UpdateCoursePlan(CoursePlan cp);
	public CoursePlan getCoursePlanByPlanId(int PlanId)throws CoursePlanException;
}
