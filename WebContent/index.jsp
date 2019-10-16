<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Daily Mitra</title>

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<c:if test="${param.message ne null}">
			<div class="alert alert-success" role="alert">
				<span>${param.message}</span> <a href="login.jsp">Login</a>
			</div>
		</c:if>
		<h1>This is home page</h1>
		<p>This is a paragraph.</p>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>