<%--
  Created by IntelliJ IDEA.
  User: binizmohamed
  Date: 4/6/20
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Sing up </title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"
            integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
    <style>
        #global{
            margin-left: 35%;
            margin-right: 35%;
            margin-top: 5%;
        }
    </style>

</head>
<body>

<div class="container">
    <header class="col-lg-12">
        <h1>sign up</h1>
        <form:errors path="user" cssClass="alert-danger" />
        <form:form method="post" action="${pageContext.request.contextPath}/save" modelAttribute="user">

            <div class="form-group">
                <label for="fullName">Full Name*</label>
                <form:input path="fullName" cssClass="form-control"  placeholder="Nom complet" />
                <form:errors path="fullName" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="email">Email*</label>
                <form:input path="email" cssClass="form-control"  placeholder="email" />
                <form:errors path="email" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="password">Password* </label>
                <form:input path="password" cssClass="form-control" type="password" placeholder="password " />
                <form:errors path="password" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="repeatedPassword">Confirm password* </label>
                <form:input path="repeatedPassword" cssClass="form-control" type="password" placeholder=" confirm your password" />
                <form:errors path="repeatedPassword" cssClass="text-danger" />
            </div>


            <input class="btn btn-primary" type = "submit" value = "Submit"/>
        </form:form>
    </header>
</div>
</body>
</html>
