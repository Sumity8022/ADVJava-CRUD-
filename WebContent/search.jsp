<%@page import="serviceImpl.UserServiceImpl"%>
<%@page import="serviceImpl.CourseServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*" %>
	<%@ page import="service.*" %>
	<%@ page import="connection.DBConnection" %>
	<%@ page import="models.Course" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include> 

<div class="container " style="margin-top:10px" >

<div class="row">


<%
List<Course> name=(List<Course>)request.getAttribute("mydata");
List<Course> clist=null;

CourseService service=new CourseServiceImpl();
clist=service.getCoursebyName("");

for(Course c:name)
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
    <a href="view.jsp" class="btn btn-primary">View</a>
    
  </div>
    </div>
	</div>
	
	<!-- course card ends -->
	<%
	

}
if(clist!=null)
{
	%><h1>Course is <%=clist %></h1>    <%
	
}
	%>

</div>



</div>

</body>
</html>