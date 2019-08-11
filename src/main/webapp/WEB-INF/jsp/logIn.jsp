<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Fox
  Date: 10.08.2019
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Log in</title>
    <style>
        <%@include file="/WEB-INF/styles/logIn.css"%>
    </style>
    <link href="https://fonts.googleapis.com/css?family=Slabo+27px&display=swap" rel="stylesheet">
</head>

<body>
<div class="iconBlock">
    <img src="https://img.icons8.com/clouds/100/000000/edit-chat.png" alt="icon">
</div>

<div class="signInText">
    <h1>Log in</h1>
    <p>New to SpringGram? <a href="/userProfile/signUp">Sign up</a></p>
</div>

<div class="signOnBlock">
    <form:form class="signOnForm" modelAttribute="userProfile">
        <c:if test="${isLoginDataInvalid}">
            <a class="errorText">Email or password is incorrect</a>
        </c:if>

        <form:input type="email" path="email" placeholder="Email" class="inputField"/>
        <form:password path="password" placeholder="Password" class="inputField"/>
        <div class="signOnFormAdditionalBlock">
            <label><input type="checkbox" class="rememberMeCheckbox" name="rememberMe">Remember Me</label>
            <a href="lol">Forgot password?</a>
        </div>
        <input type="submit" value="Log in" class="submitButton">
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



