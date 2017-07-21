<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>   
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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


<!-- <div class="scrollmargin"></div> -->
<!-- <div id="editor" style="width:900px"> hello india</div>
 -->
<div class="row">
	<pre id="description" style="width:900px">
	/**
	Hello world
	**/	
	public String getName(String name){
		
	}
	</pre>

<textarea id="code"></textarea>

</div>
<div class="row" style="padding-top:10px">
	
	<span>INPUT:</span>
</div>

<div class="row" style="padding-top:10px">
	
	<textarea id="input"></textarea>
</div>
<div class="row" style="padding-top:10px">
	<button type="button" onclick="compileCode()" class="btn btn-lg btn-primary">COMPILE</button>
</div>
<div class="row" id="compileResult">
</div>
 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script> 
<!-- load ace -->
<script src="${contextPath}/resources/src-noconflict/ace.js"></script>
<!-- load ace language tools -->
<script src="${contextPath}/resources/src-noconflict/ext-language_tools.js"></script>
<script>

var editor = ace.edit("description");
editor.setTheme("ace/theme/tomorrow");
editor.session.setMode("ace/mode/java");
editor.setAutoScrollEditorIntoView(true);
editor.setOption("maxLines", 50);
editor.setOptions({
    enableBasicAutocompletion: true,
    enableSnippets: true,
    enableLiveAutocompletion: false
});

editor.session.on('change', function(){
	  txtArea.val(editor.session.getValue());
});

	

var row = editor.session.getLength() - 3;
var column = editor.session.getLine(row).length // or simply Infinity
editor.gotoLine(row + 1, column);


/* $(document).ready(function() {
    $('textarea#code').hide();
});
 */
var txtArea = $("textarea#code").hide();

 
 
function compileCode() {
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var dataValue = document.getElementById('code').value;
    var inputValue = document.getElementById('input').value
		$.ajax({
            url: 'compile',
            beforeSend: function(request) {
                request.setRequestHeader(header, token);
            },
            type: 'post',
            dataType: 'text',
            data: {"compileCode":dataValue,"input":inputValue},
            success: successHandler
    });
		
		function successHandler(data) {		
			$('#compileResult').html(data);
	       
	    }
	
} 




</script>	

<!-- <script src="resources/show_own_source.js"></script>
 -->