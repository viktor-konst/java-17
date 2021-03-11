<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 06.03.2021
  Time: 16:13
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
            <div class="loggout_button">
                <a class="sml_btn" href="">Loggout</a>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="info">
        <div class="row">
            <div class="col-sm-1">
                <a href="/home">На&nbsp;главную</a>
            </div>

            <div class="col">
                <div>
                    <form>   <input type="submit" class="students_btn1" value="Посмотреть успеваемость выбранного студента"></form>

                    <form>  <input type="submit" class="students_btn1" value="Модифицировать выбранного студента"></form>
                </div>
            </div>
            <div class="col">
                <div>
                    <form  action="/students/new-student" method="get">
                        <input class="students_btn2" type="submit"  value="Создать студента"></form>
                    <form> <input type="submit" class="students_btn2" value="Удалить выбранных студентов"></form>
                </div>
            </div>

            <div class="col-sm-4">

            </div>

        </div>
        <div class="info">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <div>
                        <h3>Список студентов</h3>
                        <table>
                            <tr class="first_row">
                                <th></th>
                                <th>Фамилия</th>
                                <th>Имя</th>
                                <th>Группа</th>
                                <th>Дата поступления</th>
                            </tr>
                            <c:forEach items="${students}" var="st">
                            <tr>
                                <td><input name="selected" type="checkbox" value="${st.id}"></td>
                                <td>${st.lastname}</td>
                                <td>${st.firstname}</td>
                                <td>${st.group.groupName}</td>
                                <td>${st.date}</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="col-sm-1"></div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
