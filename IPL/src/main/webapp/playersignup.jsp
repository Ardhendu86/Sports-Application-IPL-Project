<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
    <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<h1>Welcome to player signup page</h1>
<h1>${msg}</h1>
<body>
	<special:form action="playersignup" modelAttribute="player">
	
	Name : <special:input path="name" required="required"/> <br><br>
	Username : <special:input path="username"  required="required"/> <br><br>
	Password : <special:input path="password" required="required"/> <br><br>
	
	Role : <special:select path="role" >
				<special:option value="">Select</special:option>
				<special:option value="batsman">Batsman</special:option>
				<special:option value="bowler">Bowler</special:option>
				<special:option value="allrounder">All_rounder</special:option>
				<special:option value="wicket_keeper">Wicket_keeper</special:option>
	
	      </special:select> <br><br>
	      
	  Country : <special:input path="country" required="required"/>  <br><br>
	  Base_price : <special:input path="price" required="required"/>   <br><br> 
	  
	  <special:button>Signup</special:button>   <special:button type="reset">Cancel</special:button>
	 	
	</special:form> <br><br>
	
	<a href="Playerlogin.jsp">Already have an account? Click here to login</a>
</body>
</html>