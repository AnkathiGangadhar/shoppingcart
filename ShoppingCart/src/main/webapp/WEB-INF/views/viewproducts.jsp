<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link xmlns:sec="http://www.springframework.org/security/tags">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All products</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="viewproducts">View Products</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="EndUser" style="color:white;">Welcome... <%=session.getAttribute("LoggedInUser")%></a></li>
          <li><a href="logout"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
      
    </ul>
  </div>
</nav>
<div class="container">
<div ng-app="myApp" ng-controller="customersCtrl">
<input type="text" class="form-control" ng-model="searchBy.Name"/>
<table class="table table-hover table-bordered">
  <tr>
       <th>Product Id</th>
       <th>Product Name</th>
       <th>Product Price</th>
       <th>Product Description</th>
       <th>Action</th>
  </tr>
  <tr ng-repeat="x in names | filter:searchBy">
    <td>{{x.id}}</td>
    <td>{{x.Name}}</td>
    <td>{{x.Price}}</td>
    <td>{{x.Description}}</td>
    <td>
    <a href="${pageContext.servletContext.contextPath}/viewproduct?id={{x.id}}"><span>View</span></a></td>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <td><a href="${pageContext.servletContext.contextPath}/editproduct?id={{x.id}}"><span>Edit</span></a></td>
   <td> <a href="${pageContext.servletContext.contextPath}/delete?id={{x.id}}"><span>Delete</span></a></td>
     </sec:authorize>
  </tr>
</table>
<a href="addpro" class="btn btn-info">Add Product</a>
<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("list")
    .then(function (response) {$scope.names = response.data;});
});
</script>
	<footer class="container-fluid text-center">
		<p>©Bibliopole-All Rights Reserved</p>
		<P>2017</P>
	</footer>

</body>
</html>