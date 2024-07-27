<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="models.User" %>
    
    	<%@ page import="java.util.*" %>
	<%@ page import="service.*" %>
	<%@ page import="serviceImpl.*" %>
	<%@ page import="connection.DBConnection" %>
	<%@ page import="models.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- navbar  -->
	<jsp:include page="Navbar.jsp"></jsp:include>
	
	
	<div class="container " style="margin-top:10px" >
	
	<div class="row">
	
	
	
	<%
	
	User user=(User)session.getAttribute("loggedinUSer");
	
	if(user==null)
	{
		response.sendRedirect("login.jsp");
	}else if(user.getRole().equalsIgnoreCase("admin"))
	{
		
		List<Course> courseList=null;
		
		CourseService service=new CourseServiceImpl();
		courseList=service.getAllCourses();
		
		
		for(Course c:courseList)
		{
	
	%>
	
	<!-- course card column -->
	
	<div class="col-md-4 ">
	<div class="card mb-4 box-shadow" >
  <img src="coursepic/<%= c.getCourseImage() %>" width="180" height="180"  class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title"><%= c.getCourseName() %></h5>
    <p class="card-text"><%= c.getCourseDesc() %></p>
     <p class="card-text">Rs <%= c.getCourseFee() %> /-</p>
    <a href="#" class="btn btn-primary">View</a>
    <a href="editcourse.jsp?cid=<%= c.getCourseId() %>" class="btn btn-primary">Edit</a>
  </div>
    </div>
	</div>
	
	<!-- course card ends -->
	
	<%
		}
	}
	else
	{
	
	
	%>
	
	<%
	List<Course> courseList=null;
	CourseService service=new CourseServiceImpl();
	courseList=service.getAllCourses();
	
	for(Course c:courseList)
	{


	
	%>
	
		<!-- course card column -->
	
	<div class="col-md-4 ">
	<div class="card mb-4" style="width: 18rem;">
  <img src="coursepic/<%= c.getCourseImage() %>" width="180" height="180" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title"><%= c.getCourseName() %></h5>
    <p class="card-text"><%= c.getCourseDesc() %></p>
     <p class="card-text">Rs <%= c.getCourseFee() %> /-</p>
    <a href="#" class="btn btn-primary">View</a>
    <a href="getsyllabus?cid=<%= c.getCourseId() %>" class="btn btn-success">Download</a>
  </div>
    </div>
	</div>
	
	<!-- course card ends -->
	
	<%
	}
	
	}
	%>
	
	
	</div>
	
	
	
	</div>
	
	
	

</body>
</html>