package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Batch;
import com.masai.Bean.Course;
import com.masai.Bean.Faculty;
import com.masai.Exceptions.BatchException;
import com.masai.Exceptions.CourseException;
import com.masai.Exceptions.FacultyException;
import com.masai.utility.DBUtil;

public class BatchDaoImpl implements BatchDao {

	@Override
	public String CreateBatch(Batch batch) {
       String message = "Not Registered..";
		
		
		
		
		try(Connection conn= DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into Batch(batchId,courseId,facultyId,numberofStudents,batchStartDate,duration) values(?,?,?,?,?,?)");
			
			
			
			ps.setInt(1, batch.getBatchId());
			ps.setInt(2,batch.getCourseId() );
			ps.setInt(3,batch.getFacultyId() );
			ps.setInt(4,batch.getNumberofStudents() );
			ps.setString(5,batch.getBatchstartDate() );
			ps.setString(6,batch.getDuration()) ;
		
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Batch Created Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		return message;
	}

	@Override
	public String UpdateBatch(Batch batch) {
		 String message = "Nothing to Update!";
			
			
			
			
			try(Connection conn= DBUtil.ProvideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement
						("update batch set numberofStudents=numberofStudents+30 where courseId=? ");
				ps.setInt(1,batch.getCourseId());
				int x= ps.executeUpdate();
				
				
				if(x > 0)
					message = "Updated Sucessfully !";
				
				
				
			} catch (SQLException e) {
				message = e.getMessage();
			}
			
			
		
		
			
			return message;
	}

	@Override
	public Batch getBatchByBatchId(int BatchId) throws BatchException {
     Batch b =null;
		
		
		try (Connection conn= DBUtil.ProvideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from batch where BatchId=?");
			
			
			ps.setInt(1, BatchId);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int bid= rs.getInt("batchId");
				int cid= rs.getInt("courseId");
				int fid=rs.getInt("facultyId");
				int no= rs.getInt("numberofStudents");
				String date= rs.getString("batchStartDate");
				String dur= rs.getString("duration");
				
				
			b=new Batch(bid,cid,fid,no,date,dur);
				
				
			}else
				throw new BatchException("Batch does not exist with id "+BatchId);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new BatchException(e.getMessage());
			
			
		}
		
	
	
	
		return b;
		
	}

	@Override
	public List<Batch> getAllBatchDetails() throws BatchException {
		 List<Batch> batches= new ArrayList<>();
			
			
			try(Connection conn= DBUtil.ProvideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement("select * from batch");
				
				
				
				ResultSet rs= ps.executeQuery();
				
				while(rs.next()) {
					
					
					int bid= rs.getInt("batchId");
					int cid= rs.getInt("courseId");
					int fid= rs.getInt("facultyId");
					int no= rs.getInt("numberofStudents");
					String date=rs.getString("batchStartDate");
					String du=rs.getString("duration");
					
					
					
				Batch b=new Batch(bid,cid,fid,no,date,du);
					
				batches.add(b);
					
					
					
				}
				
				
				
				
				
			} catch (SQLException e) {
				throw new BatchException(e.getMessage());
			}
			
			
			if(batches.size() == 0)
				throw new BatchException("No batch found..");
			
			
			
			
			return batches;
		}

		
	}


