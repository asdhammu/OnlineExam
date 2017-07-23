<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>

	<jsp:include page="header.jsp"/>
	
	<div class="container">
		<div class="row">You are student</div>
		<div class="row">${welcome}</div>
		<div class="row"> Question description: Write code to build a binary tree</div>
		<div class="row">
		
			<div class="col-lg-6">				
				<jsp:include page="editor.jsp"></jsp:include>
			</div>	
			<div class="col-lg-6">
			</div>
		</div>
		
	</div>
		
		
	<jsp:include page="footer.jsp"/>


</body>
</html>