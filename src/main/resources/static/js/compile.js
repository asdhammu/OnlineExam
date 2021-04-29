'use strict';

$(document).ready(function(){

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

});


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
