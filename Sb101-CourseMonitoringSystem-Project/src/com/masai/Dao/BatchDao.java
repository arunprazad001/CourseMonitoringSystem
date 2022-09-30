package com.masai.Dao;

import com.masai.Bean.Batch;
import com.masai.Bean.Faculty;
import com.masai.Exceptions.BatchException;




public interface BatchDao {
  
	
	public String CreateBatch(Batch batch);
	public String UpdateBatch(Batch batch);
	public Batch getBatchByBatchId(int BatchId)throws BatchException;
}
