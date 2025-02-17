<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Welcome to view team players name</h1>

<body>
	
	
	<% String msg=(String)request.getAttribute("msg");
	
		if(msg!=null)
		{%>
			<h1>${msg}</h1>
		<% }else {%>
		
		<table border="1">
		
			<tr>
				<th>Name</th>
			    <th>Role</th>
			</tr>
			
			<special:forEach  var="player"  items="${players}">
				
				<tr>
					<th>${player.getName() }</th>
			    	<th>${player.getRole() }</th>
				</tr>
			
			</special:forEach>
			
		</table>
		
	<%} %>
	
	
</body>
</html>