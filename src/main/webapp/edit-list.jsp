<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Appointment List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${listToEdit.id}"> 
		Appointment Name: <input type="text" name="appointmentName" value="${listToEdit.appointmentName}"><br />
		Customer Name: <input type="text" name="customerName" value="${listToEdit.customer.customerName}"><br />
		 Visit date: <input type="text" name="month" placeholder="mm" size="4" value="${month}"> <input type="text" name="day" placeholder="dd" size="4" value="${date}">, <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
		  Pets coming to the vet:<br />
		   <select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.petName}|${currentitem.petType}</option>
			</c:forEach>
		</select> <br /> 
	 <input type="submit" value="Edit visitation List and Add Pets">
	</form>
	<a href="index.html">Go add new pet instead.</a>
</body>
</html>