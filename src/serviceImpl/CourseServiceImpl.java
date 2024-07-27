package serviceImpl;

import java.util.List;

import connection.DBConnection;
import daos.CourseDao;
import models.Course;
import service.CourseService;

public class CourseServiceImpl implements CourseService {

	@Override
	public boolean saveCourseDetail(Course c) {

		// communicate with course dao
		CourseDao cdao = new CourseDao(DBConnection.getConn());
		boolean addCourse = cdao.addCourse(c);

		return addCourse;
	}

	@Override
	public List<Course> getAllCourses() {

		// comunicate to dao
		CourseDao cdao = new CourseDao(DBConnection.getConn());
		List<Course> allMyCourse = cdao.getAllMyCourse();

		return allMyCourse;
	}

	@Override
	public List<Course> getTopSixCourse() {
		// comunicate to dao
		CourseDao cdao = new CourseDao(DBConnection.getConn());
		List<Course> sixCourses = cdao.getSixCourses();

		return sixCourses;
	}

	@Override
	public String getCourseById(int cid) {

		// comunicate to dao
		CourseDao cdao = new CourseDao(DBConnection.getConn());

		String pdfname = cdao.getCourseBasedOnId(cid);
		return pdfname;

	}

	@Override
	public Course getCourseBasedOnId(int id) {
		// comunicate to dao
		CourseDao cdao = new CourseDao(DBConnection.getConn());
		Course course = cdao.getCourseById(id);
		
		return course;
		
	}

	@Override
	public boolean updateCourseData(Course c) {
		// comunicate to dao
		CourseDao cdao = new CourseDao(DBConnection.getConn());
		boolean res = cdao.updateCourse(c);
		return res;
	}


	//
	
	
	//delete
	
	@Override
	public boolean deleteCourseById(int id) {
		// comunicate to dao
		CourseDao cdao = new CourseDao(DBConnection.getConn());
		boolean res = cdao.deleteCourseBAsedOnId(id);
		
		return res;
		
	
	}
	
	public List<Course> getCoursebyName(String n){
		CourseDao c=new CourseDao(DBConnection.getConn());
		List<Course> coursename=c.getCoursebyName(n);
		
		return coursename;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}//end