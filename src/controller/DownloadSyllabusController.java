package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseService;
import serviceImpl.CourseServiceImpl;

@WebServlet("/getsyllabus")
public class DownloadSyllabusController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//for download pdf
		
		
		resp.setContentType("application/pdf");
		
		String courseid = req.getParameter("cid");
		int cid = Integer.parseInt(courseid);
		
		//fetching course based on id 
		CourseService cs=new CourseServiceImpl();
		String pdfname = cs.getCourseById(cid);
		
       resp.setHeader("Content-Disposition","attachment;filename=\""+pdfname+"\"");
		
		//now get pdf from pdfs folder
		
		String path=req.getRealPath("/")+"pdfs"+File.separator+pdfname;
		
		FileInputStream is=new FileInputStream(path);
		
		int size = is.available();
		
		byte[] b=new byte[size];
		
		is.read(b);
		
		ServletOutputStream os = resp.getOutputStream();
		
		os.write(b);
		
		
		is.close();
		
		
	}

}