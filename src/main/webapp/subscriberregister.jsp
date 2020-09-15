<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber Registration</title>
</head>
<body>
<h1>User Registration Page</h1>
	<h3>Enter your user details</h3>
	<div>
		<form action="SubscriberRegisterSubmit" method="post">
			${errorMessage}
			<div>
				<label>First Name :</label>
				<input type="text" name="firstname"/>				
			</div>
			<div>
				<label>Last Name :</label>
				<input type="text" name="lastname"/>				
			</div>
			<div>
				<label>Email :</label>
				<input type="text" name="email"/>				
			</div>
			<div>
			<label>Password:</label>
				<input type="password" name="password"/>
			</div>
			<button type="submit">Submit </button>
		</form>
	</div>	

</body>
</html>