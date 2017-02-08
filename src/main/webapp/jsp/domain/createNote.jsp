<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../common/header.jsp"%>
<script src="static/js/domain/createNoteJs.js"></script>
<%@include file="../common/nav.jsp"%>
	<div id="success" style="display:none" class="alert alert-success col-sm-offset-2 col-sm-5" >
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	  	<strong>Success!</strong> New note created, you will be redirected shortly.
	</div>
	<div id="fail" style="display:none" class="alert alert-danger col-sm-offset-2 col-sm-5">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	  <strong>Error!</strong> Could not create new note.
	</div>
	
	<div class="container">
  
		<form class="form-horizontal"  id="myform">
		  	<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-6">
		      	<h2>New Note</h2>
		  		<hr/>
		      </div>
		    </div>
  	
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="title">Title:</label>
		      <div class="col-sm-4">
		        <input type="text" class="form-control" id="title" placeholder="Enter title" value="" >
		        <div id="titleValidate" style="display:none"><span  ><font color="red">* Please fill this field</font></span></div>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="conent">Content:</label>
		      <div class="col-sm-6">          
		        <textarea class="form-control" rows="6" id="content" placeholder="Enter content"></textarea>
		      </div>
		    </div>
		    
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-4">
		      	<a href="#" class="btn btn-primary" role="button" id="save"
		      		data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" data-loading-text="<i class='fa fa-circle-o-notch fa-spin'></i>Saving Note">Save</a>
		      	&nbsp;&nbsp; <a href="viewNoteList.page" class="btn btn-primary" role="button">Back</a>	
		        <!-- <button type="submit" class="btn btn-default">Submit</button> -->
		      </div>
		      <!-- <div class="col-sm-offset-2 col-sm-2">
		      	
		        <button type="submit" class="btn btn-default">Back</button>
		      </div> -->
		    </div>
    		
		</form>
    </div>
   
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
                <button type="button" id="Submit" class="btn btn-primary" data-dismiss="modal" onclick="addNote()">Yes</button>
            </div>
        </div>
    </div>
	</div>

<%@include file="../common/footer.jsp"%>