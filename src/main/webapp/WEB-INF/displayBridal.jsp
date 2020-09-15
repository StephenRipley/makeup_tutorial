<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${bridalstyle.name} Tutorial</title>
</head>
<body>
	<a href="AllBridalStyles" >Return</a>
<h1> ${bridalstyle.name} Tutorial</h1>
<div>
	<p>Name: ${bridalstyle.name}</p>
</div>
<div>
	<p>Description: ${bridalstyle.description}</p>
</div>
<div>
	<p>Colour Scheme: ${bridalstyle.colourScheme}</p>
</div>
<div>
	<p>Products: ${bridalstyle.products}</p>
</div>
<div>
	<p>Completion Time: ${bridalstyle.completionTime} minutes</p>
</div>
<div>
	<p>Tutorial: ${bridalstyle.tutorial}</p>
</div>
<div>
	<p>Rating: ${bridalstyle.rating}/5</p>
</div>
<div>
	<p>Artist: <a href="DisplayArtist?id=${bridalstyle.artist.artistId}">${bridalstyle.artist.fullName}</a></p> 
</div>
	<a href="EditBridal?id=${bridalstyle.makeupStyleId}">Edit</a> <a href="DeleteBridal?id=${bridalstyle.makeupStyleId}">Delete</a>
</body>
</html>