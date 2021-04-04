<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 06.03.2021
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="../../resources/css/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document).ready(function (even) {
            $("submit").click(function () {
                var checkvalue = [];
                $.each($("input[name='selected']:checked"), function () {
                    checkvalue.push($(this).val());
                });
                alert("checkvalue: " + checkvalue.join(", "));
            });
        });
    </script>
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
<form>
    <div class="container">
        <div class="info">
            <div class="row">
                <div class="col-sm-1">
                    <a href="/home">На&nbsp;главную</a>
                </div>

                <div class="col">
                    <div>

                        <input formmethod="post" formaction="/student-info" type="submit" class="students_btn1"
                               value="Посмотреть успеваемость выбранного студента">
                        <c:choose>
                            <c:when test="${role eq 'администратор'}">
                                <input formaction="/students/modify_student" formmethod="post" type="submit"
                                       class="students_btn1" value="Модифицировать выбранного студента">
                            </c:when>
                        </c:choose>

                        <div><c:choose>
                            <c:when test="${message eq '1'}">
                                <p>Нужно выбрать одного студента!</p>
                            </c:when>
                        </c:choose></div>
                    </div>
                </div>
                <div class="col">
                    <div>
                        <c:choose>
                            <c:when test="${role eq 'администратор'}">
                                <input formaction="/students/new-student" formmethod="get" class="students_btn2" type="submit"
                                       value="Создать студента">
                                <input formmethod="post" formaction="/students/deactivate" type="submit" class="students_btn2"
                                       value="Удалить выбранных студентов">
                            </c:when>
                        </c:choose>

                        <div><c:choose>
                            <c:when test="${message eq '2'}">
                                <p>Нужно выбрать одного или нескольких студентов!</p>
                            </c:when>
                        </c:choose></div>
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
                                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${st.date}"/></td>
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
</form>
</body>

</html>
