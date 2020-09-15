<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Viewing Artist</title>
</head>
<body>
<a href="AllArtists">Return</a>
<h1>Profile: ${artist.fullName}</h1>
<div>
	<p> Name: ${artist.fullName}</p>
</div>
<div>
	<p> Email: ${artist.email}</p>
</div>
<div>
	<p> Styles: ${artist.styleType}</p>
</div>
<div>
	<p> Social Media: ${artist.socialmedia}</p>
</div>
<div>
	<a href="EditArtist?id=${artist.artistId}">Edit </a>
</div>
</body>
</html>