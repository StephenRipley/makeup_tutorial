<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<h3>Enter your log in details</h3>
	<div>
		<form action="LoginSubmit" method="post">
			${errorMessage}
			<div>
				<label>Email: </label>
				<input type="text" name="email"/>				
			</div>
			<div>
			<label>Password: </label>
				<input type="password" name="password"/>
			</div>
			<button type="submit">Submit </button>
		</form>
	</div>	
</body>
</html>
