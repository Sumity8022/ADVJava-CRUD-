package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Course;

public class CourseDao {

	private Connection conn;

	public CourseDao(Connection conn) {
		this.conn = conn;
	}

	public boolean addCourse(Course c) {

		boolean f = false;
		try {

			String query = "insert into course (courseName,courseDuration,courseFee,courseDesc,courseImage,coursePdf,userId) values (?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, c.getCourseName());
			ps.setString(2, c.getCourseDuration());
			ps.setInt(3, c.getCourseFee());
			ps.setString(4, c.getCourseDesc());
			ps.setString(5, c.getCourseImage());
			ps.setString(6, c.getCoursePdf());
			ps.setInt(7, c.getUserId());

			int res = ps.executeUpdate();

			if (res > 0) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;

	}

	// fetching all courses

	public List<Course> getAllMyCourse() {
		// empty list
		List<Course> clist = new ArrayList<>();

		try {

			String query = "select * from course order by courseId desc";

			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String cname = rs.getString("courseName");
				String cdur = rs.getString("courseDuration");
				int cfee = rs.getInt("courseFee");
				String cimg = rs.getString("courseImage");
				int cid = rs.getInt("courseId");
				int uid = rs.getInt("userId");
				String cdesc = rs.getString("courseDesc");

				// adding all data to course object
				Course course = new Course();
				course.setCourseId(cid);
				course.setCourseDuration(cdur);
				course.setCourseFee(cfee);
				course.setCourseImage(cimg);
				course.setUserId(uid);
				course.setCourseName(cname);
				course.setCourseDesc(cdesc);

				// now add this filled object to empty list
				clist.add(course);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return clist;

	}

	public List<Course> getSixCourses() {
		// empty list
		List<Course> clist = new ArrayList<>();

		try {

			String query = "select * from course limit 6";

			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String cname = rs.getString("courseName");
				String cdur = rs.getString("courseDuration");
				int cfee = rs.getInt("courseFee");
				String cimg = rs.getString("courseImage");
				int cid = rs.getInt("courseId");
				int uid = rs.getInt("userId");
				String cdesc = rs.getString("courseDesc");

				// empty course object
				Course course = new Course();
				course.setCourseId(cid);
				course.setCourseDuration(cdur);
				course.setCourseFee(cfee);
				course.setCourseImage(cimg);
				course.setUserId(uid);
				course.setCourseName(cname);
				course.setCourseDesc(cdesc);

				clist.add(course);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clist;

	}//

	public String getCourseBasedOnId(int id) {

		String pdfName = "";

		try {
			String query = "select * from  course where courseId=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				pdfName = rs.getString("coursePdf");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return pdfName;

	}

	// method to fetch course data based on id
	public Course getCourseById(int id) {
		Course c = new Course();// empty object

		try {
			String query = "select * from course where courseId=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String cname = rs.getString("courseName");
				String cdur = rs.getString("courseDuration");
				int cfee = rs.getInt("courseFee");
				String cimg = rs.getString("courseImage");
				int cid = rs.getInt("courseId");
				int uid = rs.getInt("userId");
				String cdesc = rs.getString("courseDesc");
				String pdfname = rs.getString("coursePdf");

				c.setCourseDesc(cdesc);
				c.setCourseDuration(cdur);
				c.setCourseFee(cfee);
				c.setCourseId(cid);
				c.setCourseImage(cimg);
				c.setCoursePdf(pdfname);
				c.setCourseName(cname);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;

	}

	// update method

	public boolean updateCourse(Course c) {
		boolean f = false;

		try {
			// when pdf and image both uploaded

			if (c.getCoursePdf() != null && c.getCourseImage() != null) {

				String query = "update course set courseName=? , courseDuration=?,courseFee=?,courseDesc=?,courseImage=?,coursePdf=?,userId=? where courseId=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, c.getCourseName());
				ps.setString(2, c.getCourseDuration());
				ps.setInt(3, c.getCourseFee());
				ps.setString(4, c.getCourseDesc());
				ps.setString(5, c.getCourseImage());
				ps.setString(6, c.getCoursePdf());
				ps.setInt(7, c.getUserId());
				ps.setInt(8, c.getCourseId());

				ps.executeUpdate();

				f = true;

			} else if (c.getCoursePdf() == null && c.getCourseImage() == null) {
				String query = "update course set courseName=? , courseDuration=?,courseFee=?,courseDesc=?,userId=? where courseId=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, c.getCourseName());
				ps.setString(2, c.getCourseDuration());
				ps.setInt(3, c.getCourseFee());
				ps.setString(4, c.getCourseDesc());
				ps.setInt(5, c.getUserId());
				ps.setInt(6, c.getCourseId());

				ps.executeUpdate();

				f = true;

			} else if (c.getCourseImage() == null)// if only image not uploaded
			{
				String query = "update course set courseName=? , courseDuration=?,courseFee=?,courseDesc=?,coursePdf=?,userId=? where courseId=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, c.getCourseName());
				ps.setString(2, c.getCourseDuration());
				ps.setInt(3, c.getCourseFee());
				ps.setString(4, c.getCourseDesc());
				ps.setString(5, c.getCoursePdf());
				ps.setInt(6, c.getUserId());
				ps.setInt(7, c.getCourseId());

				ps.executeUpdate();

				f = true;

			} else if (c.getCoursePdf() == null)// if only pdf not uploaded
			{
				String query = "update course set courseName=? , courseDuration=?,coursefee=?,courseDesc=?,courseImage=?,userId=? where courseId=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, c.getCourseName());
				ps.setString(2, c.getCourseDuration());
				ps.setInt(3, c.getCourseFee());
				ps.setString(4, c.getCourseDesc());
				ps.setString(5, c.getCourseImage());
				ps.setInt(6, c.getUserId());
				ps.setInt(7, c.getCourseId());

				ps.executeUpdate();

				f = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}//

	public boolean deleteCourseBAsedOnId(int id) {
		boolean f = false;

		try {
			String query = "delete from course where courseId=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			int res = ps.executeUpdate();

			if (res > 0) {
				f = true;
			} else {
				f = false;
			}

		} catch (Exception e) {

		}

		return f;

	}

	// Doing on myself the search functionality
	public List<Course> getCoursebyName(String n) {
		List clist = new ArrayList();
		String queryn = "select * from course where courseName like ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(queryn);
			ps.setString(1, "%" + n + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String cname = rs.getString("courseName");
				String cdur = rs.getString("courseDuration");
				int cfee = rs.getInt("courseFee");
				String cimg = rs.getString("courseImage");
				int cid = rs.getInt("courseId");
				int uid = rs.getInt("userId");
				String cdesc = rs.getString("courseDesc");

				// empty course object
				Course c = new Course();
				c.setCourseId(cid);
				c.setCourseDuration(cdur);
				c.setCourseFee(cfee);
				c.setCourseImage(cimg);
				c.setUserId(uid);
				c.setCourseName(cname);
				c.setCourseDesc(cdesc);

				clist.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}
}// class end