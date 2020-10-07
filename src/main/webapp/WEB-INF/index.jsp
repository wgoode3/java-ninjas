<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <img src="/images/ninja.jpeg" alt="ninja picture" />
        <form action="/ninjas" method="post">
            <div class="form-group">
                <label>Name:</label>
                <input type="text" name="name" class="form-control" />
            </div>
            <div class="form-group">
                <label>Hometown:</label>
                <input type="text" name="hometown" class="form-control" />
            </div>
            <div class="form-group">
                <label>Level:</label>
                <select name="level" class="form-control">
                    <option>Master</option>
                    <option>Junior</option>
                    <option>Apprentice</option>
                    <option>Senior</option>
                </select>
            </div>
            <input type="submit" value="Add Ninja" class="btn btn-outline-dark" />
        </form>
        ${ ninjas }
    </div>
</body>
</html>