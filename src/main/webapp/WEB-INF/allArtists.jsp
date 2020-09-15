<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Viewing artists</title>
</head>
<body>
	<a href="Main" >Return</a>
<h1>List of registered artists</h1>
	<c:forEach items="${artists}" var ="artist">
	<div>
	<a href="DisplayArtist?id=${artist.artistId}">${artist.fullName}</a>
	<p>Styles: ${artist.styleType}</p>
	</div>
	</c:forEach>
</body>
</html>