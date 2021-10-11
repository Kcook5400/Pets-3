<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment List</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists }" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id }"></td>
					<td><h2>${currentlist.appointmentName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Customer: ${currentlist.customer.customerName}</td>
				</tr>
				<tr>
					<td colspan="3">Visit Date: ${currentlist.visitDate}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.petsList}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.petName},${listVal.petType}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> <input
			type="submit" value="delete" name="doThisToList"> <input
			type="submit" value="add" name="doThisToList">
	</form>
	<a href="addAppointmentsForListServlet">Create a new List</a>
	<a href="index.html">Insert a new pet</a>
</body>
</html>