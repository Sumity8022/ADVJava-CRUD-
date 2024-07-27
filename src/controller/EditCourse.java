package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import helpers.MyHelper;
import models.Course;
import models.User;
import service.CourseService;
import serviceImpl.CourseServiceImpl;

@WebServlet("/editcourse")
@MultipartConfig
public class EditCourse extends HttpServlet{
	
	//delete left
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loggedinUSer");
		
		
		//get all data from course modify form
		
		String cname = req.getParameter("courseName");
		String cdur = req.getParameter("courseDuration");
		String cdesc = req.getParameter("courseDesc");
		String cfee = req.getParameter("courseFee");
		String cid = req.getParameter("courseId");
		
		int courseId=Integer.parseInt(cid);
		
		
		int fee=Integer.parseInt(cfee);
		
		
		//image and pdf 
		
		//get image name
		Part imagePart = req.getPart("cpic");
		String imgName = imagePart.getSubmittedFileName();//if some one not uploaded the image then in that case null will come
		
		
		//get pdf name
		Part pdfPart = req.getPart("cpdf");
		String pdfName = pdfPart.getSubmittedFileName();//if some one not uploaded the image then in that case null will come
		
		
		//fill Course Object
		Course c=new Course();
		c.setCourseDesc(cdesc);
		c.setCourseDuration(cdur);
		c.setCourseFee(fee);
		c.setCourseId(courseId);
		c.setCourseName(cname);
		
		
		
		//fetch userid from loggedin user
		int uid = user.getUserId();
		
		c.setUserId(uid);
		
		
		
		//check condition based on image and pdf
		
		//check pdf 
		
		if(pdfName!=null && !pdfName.isEmpty())
		{
			//save pdf in folder and its name in db
			c.setCoursePdf(pdfName);
			String path=req.getRealPath("/")+"pdfs";
			
			MyHelper.savePdfFile(req, path);
			
		}
		
		
		if(imgName!=null && !imgName.isEmpty())
		{
			//save image into folder and its name into db
			c.setCourseImage(imgName);
			
			String path=req.getRealPath("/")+"coursepic"+File.separator+c.getCourseImage();
			MyHelper.saveImgFile(imagePart.getInputStream(),path);
			
			
		}
		
		
		//save our course object into database
		
		
		CourseService cs=new CourseServiceImpl();
		boolean res = cs.updateCourseData(c);
		
		if(res)
		{
		req.setAttribute("update", "course updated succesfully!!!");	
		}else
		{
			req.setAttribute("update", "something went Wrong please check!!!");		
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("courses.jsp");
		rd.forward(req, resp);
	
		
	}

}