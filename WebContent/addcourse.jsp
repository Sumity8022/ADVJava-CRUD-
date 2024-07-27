<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

String coursemsg=(String)session.getAttribute("cmsg");



%>


	<div class="container">
		<div class="row">

			<div class="col-md-6 offset-3">
				<h3>Admin Dashboard</h3>

				<form action="addcourse" method="post" enctype="multipart/form-data" >
					<div class="form-group">
						<label for="fnameinput">Course Name</label> <input name="cname"
							type="text" class="form-control" id="fnameinput"
							aria-describedby="emailHelp" placeholder="Enter Course Name">
					</div>


					<div class="form-group">
						<label for="lastinput">Course Duration</label> <input type="text"
							name="cdur" class="form-control" id="lastinput"
							aria-describedby="emailHelp" placeholder="Enter Course Duration">
					</div>

					<div class="form-group">
						<label for="lastinput">Course Description</label>
						<textarea name="cdesc" class="form-control" id="cdesc" rows="3"></textarea>
					</div>


					<div class="form-group">
						<label for="lastinput">Course Fee</label>
						<textarea name="cfee" class="form-control" id="cdesc" rows="3"></textarea>
					</div>


					<div class="form-group">
						<label for="exampleFormControlFile1">Upload Course Image</label> <input
							accept="image/*" required name="cpic" type="file" class="form-control-file"
							id="exampleFormControlFile1">
					</div>

					<div class="form-group">
						<label for="exampleFormControlFile1">Upload Course PDF</label> <input
							accept=".pdf"  name="cpdf" required type="file" class="form-control-file"
							id="exampleFormControlFile1">
					</div>

					<button type="submit"  class="btn btn-primary">Submit</button>
				</form>

				<%
			if(coursemsg!=null && !coursemsg.isEmpty())
			{
			%>

				<div class="alert alert-success" role="alert">
					<%= coursemsg %>
				</div>

				<%
				
				
				
			}
				
				
	
				%>


			</div>


		</div>

	</div>

</body>
</html>