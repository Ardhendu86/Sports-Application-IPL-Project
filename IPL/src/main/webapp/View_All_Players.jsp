<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>  <%--Core tag --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

	<h1>${msg}</h1>
<body>

	<h1>Welcome to view all players</h1>
	
	<table border="1">
	
		<tr>
			<th>Player_Name</th>
			<th>Role</th>
			<th>Country</th>
			<th>Best_Price</th>
			<th>Status</th>
			<th>Change_Status</th>
		
		</tr>	
		
		<special:forEach var="player" items="${players}">
		
			<tr>
			<td>${player.getName()}</td>
			<td>${player.getRole()}</td>
			<td>${player.getCountry()}</td>
			<td>${player.getPrice()}</td>
			<td>${player.getStatus()}</td>
			<td> <a href="changeplayerstatus?id=${player.getId()}"> <button>Change_Status</button> </a> </td>
		
		</tr>	
		
		</special:forEach>
	
	</table>
	<a href="managementHome.jsp"> Back</a>
	
</body>
</html>