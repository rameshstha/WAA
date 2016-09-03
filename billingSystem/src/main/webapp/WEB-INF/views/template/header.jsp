<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
  
    <title>Billing System</title>

    <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- MaCarouselin CSS -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
	<script>
		var contextPath = "${pageContext.request.contextPath}";
	</script>
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-background">
	<div class="navbar-wrapper">
	    <div class="container">
	
	        <nav class="navbar navbar-inverse navbar-static-top">
	            <div class="container">
	                <div class="navbar-header">
	                    <a class="navbar-brand" href="#">Billing System</a>
	                </div>
	                <div id="navbar" class="navbar-collapse collapse">
	                   
	                    <ul class="nav navbar-nav pull-right">
	                        <c:if test="${pageContext.request.userPrincipal.name != null}">
	                            <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
	                           
	                            
	                            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
	
	                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
	                                <li><a href="<c:url value="/admin/main"/>">Go to Admin</a></li>
	                            </c:if>
	
	                        </c:if>
	
	                        <c:if test="${pageContext.request.userPrincipal.name == null}">
	                            <li><a href="<c:url value="/login" />">Login</a></li>
	                        </c:if>
	                    </ul>
	                </div>
	            </div>
	        </nav>
	
	    </div>
	</div>
</div>