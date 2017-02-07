<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Doctor Request</title>
    <%@include file="../common/common_header.jsp" %>


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
                        <h1>${message}</h1>
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
                        <div align="center" id="t1">
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

                        <!-- <br/>
                        <div align="center">
                            <button type="button" id='backBtn' class="btn btn-primary" onclick="download()">Download Report</button>
                        </div> -->
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>