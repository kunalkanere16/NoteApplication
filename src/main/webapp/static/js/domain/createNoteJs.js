/**
 * Created by: Kunal Kanere
 */
function addNote(){
	
	var title = $('#title').val();
	if(title==""){
		console.log("title is blank");
		$('#titleValidate').css("display","block");
	}else{
		$('#titleValidate').css("display","none");
		var content = $('#content').val();
		//$("#loading").css("display","block");
		$("#save").button('loading');
//		$("#submitBtn").attr('disabled','disabled');
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
	        	//	$("#loading").css("display","none");
	        		
	        		$("#success").css("display","block");
	        	//	alert("Action performed successfully, you will be redirected");
	        		setTimeout(function(){ window.location.href = "viewNoteList.page"; }, 3000);
	        		
	        	}else{
	        		//$("#loading").css("display","none");
	        		$("#save").button('reset');
	        	//	$("#submitBtn").removeAttr('disabled');
	        		$("#fail").css("display","block");
	        	//	alert("Could not complete the request");
	        	}
	        }
		});
	}
	
}

