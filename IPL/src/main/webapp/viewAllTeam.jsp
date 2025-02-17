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
	<h1>Welcome to view all team list page</h1>
	
	<table border="1">
		
		<tr>
			<th>Team_name<th/>
			<th>wallet<th/>
			<th>Status<th/>
			<th>Players<th/>
			<th>Change_Status<th/>
			<th>Add_Ammount<th/>
		
		<tr/>
		
		<special:forEach  var="team" items="${teams}">
			
		<tr>
			<th>${team.getName() }<th/>
			<th>${team.getWallet() }<th/>
			<th>${team.isStatus() }<th/>
			<th> <a href="viewplayers?id=${team.getId()}"> <button>View_Players</button></a><th/>
			<th> <a href="changestatus?id=${team.getId()}"> <button>Change_Status</button></a> <th/>
			<th> <a href="Add_Amount.jsp?id=${team.getId()}"> <button>Change_Status</button></a> <th/>
			
		<tr/>
		
		</special:forEach>
	</table>
	
</body>
</html>