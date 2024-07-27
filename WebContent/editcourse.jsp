<%@page import="serviceImpl.CourseServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*" %>
	<%@ page import="service.*" %>
	<%@ page import="connection.DBConnection" %>
	<%@ page import="models.*" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	if(user==null)
	{
		response.sendRedirect("login.jsp");
	}else if(user.getRole().equalsIgnoreCase("admin"))
	{
		
    String cid=request.getParameter("cid");
		int id=Integer.parseInt(cid);
		
		CourseService cs=new CourseServiceImpl();
		Course c=cs.getCourseBasedOnId(id);
		
		
		
	
	%>

		<div class="container">
		<div class="row">

			<div class="col-md-6 offset-3">
				<h3>Modify Course</h3>

				<form action="editcourse" method="post" enctype="multipart/form-data" >
				<div class="form-group">
						<label for="fnameinput">Course Id</label>
						 <input type="text" readonly="readonly" value="<%= c.getCourseId() %>" name="courseId"
							 class="form-control" id="fnameinput"
							>
					</div>
				
					<div class="form-group">
						<label for="fnameinput">Course Name</label> <input value="<%= c.getCourseName() %>" name="courseName"
							type="text" class="form-control" id="fnameinput"
							aria-describedby="emailHelp" placeholder="Enter Course Name">
					</div>


					<div class="form-group">
						<label for="lastinput">Course Duration</label> <input value="<%= c.getCourseDuration() %>" type="text"
							name="courseDuration" class="form-control" id="lastinput"
							aria-describedby="emailHelp" placeholder="Enter Course Duration">
					</div>

					<div class="form-group">
						<label for="lastinput">Course Description</label>
						<textarea value="<%= c.getCourseDesc() %>"  name="courseDesc" class="form-control" id="cdesc" rows="3"><%= c.getCourseDesc() %></textarea>
					</div>


					<div class="form-group">
						<label for="lastinput">Course Fee</label>
						<textarea value="<%= c.getCourseFee() %>" name="courseFee" class="form-control" id="cdesc" rows="3"><%= c.getCourseFee() %></textarea>
					</div>


                    

					<div class="form-group">
						<label for="exampleFormControlFile1">Upload Course Image</label> <input
							  name="cpic" type="file" class="form-control-file"
							id="exampleFormControlFile1">
							<span><%= c.getCourseImage() %></span>
					</div>

					<div class="form-group">
						<label for="exampleFormControlFile1">Upload Course PDF</label> <input
							name="cpdf"  type="file" class="form-control-file"
							id="exampleFormControlFile1">
							<span><%= c.getCoursePdf()%></span>
					</div>

					<button type="submit"  class="btn btn-primary">Submit</button>
				</form>

		

			</div>


		</div>

	</div>
	
	<%
	
	}else
	{
		
		
	}
	%>
	
	

</body>
</html>