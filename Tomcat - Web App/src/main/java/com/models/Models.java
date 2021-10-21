package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Models {
	
	Connection con;
	
	private void dbConnection(String dept)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://23.88.33.117:3306/" + dept, "u2424_3iEuNEPWwN", "sEzylB843jS9Epi6+bKTEN=!");
			this.con = con;
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	
	public int addMarksModel(String a, String b, String c, String dept) 
	{
		
		try {
		dbConnection(dept);
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO Results (`Student ID`,`Subject ID`,`Mark`) VALUES (?,?,?)");
        pstmt.setString(1, a);
        pstmt.setString(2, b);
        pstmt.setString(3, c);
        
        int count = pstmt.executeUpdate();
        
        if (count > 0) {
        	return 1;
        } else {
           return 0;
        }
        
		}catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage() );
            System.out.println("SQL State: " + e.getSQLState());
        } catch (Exception e) {
        	System.out.println("Exception: " + e.getMessage());
		}
		return 0;
	}
	
	public int updateMarksModel(String a, String b, String c, String dept) 
	{
		
		try {
		dbConnection(dept);
		PreparedStatement pstmt = con
	            .prepareStatement("UPDATE Results SET `Mark` = ? WHERE `Student ID`= ? AND `Subject ID`= ?");
	    pstmt.setString(1, c);
	    pstmt.setString(2, a);
	    pstmt.setString(3, b);
	    
	    int count = pstmt.executeUpdate();

        
        if (count > 0) {
        	return 1;
        } else {
           return 0;
        }
        
		}catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage() );
            System.out.println("SQL State: " + e.getSQLState());
        } catch (Exception e) {
        	System.out.println("Exception: " + e.getMessage());
		}
		return 0;
	}
	
	public int displayMarksModel(String a, String b, String c, String dept) 
	{
		
		try {
		dbConnection(dept);
		PreparedStatement pstmt = con
	            .prepareStatement("UPDATE Results SET `Mark` = ? WHERE `Student ID`= ? AND `Subject ID`= ?");
	    pstmt.setString(1, c);
	    pstmt.setString(2, a);
	    pstmt.setString(3, b);
	    
	    int count = pstmt.executeUpdate();

        
        if (count > 0) {
        	return 1;
        } else {
           return 0;
        }
        
		}catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage() );
            System.out.println("SQL State: " + e.getSQLState());
        } catch (Exception e) {
        	System.out.println("Exception: " + e.getMessage());
		}
		return 0;
	}
	

}
