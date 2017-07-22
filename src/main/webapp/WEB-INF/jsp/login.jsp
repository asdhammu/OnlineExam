<%--
  Created by IntelliJ IDEA.
  User: asdha
  Date: 5/28/2017
  Time: 1:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="icon" href="data:;base64,=">
    <title>Login</title>
</head>
<body>

    <jsp:include page="header.jsp"/>


    <div class="container">

        <form method="POST" action="${contextPath}/login" class="form-signin">
            <h2 class="form-heading">Log in</h2>

            <div class="form-group ${error != null ? 'has-error' : ''}">
                <span>${message}</span>
                <input name="username" type="text" class="form-control" placeholder="Username"
                       autofocus="true"/>
                <input name="password" type="password" class="form-control" placeholder="Password"/>
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit">Log In</button>
                <h4 class="text-center"><a href="registration">Create an account</a></h4>
            </div>

        </form>

    </div>


    <jsp:include page="footer.jsp"/>
</body>
</html>
