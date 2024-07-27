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
<!-- navbar  --> 
<jsp:include page="Navbar.jsp"></jsp:include> 
 
<div class="container mt-5"> 
 
<div class="row"> 
 
 
<div class="col-md-6  offset-3"> 
<form  action="login"  method="post"> 
<div class="form-group"> 
<label for="exampleInputEmail1">Email address</label> 
<input type="email" name="email" class="form-control" id="exampleInputEmail1" aria
describedby="emailHelp" placeholder="Enter email"> 
<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone 
else.</small> 
</div> 
<div class="form-group"> 
<label for="exampleInputPassword1">Password</label> 
<input type="password" name="pass" class="form-control" id="exampleInputPassword1" 
placeholder="Password"> 
</div> 
 
<button type="submit" class="btn btn-primary">Submit</button> 
</form> 
 
<% 
 
String loginmsg=(String)session.getAttribute("loginmsg"); 
 
%> 
 
 
<% 
if(loginmsg!=null) 
{ 
%> 
<!-- alert message --> 
<div class="alert alert-danger" role="alert"> 
<%= loginmsg %> 
</div> 
 
<% 
 
} 
%> 
 
 
</div> 
 
 
 
</div> 
 
</div> 
 
 
</body> 
</html> 