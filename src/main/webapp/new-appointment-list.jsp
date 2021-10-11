<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "createNewListServlet" method = "post">
Appointment Name: <input type = "text" name = "appointmentName"> <br>
Customer Name: <input type = "text" name = "CustomerName"><br>
Visit date: <input type = "text" name = "month" placeholder = "mm" size = "4">
<input type="text" name = "day" placeholder = "dd" size = "4">
<input type = "text" name = "year" placeholder = "yyyy" size = "4">
Pets: <br>
<select name="allPetsToAdd" multiple size ="6">
<c:forEach items="${requestScope.allItems}" var = "currentPet">
<option value = "${currentitem.id}"> ${currentitem.store} | ${currentitem.item}</option>
</c:forEach>
</select>

<br>
<input type = "submit" value = "Create list and Add Items">
</form>
<a href = "index.html"> Go add new items instead.</a>
</body>
</html>