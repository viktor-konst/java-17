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
    <link rel="stylesheet" href="resources/css/style.css">
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

        </div>
    </div>
</div>
<div class="main">
    <div class="container">
        <div class="login-page">
            <div class="auth-form">

                <form action="/auth"  method="post" class="login-form">
                    <input name="username" type="text" placeholder="username" />
                    <input name="password" type="password" placeholder="password" />
                    <input type="submit" value="Войти" class="login-btn">

                </form>
                <div><c:choose>
                    <c:when test="${message eq '3'}">
                        <h6  class="input_error">Неверный логин или пароль!</h6>
                    </c:when>
                </c:choose></div>
            </div>
        </div>

    </div>
</div>
</body>

</html>