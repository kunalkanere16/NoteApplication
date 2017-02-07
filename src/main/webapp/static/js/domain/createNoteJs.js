/**
 * 
 */
function addNote(){
	var title = $('#title').val();
	var content = $('#content').val();
	$("#loading").css("display","block");
	$("#submitBtn").attr('disabled','disabled');
	var url = "addNote.ajax";
	var msg = "title="+title+"&content="+content;

	$.ajax({
		url: url,
		type:'post',
		data:msg,
		dataType:'text',
        success: function(resp){   
        	resp = resp.replace(/^\s+|\s+$/g,"");
        //	alert(resp);
        	if(resp=="success"){
        		$("#loading").css("display","none");
        		alert("Action performed successfully, you will be redirected");
        		window.location.href = "viewNoteList.page";
        	}else{
        		$("#loading").css("display","none");
        		$("#submitBtn").removeAttr('disabled');
        		alert("Could not complete the request");
        	}
        }
	});
}