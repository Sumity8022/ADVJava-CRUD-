package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Course;
import service.CourseService;
import serviceImpl.CourseServiceImpl;
@WebServlet("/Search")
public class SearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter wrt = resp.getWriter();
		String sp = req.getParameter("searchkey");
		if(sp==null) {
			wrt.println("The value is null");
		}
		else {
			CourseService cs=new CourseServiceImpl();
			List<Course> coursebyName = cs.getCoursebyName(sp);
			if(coursebyName!=null) {
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				req.setAttribute("mydata", coursebyName);
				rd.forward(req, resp);
			
			}
			
		}
		
	}
	

}
