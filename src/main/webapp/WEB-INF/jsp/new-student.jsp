<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 09.03.2021
  Time: 12:41
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
                <a class="sml_btn" href="">Loggout</a>
            </div>
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
                <a class="sml_btn" href="/students">Назад</a>
            </div>
            <div class="col-sm-8">
                <h4>Для создания студента заполните все поля и нажмите кнопку "Создать"</h4>
            </div>


            <div class="col-sm-2">

            </div>
        </div>
    </div>
    <div class="info">
        <div class="container">
            <div class="row">

                <div class="col">
                    <form method="post">
                        <div class="row ">
                            <label for="colFormLabelSm" class="col-sm-2 col-form-label ">Фамилия</label>
                            <div class="col-sm-8">
                                <input type="text" name="lastname" class="form-control " id="colFormLabelSm" placeholder="Фамилия">
                            </div>
                        </div>
                        <div class="row ">
                            <label for="colFormLabel" class="col-sm-2 col-form-label">Имя</label>
                            <div class="col-sm-8">
                                <input type="text" name="firstname" class="form-control" id="colFormLabel" placeholder="Имя">
                            </div>
                        </div>
                        <div class="row  ">
                            <label for="colFormLabelLg" class="col-sm-2 col-form-label ">Группа</label>
                            <div class="col-sm-8">
                                <select class="form-select" name="group" aria-label="Default select example">
                                    <option selected>Выберете группу</option>
                                    <c:forEach items="${groupList}" var="gl">
                                        <option value="${gl.id}">${gl.groupName}</option>
                                    </c:forEach>

                                </select>
                            </div>
                        </div>
                        <div class="row  mb-3">
                            <label for="colFormLabelLg"
                                   class="col-sm-2 col-form-label ">Дата&nbsp;поступления</label>
                            <div class="col-sm-8">
                                <input type="text" name="date" class="form-control " id="colFormLabelLg"
                                       placeholder="Дата поступления">
                            </div>
                        </div>
                        <input  type="submit" value="Создать" class="students_btn2">
                    </form>

                </div>

            </div>
        </div>
    </div>

</div>
</body>

</html>
