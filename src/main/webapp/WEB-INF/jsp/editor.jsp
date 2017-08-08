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
	
	<textarea id="input">Hello World!</textarea>
</div>

<div id="wait">
	<img src='resources/gif/loader.gif' width="64" height="64" /><br>Compiling..
</div>

<div class="row" style="padding-top:10px">
	<button type="button" onclick="compileCode()" class="btn btn-lg btn-primary">COMPILE</button>
</div>
<div class="row" style="padding-top:10px">
<pre id="compileResult">
	Compile Result:
</pre>
 </div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script> 
<!-- load ace -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.8/ace.js"></script>
<!-- load ace language tools -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.8/ext-language_tools.js"></script>
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

$("#compileResult").hide(); 
 
function compileCode() {
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var dataValue = document.getElementById('code').value;
    var inputValue = document.getElementById('input').value
		$.ajax({
            url: 'compile',
            beforeSend: function(request) {
                request.setRequestHeader(header, token);
                $("#wait").css("display", "block");
                $("#compileResult").hide();
            },
            complete: function(){
            	$("#wait").css("display", "none");	
            },
            type: 'post',
            dataType: 'text',
            data: {"compileCode":dataValue,"input":inputValue},
            success: successHandler
    });
		
	function successHandler(data) {
		$('#compileResult').html("Compile Result\n" + data);
		$('#compileResult').show();
       
    }
	
} 




</script>	

<!-- <script src="resources/show_own_source.js"></script>
 -->