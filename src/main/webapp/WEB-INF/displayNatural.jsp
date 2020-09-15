<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${naturalstyle.name} Tutorial</title>
</head>
<body>
	<a href="AllNaturalStyles" >Return</a>
<h1> ${naturalstyle.name} Tutorial</h1>
<div>
	<p>Name: ${naturalstyle.name}</p>
</div>
<div>
	<p>Description: ${naturalstyle.description}</p>
</div>
<div>
	<p>Colour Scheme: ${naturalstyle.colourScheme}</p>
</div>
<div>
	<p>Products: ${naturalstyle.products}</p>
</div>
<div>
	<p>Completion Time: ${naturalstyle.completionTime} minutes</p>
</div>
<div>
	<p>Tutorial: ${naturalstyle.tutorial}</p>
</div>
<div>
	<p>Rating: ${naturalstyle.rating}/5</p>
</div>
<div>
	<p>Artist: <a href="DisplayArtist?id=${naturalstyle.artist.artistId}">${naturalstyle.artist.firstname} ${naturalstyle.artist.lastname}</a></p> 
</div>
	<a href="EditNatural?id=${naturalstyle.makeupStyleId}">Edit</a> <a href="DeleteNatural?id=${naturalstyle.makeupStyleId}">Delete</a>
</body>
</html>