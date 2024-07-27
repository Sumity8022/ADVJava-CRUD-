package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import helpers.MyHelper;
import models.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

@WebServlet("/signup") 
@MultipartConfig 
public class RegisterController extends HttpServlet{ 
  
 @Override 
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
   
  resp.setContentType("text/html"); 
  PrintWriter wrt = resp.getWriter(); 
   
   
  String fname = req.getParameter("fname"); 
  String lname = req.getParameter("lname"); 
  String email = req.getParameter("email"); 
  String pass = req.getParameter("pass"); 
  String mob = req.getParameter("mob"); 
   
  long newmob = Long.parseLong(mob); 
   
   
  //gettting image part 
  Part part = req.getPart("pic"); 
   
  //extracting file name 
  String picname = part.getSubmittedFileName(); 
   
   
   
  //apending timestamp to image name 
  LocalDateTime timestamp= LocalDateTime.now();//create date time object 
   
  DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");//create pattern using dateformater 
  String newtimestamp = timestamp.format(format);//convert date into desired pattern 
   
   
  String newprofilePic=newtimestamp+"_"+picname; 
   
   
   
  //creating model object and filling it 
  User u=new User(); 
  u.setUserFname(fname); 
  u.setUserLname(lname); 
  u.setUserEmail(email); 
  u.setPassword(pass); 
  u.setMobNo(newmob); 
  u.setUserImage(newprofilePic); 
  u.setRole("normal"); 
   
  //working with image section 
   
  //file path  
  String path=req.getRealPath("/")+"pics"+File.separator+u.getUserImage(); 
   
  boolean isSaved = MyHelper.saveImgFile(part.getInputStream(), path); 
   
  if(isSaved) 
  { 
   //file saved to pics folder 
    
   //now saving user data to database 
    
   UserService us=(UserService) new UserServiceImpl(); 
   boolean res = us.saveUser(u); 
    
    
   if(res) 
   { 
    wrt.println("user register succesfully!!!"); 
   }else 
   { 
    wrt.println("soemthing went wrong!!!"); 
   } 
    
    
  } 
   
  
   
 } 
 
} 