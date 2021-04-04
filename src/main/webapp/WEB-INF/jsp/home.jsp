<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 06.03.2021
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@page pageEncoding="UTF-8" %>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>My Study</title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-1">

        </div>
        <div class="col">

            <div class="main_title">

                <h1>Система управления студентами и их успеваемостью</h1>
            </div>
        </div>
        <div class="col-sm-1">
            <c:choose>
                <c:when test="${role eq 'guest' }">
                    <div class="loggout_button">
                        <a class="sml_btn" href="/logout">Login</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="loggout_button">
                        <a class="sml_btn" href="/logout">Logout</a>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>
<div class="main">
    <div class="container">

        <div class="row">
            <div class="col">
                <a class="nav_btn" href="/students">Студенты</a>
            </div>
            <div class="col">

                <a class="nav_btn" href="/lessons">Дисциплины</a>
            </div>
            <div class="col">
                <a class="nav_btn" href="/term-list">Семестры</a>
            </div>
        </div>
    </div>
</div>
</body>

</html>
