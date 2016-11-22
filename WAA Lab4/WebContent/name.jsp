<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAA Lab4</title>
</head>
<body>
<%if (session.getAttribute("remove")!=null)%>
${remove}
<%if (session.getAttribute("showNames")!=null) {%>
<div style="color:blue">List of Person<br>
<c:forEach var="personList" items="${showNames}">
  Key=${personList.key} First Name=${personList.firstName} Last Name=${personList.lastName}
 <br>
</c:forEach>
</div>
<%} else {%>
  <div style="color:blue">${noRecord}</div>
<%}%>
<form method='POST' action='${pageContext.request.contextPath}/servlet/AllNamesServlet'>
	<input type='submit' value='Show All Names'><br><br>
</form>
<form method='POST' action='${pageContext.request.contextPath}/servlet/AddNamesServlet'>
	Key=<input type='number' name='key'>&nbsp;First Name=
	<input type='text' name='firstName'>&nbsp;Last Name=
	<input type='text' name='lastName'>&nbsp;
	<input type='submit' value='Add'>
	<br><br>
	</form>
	<form method='GET' action='${pageContext.request.contextPath}/servlet/RemoveNamesServlet'>
	Key=
	<input type='number' name='keyToRemove' value='0'>&nbsp;
	<input type='submit' value='Remove'>
	</form>
</body>
</html>