<%--
  Created by IntelliJ IDEA.
  User: asdha
  Date: 5/28/2017
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/common.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <link rel="icon" href="data:;base64,=">
</head>

<div class="container" id="header">
	<div class="row">
		<div class="col-lg-8"></div>
		<div class="col-lg-4">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
		        <form id="logoutForm" method="POST" action="logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>
		
		        <h2 align="right">${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>	
		        
		    </c:if>
		</div>
	</div>	
    

</div>


