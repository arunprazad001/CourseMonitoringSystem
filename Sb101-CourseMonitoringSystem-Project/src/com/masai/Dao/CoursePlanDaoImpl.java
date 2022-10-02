package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Batch;
import com.masai.Bean.CoursePlan;
import com.masai.Bean.Faculty;
import com.masai.Exceptions.BatchException;
import com.masai.Exceptions.CoursePlanException;
import com.masai.Exceptions.FacultyException;
import com.masai.utility.DBUtil;

public class CoursePlanDaoImpl implements CoursePlanDao {

	@Override
	public String CreateCoursePlan(CoursePlan cp) {
		 String message = "Not Registered..";
			
			
			
			
			try(Connection conn= DBUtil.ProvideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement
						("insert into CoursePlan(planId,BatchId,daynumber,topic,status) values(?,?,?,?,?)");
				
				
				
				ps.setInt(1, cp.getPlanId());
				ps.setInt(2,cp.getBatchId() );
				ps.setInt(3,cp.getDaynumber() );
				ps.setString(4,cp.getTopic() );
				ps.setString(5,cp.getStatus() );
				
			
				int x= ps.executeUpdate();
				
				
				if(x > 0)
					message = "Course Plan Created Sucessfully !";
				
				
				
			} catch (SQLException e) {
				message = e.getMessage();
			}
			
			
		
		
			
			return message;
	}

	@Override
	public String UpdateCoursePlan(CoursePlan cp) {
		 String message = "Nothing to Update!";
			
			
			
			
			try(Connection conn= DBUtil.ProvideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement
						("update CoursePlan set Status='Completed' where dayNumber>30  AND  planId=?");
				ps.setInt(1,cp.getPlanId());
				int x= ps.executeUpdate();
				
				
				if(x > 0)
					message = "Updated Sucessfully !";
				
				
				
			} catch (SQLException e) {
				message = e.getMessage();
			}
			
			
		
		
			
			return message;
	}

	@Override
	public CoursePlan getCoursePlanByPlanId(int PlanId) throws CoursePlanException {
      CoursePlan c =null;
		
		
		try (Connection conn= DBUtil.ProvideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from CoursePlan where planId=?");
			
			
			ps.setInt(1, PlanId);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int pid= rs.getInt("PlanId");
				int bid= rs.getInt("batchId");
				int dno=rs.getInt("dayNumber");
				String topic= rs.getString("topic");
				String stat= rs.getString("status");
				
				
				
			c=new CoursePlan(pid,bid,dno,topic,stat);
				
				
			}else
				throw new CoursePlanException("CoursePlan does not exist with id "+PlanId);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new CoursePlanException(e.getMessage());
			
			
		}
		
	
	
	
		return c;
		
	}

	@Override
	public List<CoursePlan> getAllCoursePlanDetails() throws CoursePlanException {
          List<CoursePlan> cc= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from coursePlan");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int pid= rs.getInt("planId");
			int bid= rs.getInt("BatchId");
				int dno= rs.getInt("daynumber");
				String top= rs.getString("topic");
				String stat= rs.getString("status");
				
				
				
				
			CoursePlan cp=new CoursePlan(pid,bid,dno,top,stat);
				
		 cc.add(cp);
				
				
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			throw new CoursePlanException(e.getMessage());
		}
		
		
		if(cc.size() == 0)
			throw new CoursePlanException("No courseplan found..");
		
		
		
		
		return cc;
	}

}
