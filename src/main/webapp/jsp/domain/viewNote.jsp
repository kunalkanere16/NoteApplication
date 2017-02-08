<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../common/header.jsp"%>
<script src="static/js/domain/viewNote.js"></script>
<%@include file="../common/nav.jsp"%>
	<div id="success" style="display:none" class="alert alert-success col-sm-offset-2 col-sm-5" >
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	  	<strong>Success!</strong> Updates were saved.
	</div>
	<div id="fail" style="display:none" class="alert alert-danger col-sm-offset-2 col-sm-5">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	  <strong>Error!</strong> Updates could not be saved.
	</div>
	
    <div class="container">
  
		<form class="form-horizontal">
		  	<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-6">
		      	<h2>Edit Note</h2>
		  		<hr/>
		      </div>
		    </div>
  	
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="title">Title:</label>
		      <div class="col-sm-4">
		        <input type="text" class="form-control" id="title" placeholder="Enter title" value="${note.title}">
		        <div id="titleValidate" style="display:none"><span  ><font color="red">* Please fill this field</font></span></div>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="conent">Content:</label>
		      <div class="col-sm-6">          
		        <textarea class="form-control" rows="6" id="content" placeholder="Enter content">${note.content}</textarea>
		      </div>
		    </div>
		    
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-3">
		      	<a href="#" class="btn btn-primary" role="button" data-toggle="modal" id="update"
		      		data-target="#exampleModal" data-whatever="@mdo" data-loading-text="<i class='fa fa-circle-o-notch fa-spin'></i>Updating Note">Update</a>
		        <!-- <button type="submit" class="btn btn-default">Submit</button> -->
		      </div>
		      <div class="col-sm-offset-2 col-sm-2">
		      	<a href="viewNoteList.page" class="btn btn-primary" role="button">Back</a>
		        <!-- <button type="submit" class="btn btn-default">Back</button> -->
		      </div>
		    </div>
    		<input type="hidden" id="id" value="${note.id}">
		</form>
    </div>
    
   <!--  <div id="loading" style="display:none" class="loaderPosition">
    	<img alt="Processing" src="static/img/loading.gif">
	</div> -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">Confirm</h4>
            </div>
            <div class="modal-body">
            		<p>Are you sure, you want to proceed?</p>
                
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <!-- <button type="button" id="Edit" class="btn btn-warning">Edit</button> -->
                <button type="button" id="Submit" class="btn btn-primary" data-dismiss="modal" onclick="updateNote()">Submit</button>
            </div>
        </div>
    </div>
	</div>
    
<%@include file="../common/footer.jsp"%>