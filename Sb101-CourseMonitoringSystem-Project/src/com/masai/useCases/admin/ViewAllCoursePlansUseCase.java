package com.masai.useCases.admin;

import java.util.List;

import com.masai.Bean.CoursePlan;
import com.masai.Dao.CoursePlanDao;
import com.masai.Dao.CoursePlanDaoImpl;
import com.masai.Exceptions.CoursePlanException;


public class ViewAllCoursePlansUseCase {

	public static void AllCoursePlans() {
		CoursePlanDao dao=new CoursePlanDaoImpl();
		 try {
			List<CoursePlan>plans=dao.getAllCoursePlanDetails();
			plans.forEach(c->System.out.println(c));
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
