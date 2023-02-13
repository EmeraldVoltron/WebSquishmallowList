<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Squish Collection</title>
</head>
<body>
<h2>Your collection: </h2>
<h3>Select the item you would like to edit or delete, or press add to add more to your collection.</h3>
<form method="post" action="navigationServlet">

<table>

<c:forEach items="${requestScope.allSquish}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>${currentitem.name}</td>
	<td>${currentitem.type}</td>
	<td>${currentitem.size}</td>
</tr>
</c:forEach>

</table>
<input type="submit" value="edit" name="doThisToItem">
<input type="submit" value="delete" name="doThisToItem">
<input type="submit" value="add" name="doThisToItem">
</form>

</body>
</html>