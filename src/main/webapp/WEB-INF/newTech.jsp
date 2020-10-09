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
		<h1>Ninjutsu</h1>
		<a href="/">Back to Home</a> <img src="/images/ninja.jpeg"
			alt="ninja picture" />

		<form:form action="/techs" method="post" modelAttribute="newTech">
			<div class="form-group">
				<label>Technique Name:</label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Ninja:</label>
                <select name="ninja" class="form-control">
                <c:forEach items="${allNinjas}" var="ninja">
                    <option value="${ninja.id}">${ninja.name}</option>
                </c:forEach>
                </select>
			</div>
			<input type="submit" value="Add Technique" class="btn btn-outline-dark" />
		</form:form>
	</div>

</body>
</html>