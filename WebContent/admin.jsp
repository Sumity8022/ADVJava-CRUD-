<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
 
<%@ page import="models.User" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<body> 
<!-- navbar  --> 
<jsp:include page="Navbar.jsp"></jsp:include> 
 
 
<% 
User user=(User)session.getAttribute("loggedinUSer"); 
 
if(user ==null) 
{ 
response.sendRedirect("login.jsp"); 
} 
 
%> 
 
 
<div class="container"> 
 
<div class="row"> 
 
<div class="col=md-4  col-xl-3"> 
 
 
<div class="card"> 
<div class="card-body"> 
<h5 class="card-title"> 
 
<a href="addcourse.jsp">ADD COURSES</a> 
</h5> 
 
</div> 
</div> 
 
</div> 
 
 
<div class="col=md-4  col-xl-3"> 
 
 
<div class="card"> 
<div class="card-body"> 
<h5 class="card-title"> 
 
<a href="allcourses.jsp">View COURSES</a> 
</h5> 
 
</div> 
</div> 
 
</div> 
 
</div> 
 
 
</div> 
 
 
</body> 
</html> 