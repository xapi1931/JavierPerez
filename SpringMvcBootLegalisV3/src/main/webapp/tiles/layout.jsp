<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="app.name"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
        <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    
    <link href="../css/sticky-footer-navbar.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
    <link href="../css/starter-template.css" rel="stylesheet">
</head>
<body>
  	<tiles:insertAttribute name="header" />
    <main role="main" class="container">
    		<div class="text-center">
    			<tiles:insertAttribute name="body" />
    		</div>
    </main><!-- /.container -->
    <tiles:insertAttribute name="footer" />

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="../js/vendor/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  
</body>
</html>