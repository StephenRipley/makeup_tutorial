<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit artist</title>
</head>
<body>
<h1>Editing ${artist.fullName}</h1>
<f:form method="post" action="EditArtistSubmit" modelAttribute="artist">
	<div>
	<p>${errorMessage}</p>
		<f:label path="firstname"> First Name: </f:label>
		<f:input path="firstname" type="text" required="required"/>
	</div>
	<div>
		<f:label path="lastname">Last Name: </f:label>
		<f:input path="lastname" type="text" required="required"/>
	</div>
	<div>
		<f:hidden path="email"/>
	</div>
	<div>
		<f:label path="socialmedia">Social Media:</f:label>
		<f:input path="socialmedia" type="text" required="required"/>
	</div>
	<div>
		<f:label path="password">Password: </f:label>
		<f:input path="password" type="password" required="required"/>
	</div>
	<div>
		<f:label path="styleType">Style: </f:label>
		<f:select path="styleType" items="${styleType}" itemLabel="name" required="required"/>
	</div>
	<div>
		<button type="submit">Update</button>
	</div>
		<f:hidden path="artistId"/>
</f:form>
</body>
</html>