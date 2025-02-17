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
	
	<h1>Welcome to player login</h1>
	
	<form action="playerlogin">
		
		Username : <input type="text" name="username" placeholder="Enter your username" required="required">
		Password : <input type="text" name="password" placeholder="Enter your password" required="required">
		
		<button>Login</button>  <button type="reset">Cancel</button>
	
	</form>
	
</body>
</html>