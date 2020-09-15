<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing profile</title>
</head>
<body>
<h1>Editing Profile</h1>
<f:form method="post" action="EditProfileSubmit" modelAttribute="subscriber">
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
		<f:label path="password">Password: </f:label>
		<f:input path="password" type="password" required="required"/>
	</div>
	<div>
		<button type="submit">Update</button>
	</div>
		<f:hidden path="subscriberId"/>
		</f:form>
</body>
</html>