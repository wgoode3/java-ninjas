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
		<h1>Top 3 Ninjas woot!</h1>
		<a href="/">Back to Home</a>
		<img src="/images/ninja.jpeg" alt="ninja picture" />

		<table class="table table-striped">
			<tr>
				<th>Name</th>
				<th>Hometown</th>
				<th>Level</th>
			</tr>
			<c:forEach items="${ninjas}" var="ninja">
				<tr>
					<td><a href="/ninjas/${ninja.id}">${ninja.name}</a></td>
					<td>${ninja.hometown}</td>
					<td>${ninja.level}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>