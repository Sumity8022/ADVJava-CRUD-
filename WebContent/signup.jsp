<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<body> 
<jsp:include page="Navbar.jsp"></jsp:include> 
 
 
<div class="container mt-3"> 
 
 
<div class="row"> 
 
<div class="col-md-6 offset-3"> 
<!-- signup started --> 
 
 
<form  action="signup" method="post" enctype="multipart/form-data"> 
<div class="form-group"> 
<label for="fnameinput">First Name</label> <input name="fname" type="text" 
class="form-control" id="fnameinput" aria-describedby="emailHelp" 
placeholder="Enter Firstname"> 
</div> 
 
 
<div class="form-group"> 
<label for="lastinput">Last Name</label> <input type="text" name="lname" 
class="form-control" id="lastinput" aria-describedby="emailHelp" 
placeholder="Enter LastName"> 
</div> 
 
 
<div class="form-group"> 
<label for="exampleInputEmail1">Email address</label> <input name="email" 
type="email" class="form-control" id="exampleInputEmail1" 
aria-describedby="emailHelp" placeholder="Enter email"> <small 
id="emailHelp" class="form-text text-muted">We'll never 
share your email with anyone else.</small> 
</div> 
<div class="form-group"> 
<label for="exampleInputPassword1">Password</label> <input name="pass" 
type="password" class="form-control" id="exampleInputPassword1" 
placeholder="Password"> 
</div> 
 
 
<div class="form-group"> 
<label for="mob">Mobile</label> <input type="number" name="mob" 
class="form-control" id="mob" aria-describedby="emailHelp" 
placeholder="Enter mobile No"> 
</div> 
 
 
 
 
<div class="form-group"> 
<label for="exampleFormControlFile1">Upload profile pic</label> <input name="pic" 
type="file" class="form-control-file" 
id="exampleFormControlFile1"> 
</div> 
 
<button type="submit" class="btn btn-primary">Submit</button> 
</form> 
 
<!-- signup ended --> 
</div> 
 
 
 
</div> 
 
</div> 
 
 
</body> 
</html> 
