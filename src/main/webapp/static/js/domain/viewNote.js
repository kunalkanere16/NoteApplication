/**
 * Created by: Kunal Kanere
 */

function updateNote(){
	var id=$('#id').val();
	var title=$('#title').val();
	if(title==""){
		console.log("title is blank");
		$('#titleValidate').css("display","block");
	}else{
		$('#titleValidate').css("display","none");
		var content=$('#content').val();
//		$("#loading").css("display","block");
		$("#update").button('loading');
		//$("#submitBtn").attr('disabled','disabled');
		var url = "updateNote.ajax";
		var msg = "id="+id+"&title="+title+"&content="+content;

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
	        		$("#update").button('reset');
	        		$("#success").css("display","block");
	        		//alert("Action performed successfully!");
	        		//$("#submitBtn").removeAttr('disabled');
	        	}else{
	        		//$("#loading").css("display","none");
	        		//alert("Could not complete the request");
	        		$("#update").button('reset');
	        		$("#fail").css("display","block");
	        		$("#submitBtn").removeAttr('disabled');
	        		
	        	}
	        }
		});
	}
	
}

/*window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);*/