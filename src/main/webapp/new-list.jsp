<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create A New Appointment List</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		Appointment Name: <input type="text" name="appointmentName"><br />
		Customer Name: <input type="text" name="customerName"><br /> 
		 Visit date: <input type="text" name="month" placeholder="mm" size="4"><input type="text" name="day" placeholder="dd" size="4">, <input type="text" name="year" placeholder="yyyy" size="4"> 
		Pets coming to the vet:<br />
<select name = "allItemsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.id}"> ${currentitem.petName} | ${currentitem.petType}</option>
</c:forEach>
</select><br/>
	 <input type="submit" value="Create List and Add Pets">
	</form>
	<a href="index.html">Go add new pets instead.</a>
</body>
</html>