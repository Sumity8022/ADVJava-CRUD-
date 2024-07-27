package service;

import java.util.List;

import models.Course;

public interface CourseService {
	
	
	public boolean saveCourseDetail(Course c);
	
	
	public List<Course> getAllCourses();
	
	public List<Course> getTopSixCourse();

	
	
	public String getCourseById(int cid);
	
	
	//fetching Course based on id
	
	public Course getCourseBasedOnId(int id);
	
	
	//update course
	public boolean updateCourseData(Course c);
	
	
	//delete
	public boolean deleteCourseById(int id);
	
	//search
	public List<Course> getCoursebyName(String name);
	
	
}