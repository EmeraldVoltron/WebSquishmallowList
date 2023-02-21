<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Species Lists</title>
</head>
<body>
<form method="post" action="listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.speciesListName}</h2></td>
</tr>
<tr>
	<td colspan="3">Species Name: ${currentlist.species.speciesName}</td>
</tr>
	<c:forEach var="listVal" items="${currentlist.listOfSquish}">
		<tr><td></td><td colspan="3"> ${listVal.name}, ${listVal.type}, ${listVal.size} </td>
		</tr>
	</c:forEach>
</c:forEach>

</table>

<input type="submit" value="edit" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
<input type="submit" value="add" name="doThisToList">

</form>
<a href="addSquishForListServlet">Create a new List</a>
<a href="index.html">Insert a new Squish</a>

</body>
</html>