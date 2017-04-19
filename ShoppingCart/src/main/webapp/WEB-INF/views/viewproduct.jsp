<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
<style>
p {
    font-size: 100%;
}</style>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link xmlns:sec="http://www.springframework.org/security/tags">
<title>Product Details</title>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Admin">Admin Home</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="ManageProducts">Manage Products</a></li>
      <li><a href="ManageSupplier">Manage Suppliers</a></li>
      <li><a href="ManageUsers">Manage Users</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
  <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<h2>Product Details</h2><br><br><br><br>
      	<div class="col-md-7">
					<div class="container">
           
            <img src='<x:url value="/resources/images/${product.image}"/>'/>
            </div>
            </div>
            
            <div class="col-md-5">
					<div class="container" >
           <p> ${product.name}</p><br><br>
            <p>${product.price}</p><br><br>
          <p> ${product.description}</p><br><br>
          <sec:authorize access="hasRole('ROLE_USER')">
        <a href="viewCart?id=${product.id}">  <button type="button" class="btn btn-success">
							 Add to Cart
						</button>
					</sec:authorize>	</a>
           </div>
           </div>
            
            
      
					
					
      	
      
   </body>
</html>
