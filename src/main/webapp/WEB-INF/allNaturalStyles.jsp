<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Natural Styles</title>
</head>
<body>
	<a href="Main" >Return</a>
	<h1>List of natural Styles</h1>
	<a href="AddNatural">Add new</a>
	<h2>Select to view tutorial</h2>
	<c:forEach items="${naturalStyles}" var="naturalstyle">
	<div>
	<a href="DisplayNatural?id=${naturalstyle.makeupStyleId}">${naturalstyle.name}</a>
	<p>Description:${naturalstyle.description}</p>
	<p>Colour Scheme: ${naturalstyle.colourScheme}</p>
	</div>
	</c:forEach>
</body>
</html>