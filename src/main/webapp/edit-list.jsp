<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list</title>
</head>
<body>

<form action="editListDetailsServlet" method="post">
<input type="hidden" name="id" value="${listToEdit.id}">
List Name: <input type="text" name="speciesListName" value="${listToEdit.speciesListName}">
Species Name: <input type="text" name="species" value="${listToEdit.species.speciesName}">
Available Squishmallows: <br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value="${currentitem.id}"> ${currentitem.name} | ${currentitem.type} | ${currentitem.size}></option>
</c:forEach>

</select>
<br />
<input type="submit" value="Edit List and Add Squishmallows">
</form>
<a href="index.html">Go add new Squish instead.</a>

</body>
</html>