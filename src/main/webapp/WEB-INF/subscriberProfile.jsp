<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<body>
<a href="Main">Return</a>
	<h1>My Profile</h1>
<div>
	<p> Name: ${subscriber.fullName}</p>
</div>
<div>
	<p> Email: ${subscriber.email}</p>
</div>
<div>
	<a href="EditProfile?id=${subscriber.subscriberId}">Edit </a>
</div>
</body>
</html>