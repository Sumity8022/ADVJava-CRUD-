package models;

public class User{ 
	 
	 private int userId; 
	 private String userFname; 
	 private String userLname; 
	 private String userEmail; 
	 private String password; 
	 private String userImage; 
	 private long mobNo; 
	 
	 private String role; 
	 
	 // getters and setters 
	 
	 public int getUserId() { 
	  return userId; 
	 } 
	 
	 public void setUserId(int userId) { 
	  this.userId = userId; 
	 } 
	 
	 public String getUserFname() { 
	  return userFname; 
	 } 
	 
	 public void setUserFname(String userFname) { 
	  this.userFname = userFname; 
	 } 
	 
	 public String getUserLname() { 
	  return userLname; 
	 } 
	 
	 public void setUserLname(String userLname) { 
	  this.userLname = userLname; 
	 } 
	 
	 public String getUserEmail() { 
	  return userEmail; 
	 } 
	 
	 public void setUserEmail(String userEmail) { 
	  this.userEmail = userEmail; 
	 } 
	 
	 public String getPassword() { 
	  return password; 
	 } 
	 
	 public void setPassword(String password) { 
	  this.password = password; 
	 } 
	 
	 public String getUserImage() { 
	  return userImage; 
	 } 
	 
	 public void setUserImage(String userImage) { 
	  this.userImage = userImage; 
	 } 
	 
	 public long getMobNo() { 
	  return mobNo; 
	 } 
	 
	 public void setMobNo(long mobNo) { 
	  this.mobNo = mobNo; 
	 } 
	 
	 public String getRole() { 
	  return role; 
	 } 
	 
	 public void setRole(String role) { 
	  this.role = role; 
	 }
}