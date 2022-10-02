package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	
	public static void main(String[] args) {
		DBUtil.ProvideConnection();
	}
	
	
     public static Connection ProvideConnection() {
    	 Connection conn=null;
    	 
    	 try {
 			Class.forName("com.mysql.cj.jdbc.Driver");
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		String url="jdbc:mysql://localhost:3306/sb101_coursemonitoring_system";
 		    try{
 		    	conn=DriverManager.getConnection(url,"root","arun@mysql");
 				if(conn!=null) {
 					System.out.println("Connected!......");
 				}else {
 					System.out.println("Error!");
 				}
 				
 				
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}

 	   

    	 
    	 
    	 return conn;
     }
}
