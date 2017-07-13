<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>   
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ACE in Action</title>
<style type="text/css" media="screen">
    .ace_editor {
		border: 1px solid lightgray;
		margin: auto;
		height: 200px;
		width: 80%;
	}
	.scrollmargin {
		height: 80px;
        text-align: center;
	}
</style>
</head>
<body>

<!-- <div class="scrollmargin"></div> -->
<pre id="editor" style="width:900px"></pre>

<!-- load ace -->
<script src="${contextPath}/resources/src-noconflict/ace.js"></script>
<!-- load ace language tools -->
<%-- <script src="${contextPath}/resources/src-noconflict/ext-language_tools.js"></script> --%>
<script>

var editor = ace.edit("editor");
editor.setTheme("ace/theme/tomorrow");
editor.session.setMode("ace/mode/java");
editor.setAutoScrollEditorIntoView(true);
editor.setOption("maxLines", 100);
</script>

<script src="${contextPath}/resources/show_own_source.js"></script>
</body>
</html>