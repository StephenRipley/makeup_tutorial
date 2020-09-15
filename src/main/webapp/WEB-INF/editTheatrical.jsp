<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing look</title>
</head>
<body>
<h1> Editing ${bridalstyle.name}</h1>
	<f:form method="post" action="EditTheatricalSubmit" modelAttribute="theatricalstyle">
		<div>
			<p>${errorMessage}</p>
			<f:label path="name">Name: </f:label>
			<f:input path="name" type="text" required="required"/>
		</div>
		<div>
			<f:label path="description">Description: </f:label>
			<f:input path="description" type="text" required="required"/>
		</div>
		<div>
			<f:label path="theme">Theme: </f:label>
			<f:input path="theme" type="text" required="required"/>
		</div>
		<div>
			<f:label path="products">Products: </f:label>
			<f:input path="products" type="text" required="required"/>
		</div>
		<div>
			<f:label path="completionTime">Completion Time: </f:label>
			<f:input path="completionTime" type="text" required="required"/>
		</div>
		<div>
			<f:label path="tutorial">Tutorial: </f:label>
			<f:input path="tutorial" type="text" required="required"/>
		</div>
		<div>
			<f:label path="rating">Rating: </f:label>
			<f:input path="rating" type="text" required="required"/>
		</div>
			<div>
			<f:label path="artist">Artist: </f:label>
			<f:select path="artist" items="${allArtists}" itemLabel="fullName" required="required"/>
		</div>
		<div>
			<button type="submit">Update ${theatricalstyle.name}</button>
		</div>
		<f:hidden path="makeupStyleId"/>
	</f:form>

</body>
</html>