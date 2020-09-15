<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${theatricalstyle.name} Tutorial</title>
</head>
<body>
	<a href="AllTheatricalStyles" >Return</a>
<h1> ${theatricalstyle.name} Tutorial</h1>
<div>
	<p>Name: ${theatricalstyle.name}</p>
</div>
<div>
	<p>Description: ${theatricalstyle.description}</p>
</div>
<div>
	<p>Theme: ${theatricalstyle.theme}</p>
</div>
<div>
	<p>Products: ${theatricalstyle.products}</p>
</div>
<div>
	<p>Completion Time: ${theatricalstyle.completionTime} minutes</p>
</div>
<div>
	<p>Tutorial: ${theatricalstyle.tutorial}</p>
</div>
<div>
	<p>Rating: ${theatricalstyle.rating}/5</p>
</div>
<div>
	<p>Artist: <a href="DisplayArtist?id=${theatricalstyle.artist.artistId}">${theatricalstyle.artist.firstname} ${theatricalstyle.artist.lastname}</a></p> 
</div>
	<a href="EditTheatrical?id=${theatricalstyle.makeupStyleId}">Edit</a> <a href="DeleteTheatrical?id=${theatricalstyle.makeupStyleId}">Delete</a>
</body>
</html>