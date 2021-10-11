<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Pet</title>
</head>
<body>
	<form action="editPetServlet" method="post">
		Pet name: <input type="text" name="petName" value="${itemToEdit.petName}">
		Pet type: <input type="text" name="petType" value="${itemToEdit.petType}">
		<input type="hidden" name="id" value="${itemToEdit.id}"> 
		<input type="submit" value="Save Edited Pet Info">
	</form>
</body>
</html>