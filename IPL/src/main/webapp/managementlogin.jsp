<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>${msg}</h1>
<body>
	<h1>Welcome to management login</h1>
	<form action="managementlogin">
	
	Username : <input type="text" name="username" placeholder="Enter your username" required="required"> <br><br>
	Password : <input type="password" name="password" placeholder="Enter your username" required="required"> <br><br>
	
	<button>Submit</button> <button type="reset">Cancel</button>
	
	</form>
	
</body>
</html>