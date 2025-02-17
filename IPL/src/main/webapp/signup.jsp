<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome to Signup Page</h1>
	
		<form action="signup">
		<h1>Choose your role</h1>
			<input type="radio" name="role" value="Management" required="required">Management <br><br>
			<input type="radio" name="role" value="team" required="required">team <br><br>
			<input type="radio" name="role" value="player" required="required">player <br><br>

			<button>Submit</button> <br><br>
		</form>
		
		<a href="index.jsp">Already have an account?</a>
	
</body>
</html>