package model.dao;

import java.sql.*;

public class Account_DAO {
	
	public int getID(String username, String password) {
		String sql ="select * from account where username=? and password=?";
		
		try (PreparedStatement statement = createConnection().prepareStatement(sql))
		{
		    statement.setString(1,username);
		    statement.setString(2, password);
		    ResultSet result=statement.executeQuery();
		    if(result.next()){
		    	return 	Integer.parseInt(result.getString(1));}
		}catch(Exception e){}
		  	System.out.print("Fail 1");
	    	return -1;
	}

	private Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:6033/ck_ltm", "root", "matkhausql1@");
		} catch (Exception e) {
			System.out.println("Create connect: " + e);
			return null;
		}
	}
}
