package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseService;
import serviceImpl.CourseServiceImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter wrt = resp.getWriter();
		resp.setContentType("text/html");
		
		String cid = req.getParameter("cid");
		int courseid = Integer.parseInt(cid);
		
	
		
		
		
		//service
		CourseService cs=new CourseServiceImpl();
		
	
		boolean res = cs.deleteCourseById(courseid);
		
		if(res)
		{
			resp.sendRedirect("allcourses.jsp");
			
		}else
		{
			req.setAttribute("del", "unable to delete something went wrong!!!!");
			RequestDispatcher rd = req.getRequestDispatcher("allcourses.jsp");
			rd.forward(req, resp);
		}
		
		
	
	}


}