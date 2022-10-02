package com.masai.useCases.admin;

import java.util.List;

import com.masai.Bean.Batch;
import com.masai.Dao.BatchDao;
import com.masai.Dao.BatchDaoImpl;
import com.masai.Exceptions.BatchException;



public class ViewAllBatchesUseCase {

	public static void AllBatches() {
		BatchDao dao=new BatchDaoImpl();
		 try {
			List<Batch>batches=dao.getAllBatchDetails();
			batches.forEach(c->System.out.println(c));
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
