package com.masai.useCases.admin;

import java.util.List;

import com.masai.Bean.Faculty;
import com.masai.Dao.FacultyDao;
import com.masai.Dao.FacultyDaoImpl;
import com.masai.Exceptions.FacultyException;



public class ViewAllFacultiesUseCase {

	public static void AllFaculties() {
		FacultyDao dao=new FacultyDaoImpl();
		 try {
			List<Faculty>fac=dao.getAllFacultyDetails();
			fac.forEach(c->System.out.println(c));
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
