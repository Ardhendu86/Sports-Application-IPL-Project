<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<h1>Welcome to view my team page</h1>
	<%-- <h1>${teamname} players are and total balance is ${team.getWallet()+amount}</h1>--%>
	<h1>Team name is ${teamname}  and they have ${team.getWallet()+amount}cr in their account</h1>
	
<body>

	<% String msg=(String)request.getAttribute("msg"); 
	
	if(msg!=null)
	{%>
		<h1>${msg}</h1>
		
	<% }
	
	else
	{%>
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
		
		
	<% }%>
	
	<a href="teamhomedummy"> <button>Back</button></a>
	
</body>
</html>