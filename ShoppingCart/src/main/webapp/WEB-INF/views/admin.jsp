<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  
</head>
<body>
<nav class="navbar navbar-inverse" style="background-color:black;">
  <div class="container-fluid">
   
    <ul class="nav navbar-nav">
      <li><a href="home" style="color:white;">Home</a></li>
      <li><a href="viewproducts" style="color:white;">Manage Products</a></li>
      <li><a href="viewsuppliers" style="color:white;">Manage Suppliers</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="EndUser" style="color:white;">Welcome... <%=session.getAttribute("LoggedInUser")%></a></li>
      <li><a href="j_spring_security_logout" style="color:white;"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
</sec:authorize>