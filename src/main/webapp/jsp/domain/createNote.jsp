<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Doctor Request</title>
    <%@include file="../common/common_header.jsp" %>
	<script src="static/js/domain/createNoteJs.js"></script>
	
	<link href="static/css/custom.css" rel="stylesheet" type="text/css"/>
	
</head>
<body >
    <%@include file="../common/navigation.jsp" %>
    <div class="container-fluid">
        <div class="row">
            <%@include file="sidebar.jsp" %>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="row">
                    <div class="col-md-12">
                        <h1>Create Note</h1>
                        <hr/>

                       <!--  <div class="form-group select-width">
                            <label for="status">Filter Records</label>
                            <select class="form-control" id="status" onchange="ajaxDatatable()">
                                <option value="all">All</option>
                                <option value="pending">Pending</option>
                                <option value="approved">Approved</option>
                                <option value="rejected">Rejected</option>
                            </select>
                        </div>

                        <br/> -->
                        <div align="left" id="t1">
							<div class="form-group">
							  	<label for="title">Title:</label>
							  	<input type="text" class="form-control" id="title">
							  	<br>
							  	<label for="content">Content:</label>
								<textarea class="form-control" rows="5" id="content"></textarea>
							</div>
                        </div>

                        <br/>
                        <div align="center">
                            <button type="button" id='submitBtn' class="btn btn-primary" onclick="addNote()">Submit</button>
                        </div>
                        <div id="loading" style="display:none" class="loaderPosition">
                        <img alt="Processing" src="static/img/loading.gif">
                    	</div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>