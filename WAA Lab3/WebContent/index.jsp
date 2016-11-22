<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAA Lab3</title>
</head>
<body>
<h2>Hello World</h2>
<% for(int i = 1; i <=10; i++ ){ %>
      <strong><%= i %></strong><br> 
<%} %><br>
<a href="guessNumber.jsp">Click for Guess Number</a>
</body>
</html>