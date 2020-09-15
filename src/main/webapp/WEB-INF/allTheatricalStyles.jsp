<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Theatrical Styles</title>
</head>
<body>
	<a href="Main" >Return</a>
	<h1>List of theatrical Styles</h1>
	<a href="AddTheatrical">Add new</a>
	<h2>Select to view tutorial</h2>
	<c:forEach items="${theatricalStyles}" var="theatricalstyle">
	<div>
	<a href="DisplayTheatrical?id=${theatricalstyle.makeupStyleId}">${theatricalstyle.name}</a> 
	<p>Description: ${theatricalstyle.description}</p>
	<p>Theme: ${theatricalstyle.theme}</p>
	</div>
	</c:forEach>
</body>
</html>