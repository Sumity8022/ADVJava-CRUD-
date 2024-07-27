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
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<!-- navbar  -->
	<jsp:include page="Navbar.jsp"></jsp:include>
	
	<%
	String del=(String)request.getAttribute("del");
	
	if(del!=null)
	{
	%>
	<div class="alert alert-success" role="alert">
					<%= del %>
				</div>
	<%
	
	}
	%>


	<div class="container">

		<div class="row">

			<div class="col-12">
				<h3>All Courses</h3>
				<table class="table table-hover">
					<thead>
						<tr>

							<th scope="col">Course Name</th>
							<th scope="col">By User</th>
							<th scope="col">Edit Course</th>
							<th scope="col">Delete Course</th>
						</tr>
					</thead>
					<tbody>
					
					
					<%
					
					List<Course> course =null;
					
					CourseService service=new CourseServiceImpl();
					course=service.getAllCourses();
					
					if(course.size()!=0)
					{
						
					for(Course c:course)
					{
						
						int uid=c.getUserId();
						UserService us=new UserServiceImpl();
						String fname=us.getUserByID(uid);
				
					%>
					
			
						<tr>

							<td><img src="coursepic/<%=c.getCourseImage()  %>" alt=""
								style="border-radius: 50%; margin-right: 5px; margin-left: 5px; border: 2px solid black"
								width="30" height="30"> <%= c.getCourseName() %></td>
							<td><%= fname %></td>
							<td><a href="editcourse.jsp?cid=<%= c.getCourseId() %>" class="btn btn-success">Edit</a></td>
							<td><a href="delete?cid=<%= c.getCourseId() %>" class="btn btn-danger">Delete</a></td>

						</tr>
						
						
						
					<%
					
					}
					
					}
					
					%>	
						
						
						
						

					</tbody>
				</table>

			</div>

		</div>

	</div>



</body>
</html>