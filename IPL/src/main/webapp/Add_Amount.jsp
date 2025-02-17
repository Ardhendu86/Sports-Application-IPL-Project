<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Welcome_to_add_ammount_page</h1>
	<% int id=Integer.parseInt(request.getParameter("id")) ; %>
	
	<h1>Add_Ammount</h1>
	
	<form action="addmount">
	
		AddAmmount : <input type="text" name="amount" placeholder="Enter the ammount to be added">
		<input name="id" type="text" value="<%=id%>" hidden="hidden">
		
		<button>Add_Ammount</button>	<button type="reset">Cancel</button>
	
	</form>
	
</body>
</html>