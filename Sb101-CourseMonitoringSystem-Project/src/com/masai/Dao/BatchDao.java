package com.masai.Dao;

import java.util.List;

import com.masai.Bean.Batch;

import com.masai.Bean.Faculty;
import com.masai.Exceptions.BatchException;
import com.masai.Exceptions.CourseException;




public interface BatchDao {
  
	
	public String CreateBatch(Batch batch);
	public String UpdateBatch(Batch batch);
	public Batch getBatchByBatchId(int BatchId)throws BatchException;
	public List<Batch> getAllBatchDetails() throws BatchException;
}
