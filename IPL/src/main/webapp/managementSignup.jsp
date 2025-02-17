<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form" %> 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Welcome to management signup</h1>
<h2>${msg}</h2>
<body>

	<!-- <form action="" ModelAttribute>
		Username :<input type="text" name="username" placeholder="Enter your name"> <br><br>
		Password :<input type="text" name="password" placeholder="Enter your password"> <br><br>
		
		<button>Submit</button>
	
	</form> -->
	
	<special:form  action="managementsignup" modelAttribute="management">
	
		Username : <special:input path="username" required="required"/>  <br><br>
		password : <special:input path="password" required="required"/>  <br><br>
		
		<special:button>Signup</special:button>  <special:button type="reset">Cancel</special:button>
	
	</special:form>
	

</body>
</html>