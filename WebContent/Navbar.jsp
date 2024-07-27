<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
 pageEncoding="ISO-8859-1"%> 
 
<%@ page import="models.User"%> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Insert title here</title> 
<link rel="stylesheet" 
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
 integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 crossorigin="anonymous"> 
<link rel="stylesheet" 
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" 
 integrity="sha512
SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" 
 crossorigin="anonymous" referrerpolicy="no-referrer" /> 
<style> 
.mybg { 
 background: rgb(63, 94, 251); 
 background: radial-gradient(circle, rgba(63, 94, 251, 1) 0%, 
  rgba(252, 70, 107, 1) 100%); 
} 
</style> 
 
</head> 
<body> 
 
 
 <% 
User user=(User)session.getAttribute("loggedinUSer"); 
boolean  isloggedin=true; 
 
if(user == null) 
{ 
  isloggedin=false; 
  response.sendRedirect("login.jsp"); 
} 
 
 
%> 
 
 
 <!-- navbar starting --> 
 
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark   mybg"> 
 <a class="navbar-brand" href="#">MyCourse</a> 
 <button class="navbar-toggler" type="button" data-toggle="collapse" 
  data-target="#navbarSupportedContent" 
  aria-controls="navbarSupportedContent" aria-expanded="false" 
  aria-label="Toggle navigation"> 
  <span class="navbar-toggler-icon"></span> 
 </button> 
 
 <div class="collapse navbar-collapse" id="navbarSupportedContent"> 
  <ul class="navbar-nav mr-auto"> 
   <li class="nav-item active"><a class="nav-link" href="#">Home 
     <span class="fa-solid fa-house"></span> 
   </a></li> 
   <li class="nav-item active"><a class="nav-link" href="login.jsp">Login 
     <span class="sr-only"></span> 
   </a></li> 
 
   <li class="nav-item active"><a class="nav-link" 
    href="signup.jsp">Signup <span class="sr-only"></span></a></li> 
 
   <li class="nav-item active"><a class="nav-link" href="logout">Logout 
     <span class="sr-only"></span> 
   </a></li> 
   <li class="nav-item active"><a class="nav-link" href="#">Courses 
     <span class="sr-only"></span> 
   </a></li> 
 
 
 
 
 
   <% 
      if(isloggedin && user.getRole().equalsIgnoreCase("admin")) 
      { 
      %> 
 
   <li class="nav-item active"><a class="nav-link" href="admin.jsp">Dashboard 
     <span class="sr-only"></span> 
   </a></li> 
 
   <% 
       
      } 
      %> 
 
  </ul> 
  <form class="form-inline my-2 my-lg-0" action="Search"> 
   <input class="form-control mr-sm-2" type="text" 
    placeholder="Search" name="searchkey" aria-label="Search"> 
   <button class="btn btn-outline-success my-2 my-sm-0" 
type="submit">Search</button> 
  </form> 
 
  <% 
    if(isloggedin) 
    { 
    %> 
  <img src="pics/<%= user !=null?user.getUserImage():"default.png" %>" 
   alt="" 
   style="border-radius: 50%; margin-right: 5px; margin-left: 5px; border: 2px 
solid black" 
   width="30" height="30"> <span><%= user!=null ?user.getUserFname():"" %></span> 
  <% 
    } 
    %> 
 </div> 
 </nav> 
 
 
 <!-- navbar ending --> 
 
 
 
 
 
 
 
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
  integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
  crossorigin="anonymous"></script> 
 <script 
  src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" 
  integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
  crossorigin="anonymous"></script> 
 <script 
  src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" 
  integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
  crossorigin="anonymous"></script> 
</body> 
</html>