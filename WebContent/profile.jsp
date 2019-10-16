<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Daily Mitra</title>

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<h1>Hello, ${sessionScope.customer.name }</h1>

		<table class="table table-striped">

			<tbody>
				<tr>
					<td>Name</td>
					<td>${sessionScope.customer.name }</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${sessionScope.customer.email }</td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td>${sessionScope.customer.mobile }</td>
				</tr>
				<tr>
					<td>Street 1</td>
					<td>${sessionScope.customer.address.address1 }</td>
				</tr>
				<tr>
					<td>Street 2</td>
					<td>${sessionScope.customer.address.address2 }</td>
				</tr>
				<tr>
					<td>City</td>
					<td>${sessionScope.customer.address.city }</td>
				</tr>
				<tr>
					<td>State</td>
					<td>${sessionScope.customer.address.state }</td>
				</tr>
				<tr>
					<td>PIN</td>
					<td>${sessionScope.customer.address.pin }</td>
				</tr>
			</tbody>
		</table>

	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>