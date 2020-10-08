<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Info</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Ninja Info</h1>
		<a href="/">Home</a>
		<form:form action="/ninjas/${singleNinja.id}/update" method="post"
			modelAttribute="singleNinja">
			<div class="form-group">
				<label>Name:</label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Hometown:</label>
				<form:input path="hometown" class="form-control" />
				<form:errors path="hometown" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Level:</label>
				<form:input path="level" type="number" class="form-control" />
				<form:errors path="level" class="text-danger" />
			</div>
			<input type="submit" value="Edit Ninja" class="btn btn-outline-dark" />
		</form:form>
    </div>
</body>
</html>