package models;

public class Course {
	 
	 private int courseId; 
	 private String courseName; 
	 private String courseDuration; 
	 private int courseFee; 
	 private String courseDesc; 
	 private String courseImage; 
	 private String coursePdf; 
	 private int userId;//who uploaded the course 
	 
	 // getter setter (alt+shift+s) 
	 
	 public int getCourseId() { 
	  return courseId; 
	 } 
	 
	 public void setCourseId(int courseId) { 
	  this.courseId = courseId; 
	 } 
	 
	 public String getCourseName() { 
	  return courseName; 
	 } 
	 
	 public void setCourseName(String courseName) { 
	  this.courseName = courseName; 
	 } 
	 
	 public String getCourseDuration() { 
	  return courseDuration; 
	 } 
	 
	 public void setCourseDuration(String courseDuration) { 
	  this.courseDuration = courseDuration; 
	 } 
	 
	 public int getCourseFee() { 
	  return courseFee; 
	 } 
	 
	 public void setCourseFee(int courseFee) { 
	  this.courseFee = courseFee; 
	 } 
	 
	 public String getCourseDesc() { 
	  return courseDesc; 
	 } 
	 
	 public void setCourseDesc(String courseDesc) { 
	  this.courseDesc = courseDesc; 
	 } 
	 
	 public String getCourseImage() { 
	  return courseImage; 
	 } 
	 
	 public void setCourseImage(String courseImage) { 
	  this.courseImage = courseImage; 
	 } 
	 
	 public String getCoursePdf() { 
	  return coursePdf; 
	 } 
	 
	 public void setCoursePdf(String coursePdf) { 
	  this.coursePdf = coursePdf; 
	 } 
	 
	 public int getUserId() { 
	  return userId; 
	 } 
	 
	 public void setUserId(int userId) { 
	  this.userId = userId; 
	 }
}
