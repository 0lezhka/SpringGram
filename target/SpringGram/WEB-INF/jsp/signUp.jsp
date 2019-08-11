<%--
  Created by IntelliJ IDEA.
  User: Fox
  Date: 10.08.2019
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Sign up</title>
    <style>
        <%@include file="/WEB-INF/styles/signUp.css"%>
    </style>

    <link href="https://fonts.googleapis.com/css?family=Slabo+27px&display=swap" rel="stylesheet">
</head>

<body>
<div class="iconBlock">
    <img src="https://img.icons8.com/clouds/100/000000/edit-chat.png" alt="icon">
</div>

<div class="signInText">
    <h1>Sign up</h1>
    <p>Already have account? <a href="/userProfile/logIn">Log in</a></p>
</div>

<div class="signOnBlock">
    <form:form class="signOnForm" modelAttribute="userProfile">
        <c:if test="${isEmailBusy}">
            <a class="errorText">Email is busy</a>
        </c:if>
        <form:input type="email" path="email" placeholder="Email" class="inputField"/>
        <c:if test="${isNicknameBusy}">
            <a class="errorText">Nickname is busy</a>
        </c:if>
        <form:input path="nickname" placeholder="Nickname" class="inputField"/>
        <c:if test="${isPasswordBusy}">
            <a class="errorText">Password is busy</a>
        </c:if>
        <form:password path="password" placeholder="Password" class="inputField"/>
        <input type="password" placeholder="Type your password again" class="inputField">
        <input type="submit" value="Sign Up" class="submitButton">
    </form:form>

    <div class="signOnSplitter"></div>

    <div class="continueWithBlock">
        <div class="continueWithButtonWrapper">
            <div class="continueWithFacebookBlock">
                <div class="iconWrapper">
                    <img class="continueWithIcon" src="https://cdn1.iconfinder.com/data/icons/logotypes/32/square-facebook-256.png" alt="google icon">
                </div>
                <div class="textWrapper">
                    <a>Continue with Facebook</a>
                </div>
            </div>
            <div class="continueWithGoogleBlock">
                <div class="iconWrapper">
                    <img class="continueWithIcon" src="https://cdn3.iconfinder.com/data/icons/google-suits-1/32/1_google_search_logo_engine_service_suits-512.png" alt="google icon">
                </div>
                <div class="textWrapper">
                    <a>Continue with Google</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>



