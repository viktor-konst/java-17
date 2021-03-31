<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 14.03.2021
  Time: 12:42
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
    <form class="">
    <div class="container">

        <div class="row">
            <div class="col-sm-1">
                <a class="sml_btn" href="/home">На&nbsp;главную</a>
            </div>
            <div class="col-sm-1">
                <a class="sml_btn" href="/students">Назад</a>
            </div>
            <div class="col"></div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col">


            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <h5 >Отображена информация для следующего студента: </h5>
                <table class="studetn_inf_table">
                    <tr class=" studetn_inf first_row">

                        <th class="studetn_inf">Фамилия</th>
                        <th class="studetn_inf">Имя</th>
                        <th class="studetn_inf">Группа</th>
                        <th class="studetn_inf">Дата поступления</th>
                    </tr>

                    <tr class="studetn_inf">

                        <td class="studetn_inf"><c:out value="${student.lastname}"></c:out></td>
                        <td class="studetn_inf"><c:out value="${student.firstname}"></c:out></td>
                        <td class="studetn_inf"><c:out value="${student.group.groupName}"></c:out></td>
                        <td class="studetn_inf"><c:out value="${student.date}"></c:out></td>

                    </tr>

                </table>
                <div class="col-sm-1"></div>
            </div>

            <div class="row marks">
                <div class="col-sm-1"></div>
                <div class="col-sm-5">

                    <table class="student_mark">
                        <tr class="student_mark first_row" >
                            <th class="student_mark"></th>
                            <th class="student_mark">Наименование дисциплины</th>
                            <th class="student_mark">Оценка</th>
                        </tr>
                        <c:forEach items="${studentProgress}" var="sp">

                            <tr>
                                <td class="student_mark"><input type="hidden" name="selectedMark" value="${sp.idStudentProgress}" ></td>
                                <td class="student_mark">${sp.lessonName}</td>
                                <td class="student_mark">
                                    <c:choose>
                                        <c:when test="${role eq 'администратор' or role eq 'учитель'}">
                                            <select name="marks">
                                                <option selected value="${sp.mark}">
                                                    <c:choose>
                                                        <c:when test="${sp.mark==0}">
                                                            <c:out value="-"></c:out>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:out value="${sp.mark}"></c:out>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </option>
                                                <option value="0">-</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${sp.mark==0}">
                                                    <c:out value="-"></c:out>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="${sp.mark}"></c:out>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>


                                        </td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
                <div class="col-sm-6">

                        <div class="row  mb-3">
                            <label for="colFormLabelLg" class="col-sm-4 col-form-label ">
                                <p>Выбрать&nbsp;семестр:</p>
                            </label>
                            <div class="col-sm-4">
                                <select name="termID" class="form-select" aria-label="Выберите семестр">

                                    <c:forEach items="${terms}" var="trm">
                                        <c:choose>
                                            <c:when test="${defaultTerm.id==trm.id}">
                                                <option value="${trm.id}" selected>${trm.termName}</option>
                                            </c:when>

                                            <c:otherwise>
                                                <option value="${trm.id}">${trm.termName}</option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>

                                </select>
                            </div>
                            <div class="col-sm-2">
                                <input formaction="/student-info" formmethod="post" type="submit" class="students_btn2 form-control " id="colFormLabelLg"
                                       value="Выбрать">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col"><h5>Средняя оценка за семестр:<c:choose>
                                <c:when test="${averageMark==0}">
                                    <c:out value="-"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${averageMark}"></c:out>
                                </c:otherwise>
                            </c:choose>
                            </h5></div>
                        </div>
                        <input  type="hidden" name="selected" value="${student.id}">
                    <c:choose>
                        <c:when test="${role eq 'администратор' or role eq 'учитель'}">
                            <input formmethod="post" formaction="student-info/modify-mark" type="submit" class="students_btn1 marks" value="Редактировать оценку">
                        </c:when>
                    </c:choose>




                </div>
            </div>
        </div>
    </div>
    </form>
</div>
</body>

</html>