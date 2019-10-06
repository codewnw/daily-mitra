<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Daily Mitra</title>

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
	<h1>Hello, ${sessionScope.customer.name }	</h1>	
	
		
		
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>