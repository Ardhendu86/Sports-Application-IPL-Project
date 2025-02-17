<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Available player are</h1>
	
	
	<table border="1">
	
		<tr>
			<th>Player_Name</th>
			<th>Role</th>
			<th>Country</th>
			<th>Best_Price</th>
			<th>Status</th>
			<th>buy</th>
			
		</tr>	
		
		<special:forEach var="player" items="${players}">
		
			<tr>
			<th>${player.getName()}</th>
			<th>${player.getRole()}</th>
			<th>${player.getCountry()}</th>
			<th>${player.getPrice()}</th>
			<th>${player.getStatus()}</th>
			<th> <a href="buyplayer?id=${player.getId()}"> <button>Buy</button> </a> </th>
		
		</tr>	
		
		</special:forEach>
	
	</table>

</body>
</html>