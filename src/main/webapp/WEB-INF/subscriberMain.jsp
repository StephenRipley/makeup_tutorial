<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber Domain</title>
</head>
<body>
	<h1>Welcome ${subscriber.firstname}!</h1>
	<div>
		<a href="Logout">Log out</a>
	</div>
	<div>
		<a href="ViewProfile?id=${subscriber.subscriberId}">View Profile</a>
	</div>
	<h3>Select from below makeup styles</h3>
	<div>
		<a href="AllBridalStyles">View Bridal Styles</a>
	</div>
	<div>
		<a href="AllTheatricalStyles">View Theatrical Styles</a>
	</div>
	<div>
		<a href="AllNaturalStyles">View Natural Styles</a>
	</div>
		<h3>Browse artists</h3>
	<div>
		<a href="AllArtists"> View registered artists</a>
	</div>
	<input type="hidden" value="${subscriber.subscriberId}"/>
</body>
</html>