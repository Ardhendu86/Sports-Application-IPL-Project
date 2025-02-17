<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to player edit page</h1>
	
	<special:form action="playerupdate" modelAttribute="player">
	
	Id : <special:input path="id" readonly="true"/>
	Name : <special:input path="name" /> <br><br>
	Username : <special:input path="username" /> <br><br>
	Password : <special:input path="password" /> <br><br>
	
	Role : <special:select path="role">
				<special:option value="">Select</special:option>
				<special:option value="batsman">Batsman</special:option>
				<special:option value="bowler">Bowler</special:option>
				<special:option value="allrounder">All_rounder</special:option>
				<special:option value="wicket_keeper">Wicket_keeper</special:option>
	
	      </special:select> <br><br>
	      
	  Country : <special:input path="country" readonly="true"/>  <br><br>
	  Status : <special:input path="status" readonly="true"/> <br><br> 
	  Base_price : <special:input path="price"/>   <br><br> 
	  
	  <special:button>Update</special:button>   <special:button type="reset">Cancel</special:button>
	 	
	</special:form>
	
</body>
</html>