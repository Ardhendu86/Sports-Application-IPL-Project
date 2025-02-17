<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form" %> 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>${msg}</h1>
<body>
	<h1>Welcome to Team sign up page</h1>
	
	<special:form action="teamsignup" modelAttribute="team" >
		
		Name :<special:input path="name" required="required"/> <br><br>
		Username :<special:input path="username" required="required"/> <br><br>
		Password<special:input path="password" required="required"/> <br><br>
		Wallet :<special:input path="wallet" required="required"/> <br><br>
		
		<special:button>Signup</special:button> <special:button type="reset">Cancel</special:button>
		
	</special:form>
</body>
</html>