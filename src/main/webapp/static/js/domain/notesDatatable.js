/**
 * Created by: Kunal Kanere
 */

$(function () {
    //alert("Ready!");
    ajaxDatatable();
});

function ajaxDatatable() {
    var url = "getNoteList.ajax";
//    var status = $( "#status" ).val();
    $('#table1').dataTable({
        "bJQueryUI": true,
        "bProcessing": true,
        "bServerSide": true,
        "bDestroy": true,
        "bAutoWidth": true,
        //"sScrollX": "940px",
        //"sScrollY": "250px",
        "bScrollCollapse": true,
        "aaSorting": [[0, "asc"]],
        "aoColumns": [
            null,
            null,
            {"bSortable" : false}
        ],
        "sAjaxSource": url,
        "fnServerData": function (sSource, aoData, fnCallback) {
            // Add some extra data to the sender
            //aoData.push({"name":"status", "value":status});
            $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": fnCallback
            });
        }
    });
}

function deleteNote(id){
	var url = "deleteNote.ajax";
	var msg = "id="+id;
	//$("#loading").css("display","block");
	$.ajax({
		url: url,
		type:'post',
		data:msg,
		dataType:'text',
        success: function(resp){   
        	resp = resp.replace(/^\s+|\s+$/g,"");
        //	alert(resp);
        	if(resp=="success"){
        		//$("#loading").css("display","none");
        		//alert("Action performed successfully");
        		$("#success").css("display","block");
        		ajaxDatatable();
        	}else{
        	//	$("#loading").css("display","none");
        		//alert("Could not complete the request");
        		$("#fail").css("display","block");
        	}
        }
	});
}