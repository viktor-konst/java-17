<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 10.03.2021
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
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
            <div class="loggout_button">
                <a class="sml_btn" href="/logout">Logout</a>
            </div>
        </div>
    </div>
</div>
<div class="info">
    <div class="container">

        <div class="row">
            <div class="col-sm-1">
                <a href="/home">На&nbsp;главную</a>
            </div>
            <div class="col-sm-4">

            </div>

        </div>
    </div>
    <form>
    <div class="container">

        <div class="row ">
            <div class="col-sm-1"></div>
            <div class="col-sm-6">
                <h3 class="">Список дисциплин </h3></div>
        </div>
        <div class="row ">
            <div class="col-sm-1"></div>
            <div class="col-sm-6">
                <table>
                    <tr class="first_row">
                        <th></th>
                        <th>Наименование дисциплины</th>
                    </tr>
                    <c:forEach items="${lessons}" var="ls">
                        <tr>
                            <td><input name="selected" type="checkbox" value="${ls.id}"></td>
                            <td>${ls.lessonName}</td>

                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="col-sm-4">
                <div class="input_form">
                    <c:choose>
                        <c:when test="${role eq 'администратор'}">
                            <input formaction="/lessons/new-lesson" formmethod="get" type="submit" class="students_btn1"
                                   value="Создать дисциплину">

                            <input formaction="/lessons/modify-lesson" formmethod="post" type="submit" class="students_btn1" value="Модифицировать выбранную дисциплину">

                            <input formmethod="post" formaction="/lessons/deactivate-lessons" type="submit" class="students_btn1" value="Удалить выбранные дисциплины">
                        </c:when>
                    </c:choose>

                    <div><c:choose>
                        <c:when test="${message eq '2'}">
                            <p>Нужно выбрать одну или несколько дисциплин!</p>
                        </c:when>
                    </c:choose></div>
                    <div><c:choose>
                        <c:when test="${message eq '1'}">
                            <p>Нужно выбрать одину дисциплину!</p>
                        </c:when>
                    </c:choose></div>
                </div>
            </div>
        </div>
    </div></form>
</div>


</body>

</html>
