<%--
  Created by IntelliJ IDEA.
  User: asdha
  Date: 5/28/2017
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<body>

    <jsp:include page="header.jsp"/>

	<div class="container">
		<div class="row">
		
			<div class="col-lg-6">
				${welcome}
				<jsp:include page="editor.jsp"></jsp:include>
			</div>	
			<div class="col-lg-6">
			</div>
		</div>
		
	</div>
	
    <jsp:include page="footer.jsp"/>
</body>
</html>