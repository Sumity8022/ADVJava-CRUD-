package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/addcourse")
@MultipartConfig
public class AddCourseController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter wrt = resp.getWriter();
		
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loggedinUSer");
		
		
		
		
		
		String cmessage = (String)session.getAttribute("cmsg");
		
		if(cmessage==null)
		{
			

			int uid = user.getUserId();//logedin user id 
			
			String cname = req.getParameter("cname");
			String cdur = req.getParameter("cdur");
			String cdesc = req.getParameter("cdesc");
			String cfee = req.getParameter("cfee");//
			
			int cfees = Integer.parseInt(cfee);
			
			//working on course image and pdf
			
			Part imagePart = req.getPart("cpic");//image part
			//fetching course image name
			String courseImageName = imagePart.getSubmittedFileName();
			
			
//			if(imagePart.getSize()>1024*1024*5)
//			{
//				
//			}
			
			//working on pdf part
			Part pdfPart = req.getPart("cpdf");
			
			//fetching pdf name 
			String pdfName = pdfPart.getSubmittedFileName();
			
			//filling Course Model object
			Course course=new Course();
			course.setCourseName(cname);
			course.setCourseDuration(cdur);
			course.setCourseDesc(cdesc);
			course.setCourseFee(cfees);
			course.setUserId(uid);
			course.setCoursePdf(pdfName);
			course.setCourseImage(courseImageName);
			
			
			//before sending course object to service layer and dao layer 
			//first we need to write course image in coursepic folder and pdf in pdf folder.
			
			String pdfPath=req.getRealPath("/")+"pdfs";
			
			
			boolean isPdfSaved = MyHelper.savePdfFile(req, pdfPath);
			
			if(isPdfSaved)
			{
				
				//save image to courseimage folder
				String imagePath=req.getRealPath("/")+"coursepic"+File.separator+course.getCourseImage();
				boolean isimageSaved = MyHelper.saveImgFile(imagePart.getInputStream(),imagePath );
				
				if(isimageSaved)
				{
					
					//now after saving image and pdf to folder we are ready to save whole course object to
					//database
					
					CourseService cs=new CourseServiceImpl();
					boolean isSaved = cs.saveCourseDetail(course);
					
					if(isSaved)
					{
						session.setAttribute("cmsg", "course added succesfully!!!");
					}else
					{
						session.setAttribute("cmsg", "Something Went Wrong!!!");
					}
					
					RequestDispatcher rd = req.getRequestDispatcher("addcourse.jsp");
					rd.include(req, resp);
					
				}
				
		
				
				
			}	
			
			
			session.removeAttribute("cmsg");
			
		}else
		{
			
			session.removeAttribute("cmsg");
			resp.sendRedirect("admin.jsp");
			
			
		}
		
		
		
		
		
	}



}