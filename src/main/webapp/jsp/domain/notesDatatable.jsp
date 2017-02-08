<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../common/header.jsp"%>
<%@include file="../common/nav.jsp"%>


    <!--Datatable required js  -->
    <%-- <script src="${pageContext.request.contextPath}/static/jquery/jquery-1.12.4.min.js"></script> --%>
    <script src="static/dataTables/js/jquery-ui-1.8.23.custom.min.js"></script>
    <script src="static/dataTables/js/jquery.dataTables.js"></script>
    <script src="static/dataTables/js/jquery.validate.js"></script>
    <script src="static/dataTables/js/jquery.metadata.js"></script>
    <script src="static/dataTables/js/additional-methods.js"></script>
    <script src="static/dataTables/js/custom.js"></script>
    
    <script src="static/js/domain/notesDatatable.js"></script>

    <!--Datatable required css  -->
    <link href="static/dataTables/css/jquery-ui-1.8.15.custom.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/common/vendor-compatible/jquery-ui-fix.css" rel="stylesheet" type="text/css"/>
    <link href="static/dataTables/css/demo_page.css" rel="stylesheet" type="text/css"/>
    <link href="static/dataTables/css/demo_table.css" rel="stylesheet" type="text/css"/>
    <link href="static/dataTables/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
    <link href="static/dataTables/css/dropdown.css" rel="stylesheet" type="text/css"/>
    
    <!-- <link href="static/css/custom.css" rel="stylesheet" type="text/css"/> -->
	<div id="success" style="display:none" class="alert alert-success col-sm-offset-2 col-sm-4" >
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	  	<strong>Success!</strong> Note deleted.
	</div>
	<div id="fail" style="display:none" class="alert alert-danger col-sm-offset-2 col-sm-4">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	  <strong>Error!</strong> Could not delete note.
	</div>
    <div style="float: left" id="t1">
        <table id="table1">
            <thead>
            <tr>
                <th align="center" width="200px">Title</th>
                <th align="center" width="600px">Content</th>
                <!-- <th align="center" width="200px">Hospital </th>
                <th align="center" width="200px">Department</th>
                <th align="center" width="200px">Registration Date</th> -->
                <th align="center" width="200px">Action</th>
            </tr>
            </thead>
            <tbody align="center">
            </tbody>
        </table>
    </div>

                        
	<div id="loading" style="display:none" class="loaderPosition">
  		<img alt="Processing" src="static/img/loading.gif">
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
