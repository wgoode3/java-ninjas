<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ninja Info</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>Ninja Info</h1>
        <a href="/ninjas/top/3">Show me the best ninjas!</a>
        <img src="/images/ninja.jpeg" alt="ninja picture" />
        <div class="row mt-5">
            <div class="col-sm-8">
                <table class="table table-striped">
                    <tr>
                        <th>Name</th>
                        <th>Hometown</th>
                        <th>Level</th>
                        <th style="width: 50px;"></th>
                    </tr>
                    <c:forEach items="${ninjas}" var="ninja">
                        <tr>
                            <td><a href="/ninjas/${ninja.id}">${ninja.name}</a></td>
                            <td>${ninja.hometown}</td>
                            <td>${ninja.level}</td>
                            <td><a href="/ninjas/${ninja.id}/delete" class="btn btn-sm btn-outline-danger">&times;</a></td>
                        </tr>
                    </c:forEach>
                </table>
            
            </div>
            <div class="col-sm-4">
                <form:form action="/ninjas" method="post" modelAttribute="newNinja">
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
		            <input type="submit" value="Add Ninja" class="btn btn-outline-dark" />
		        </form:form>
            </div>
        </div>
    </div>
</body>
</html>