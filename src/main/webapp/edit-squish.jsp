<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Squishmallow</title>
</head>
<body>
<h2>Edit a Squishmallow: </h2>
<h3>Enter the values you would like to change.</h3>
<form action="editSquishServlet" method="post">
Squishmallow Name: <input type="text" name="name" value="${squishToEdit.name}">
Type: <input type="text" name="type" value="${squishToEdit.type}">
Size: <input type="text" name="size" value="${squishToEdit.size}">
<input type="hidden" name="id" value="${squishToEdit.id}">
<input type ="submit" value="Saved Edited Squish">

</form>
</body>
</html>