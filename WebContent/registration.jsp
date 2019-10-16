<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Daily Mitra</title>

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		
		
		<form action="register" method="post">
		  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Name</label>
      <input type="text" name="name" class="form-control" id="inputEmail4" placeholder="Name">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Mobile</label>
      <input type="number" name="mobile" class="form-control" id="inputPassword4" placeholder="Mobile">
    </div>
  </div>
		
		
		
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" name="email" class="form-control" id="inputEmail4" placeholder="Email">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" name="password" class="form-control" id="inputPassword4" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" name="address1" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Address 2</label>
    <input type="text" class="form-control" name="address2" id="inputAddress2" placeholder="Apartment, studio, or floor">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" name="city" class="form-control" id="inputCity">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" name="state" class="form-control">
        <option selected>Choose...</option>
        <option value="Karnataka">Karnataka</option>
        <option value="Andhra Pradesh">Andhra Pradesh</option>
        <option value="Tamil Nadu">Tamil Nadu</option>
        <option value="Kerla">Kerla</option>
      </select>
    </div>
    <div class="form-group col-md-2">
      <label for="inputZip">PIN code</label>
      <input type="text" name="pin" class="form-control" id="inputZip">
    </div>
  </div>
  
  <input type="submit" class="btn btn-primary" value="Register" />
</form>
		
		
		
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>