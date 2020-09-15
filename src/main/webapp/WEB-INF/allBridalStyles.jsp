<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bridal Styles</title>
</head>
<body>
	<a href="Main" >Return</a>
	<h1>List of bridal styles</h1>
	<a href="AddBridal">Add new</a>
	<h2>Select to view tutorial</h2>
	<c:forEach items="${bridalStyles}" var="bridalstyle">
	<div>
	<a href="DisplayBridal?id=${bridalstyle.makeupStyleId}">${bridalstyle.name}</a>
	<p> Description: ${bridalstyle.description }</p>
	<p> Colour Scheme: ${bridalstyle.colourScheme }</p>
	</div>
	</c:forEach>
</body>
</html>