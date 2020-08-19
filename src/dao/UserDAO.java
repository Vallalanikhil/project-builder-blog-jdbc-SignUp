package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public  class UserDAO implements UserDaoInterface{
	   String signu="insert into USERS VALUES (?,?)";
	   String login="select * from USERS where EMAIL=? and PASSWORD=?";
	   
	   public int signUp(User user) throws Exception {
		   Connection con=null;
		   con=ConnectionManager.getConnection();
		   PreparedStatement prep=con.prepareStatement(signu);
		   prep.setString(1, user.getEmail());
		   prep.setString(2,user.getPassword());
		   int execution =prep.executeUpdate();
		   return execution;		   
	   }
	   
	   public boolean loginUser(User user) {
		   Connection con=null;
		   try {
			con=ConnectionManager.getConnection();
			 PreparedStatement prep=con.prepareStatement(login);
			   prep.setString(1,user.getEmail());
			   prep.setString(2, user.getPassword());
			   
			   ResultSet rs=prep.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		   return false;
		   
	   }
}