<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<jsp:include page="header.jsp" />
<head>
</head>

<body>
	<div id="maincontainer">
		<div id="mainContent">
			<jsp:include page="menu.jsp" />

<div class="container">
				<form:form class="form-horizontal" role="form" action="/modulesUireceive" method="POST"
					id="createModuleForm">
					<input type="hidden" name="creator" value="${userLogat}" />
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<h2>Module Labels UI!</h2>
							<hr>
							<div id="formSuccessDiv"></div>

						</div>
					</div>
					<!-- Field Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Label Friendly Name</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-tags" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="friendlyName" class="form-control" id="name"
										placeholder="Pagination" required autofocus>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-control-feedback">
								<span class="text-danger align-middle"> <!-- Put name validation error messages here -->
								</span>
							</div>
						</div>
					</div>
					<!-- Field End -->
					<!-- Field Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Parent Name</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-tag" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="parentName" class="form-control"
										id="catid" placeholder="Pagination Model 1" required autofocus>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-control-feedback">
								<span class="text-danger align-middle"> <!-- Put name validation error messages here -->
								</span>
							</div>
						</div>
					</div>
					<!-- Field End -->
					<br />
					<br />
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4" style="margin-left: -15px;">
							<button type="submit" class="btn btn-success">
								<i class="fa fa-plus-square" aria-hidden="true"></i> Create
							</button>
						</div>
					</div>
				</form:form>
			</div>
	

		</div>
		<!-- ENd main -->
	</div>
	<!-- end COntainer -->
	<jsp:include page="footer.jsp" />
</body>
</html>