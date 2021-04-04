<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 20.03.2021
  Time: 9:15
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
<div class="info">
    <div class="container ">

        <div class="row ">

            <div class="col-sm-1">
                <a class="sml_btn" href="/home">На&nbsp;главную</a>
            </div>
            <div class="col-sm-1">
                <a class="sml_btn" href="/term-list">Назад</a>
            </div>
            <div class="col-sm-8">
                <h4>Для модификации семестра заполните поля и нажмите кнопку "Модифицировать"</h4>
            </div>


            <div class="col-sm-2">

            </div>
        </div>
    </div>
    <div class="info">
        <form method="post">
            <div class="container">
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col">
                        <div class="">
                            <div class="row ">
                                <label for="colFormLabelSm" class="col-sm-2 col-form-label ">Название</label>
                                <div class="col-sm-6">
                                    <input type="text" name="termName" class="form-control " id="colFormLabelSm"
                                           value="${term.termName}" placeholder="Название">
                                </div>
                            </div>
                            <div class="row ">
                                <label for="colFormLabel" class="col-sm-2 col-form-label">Длительность</label>
                                <div class="col-sm-6">
                                    <input type="text" name="duration" class="form-control" id="colFormLabel"
                                           value="${term.duration}" placeholder="Длительность">
                                </div>
                            </div>
                            <div class="row  ">
                                <label for="colFormLabelLg" class="col-sm-2 col-form-label ">Дисциплины</label>
                                <div class="col-sm-6">
                                    <select class="form-select" name="lessons" size="10" multiple
                                            aria-label="multiple select example">

                                        <c:forEach items="${lessons}" var="ls">
                                            <c:forEach items="${lessonsOfTerm}" var="lsOfTerm">
                                                <c:choose>
                                                    <c:when test="${ls.lessonName == lsOfTerm.lessonName}">
                                                       <c:set var="var" value="${true}"></c:set>

                                                    </c:when>

                                                </c:choose>
                                            </c:forEach>
                                            <c:choose>
                                                <c:when test="${var eq true}"><option value="${ls.id}" selected>${ls.lessonName}</option>
                                                    <c:set var="var" value="${false}"></c:set>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${ls.id}" >${ls.lessonName}</option>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:forEach>
                                    </select>
                                    <input type="hidden" name="termID" value="${term.id}">
                                    <input type="submit" class="students_btn2 create_btns" value="Модифицировать">
                                    <div><c:choose>
                                        <c:when test="${message eq '1'}">
                                            <p class="input_error">Поля не должны быть пустыми!</p>
                                        </c:when>
                                    </c:choose></div>
                                </div>
                            </div>


                        </div>
                    </div>

                </div>
        </form>
    </div>
</div>

</div>
</body>

</html>