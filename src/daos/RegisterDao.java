package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.User;

public class RegisterDao {
	private Connection conn; 
	 
	 public RegisterDao(Connection conn) { 
	  this.conn = conn; 
	 } 
	 
	 public boolean saveMyUser(User u) { 
	  boolean f = false; 
	 
	  try { 
	 
	   String query = "insert into user (userFname,userLname,userEmail,password,userImage,mobNo,Role) values (?,?,?,?,?,?,?)"; 
	 
	   PreparedStatement ps = conn.prepareStatement(query); 
	   ps.setString(1, u.getUserFname()); 
	   ps.setString(2, u.getUserLname()); 
	   ps.setString(3, u.getUserEmail()); 
	   ps.setString(4, u.getPassword()); 
	   ps.setString(5, u.getUserImage()); 
	   ps.setLong(6, u.getMobNo()); 
	   ps.setString(7, u.getRole()); 
	   int res = ps.executeUpdate(); 
	   if (res > 0) { 
	    f = true; 
	   } 
	 
	  } catch (Exception e) { 
	 
	    
	    
	   e.printStackTrace(); 
	 
	  } 
	 
	  return f; 
	 
	 }
}
