package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.User;

public class LoginDao {
	private Connection conn; 
	 
	 public LoginDao(Connection conn) { 
	  this.conn = conn; 
	 } 
	 
	 public User getUserByEmail(String email, String pass) { 
	  User user = null; 
	 
	  try { 
	 
	   String query = "select * from user where userEmail=? and password=?"; 
	   PreparedStatement ps = conn.prepareStatement(query); 
	   ps.setString(1, email); 
	   ps.setString(2, pass); 
	   ResultSet rs = ps.executeQuery(); 
	 
	   if (rs.next()) { 
	    user = new User();// empty 
	 
	    int uid = rs.getInt("userid"); 
	    String fname = rs.getString("userFname"); 
	    String lname = rs.getString("userLname"); 
	    String uemail = rs.getString("userEmail"); 
	    String upass = rs.getString("password"); 
	    String picname = rs.getString("userImage"); 
	    long mob = rs.getLong("mobNo"); 
	    String role=rs.getString("Role"); 
	 
	    user.setMobNo(mob); 
	    user.setUserEmail(uemail); 
	    user.setUserFname(fname); 
	    user.setUserImage(picname); 
	    user.setUserLname(lname); 
	    user.setUserId(uid); 
	    user.setRole(role); 
	 
	   } 
	 
	  } catch (Exception e) { 
	 
	   e.printStackTrace(); 
	 
	  } 
	 
	  return user; 
	 
	 }// end
}
