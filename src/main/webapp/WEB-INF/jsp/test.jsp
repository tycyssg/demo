<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<jsp:include page="header.jsp" />

<body>
	<div id="maincontainer">
		<div id="mainContent">


<%-- <script type="text/javascript" src="../static/js/maptree.js"></script>
			<div class="container" style="width:98%">
				<form:form class="form-horizontal" role="form"
					onsubmit="createModuleReceiver(); return false;"
					id="createModuleForm">
					<br />
					<!-- Filed End -->
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<h2>Param Settings</h2>
							<hr>
						</div>
					</div>
					<!-- End Module settings -->
					<!-- Filed Start -->
					<div class="row">
						<div class="col-sm-1 field-label-responsive text-right">
							<button class="btn btn-primary btn-md" onclick="addFile()" >
								<i class="fa fa-plus" aria-hidden="true"></i>
							</button>
						</div>
						<div class="col-sm-2">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 5%">
										<div style="width: 25px;">
											<i class="fa fa-tags" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="label" class="form-control" id="name"
										placeholder="Starting Node" required autofocus>
								</div>
							</div>
						</div>
							<div class="col-sm-2 field-label-responsive text-right">
							<div class="text-right" id="divtoapp" style="margin-left:20px;"></div>
						</div>
					</div>
					<!-- Filed End -->
					
<!-- 					<br />
					<br />
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4" style="margin-left: -15px;">
							<button type="submit" class="btn btn-success">
								<i class="fa fa-plus-square" aria-hidden="true"></i> Create
								Module
							</button>
						</div>
					</div> -->
				</form:form>
			</div> --%>
			

	<script type="text/javascript" src="../static/js/newNode.js"></script>		
	<div class="container" style="width:98%;padding:0;">
	<div id="formSuccessDiv"></div>
	<div class="row">
		<div class="col-sm-2" style="border:1px solid black;">
			<div class="row">
			<div class="col-sm-8" style="padding-top:5px;" >
			<input type="hidden" value="" id="fatherId" />
			<input type="text" name="nodeName" id="nodeId0" />
			</div>
			<div class="col-sm-2">
			<button class="btn btn-primary btn-md" onclick="createNewNode(fatherId)" >
				<i class="fa fa-plus" aria-hidden="true"></i>
			</button>
			</div>
			<div class="col-sm-2">
					<button class="btn btn-success btn-md" onclick="saveNode(nodeId0,fatherId)" >
					<i class="fa fa-check" aria-hidden="true"></i>
			</button>
			</div>
			</div>
	</div>

	<div class="col-sm-2" style="border:1px solid black;" id="nodeappend"></div>
	</div>
</div>
			
			
			
				</div><!-- ENd main -->
</div><!-- end COntainer -->
</body>
</html>