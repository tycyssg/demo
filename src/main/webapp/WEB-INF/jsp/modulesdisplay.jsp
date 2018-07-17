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
			<jsp:include page="menu.jsp" />

			<script type="text/javascript">
	window.onload = function() { 
	$('.tree-toggle').click(function () {
		$(this).parent().children('ul.tree').toggle(200);
	});
}
	</script>



			<div class="container text-center">
				<h1>Bootstrap Tree Menu Example</h1>
				<hr>

			</div>


			<div class="container" style="width: 98%">
				<div class="row">
					<div class="col-md-9 col-md-push-3  well admin-content" id="home"
						style="width: 70%;">

			<div class="container">
			<script type="text/javascript" src="/static/js/moduleDisplayFormSender.js"></script>
				<form:form class="form-horizontal" role="form" onsubmit="moduleDisplaySender(); return false;" id="moduleDisplayForm" >
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<h2>Module display form!</h2>
							<hr>
							<div id="formSuccessDiv"></div>

						</div>
					</div>
					<c:forEach var='paramName' items='${paramsMap}'>
								<c:forEach var='paramType' items='${paramName.value}'>
								<c:if test="${paramType == 'text'}">
					<!-- Field Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name"> ${paramName.key}</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-file-text" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="${paramName.key}" class="form-control" id="${paramName.key}id"
										placeholder="${paramName.key}" required autofocus>
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
					</c:if>
					
					<c:if test="${paramType == 'number'}">
					<!-- Field Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name"> ${paramName.key}</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-sort-numeric-asc" aria-hidden="true"></i>
										</div>
									</div>
									<input type="number" name="${paramName.key}" class="form-control" id="${paramName.key}id"
										placeholder="${paramName.key}" required autofocus step="1">
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
					</c:if>
					
					<c:if test="${paramType == 'boolean'}">
					<!-- Field Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">${paramName.key}</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								  <div class="btn-group" data-toggle="buttons">
													<label class="btn btn-primary active">
											<input type="checkbox" autocomplete="off" checked name="${paramName.key}" >
											<input type="hidden" name="${paramName.key}"  value="false" />
											<span class="glyphicon glyphicon-ok"></span>
										</label>
									</div>
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
					</c:if>
					
					</c:forEach>
					</c:forEach>
					
					<br />
					<br />
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4" style="margin-left: -15px;">
							<button type="submit" class="btn btn-success">
								<i class="fa fa-plus-square" aria-hidden="true"></i> Create
								Module
							</button>
						</div>
					</div>
				</form:form>
			</div>


					</div>

					<div class="col-md-3 col-md-pull-9 pull-right"
						style="width: 15%; margin-right: 7%;">
						<div class="col-md-3">
							<div class="well" style="width: 300px;">
								<div>
									<ul class="nav ">
										<li><label label-default=""
											class="tree-toggle nav-header">Bootstrap</label>
											<ul class="nav  tree">
												<li><a href="#">JavaScript</a></li>
												<li><a href="#">CSS</a></li>
												<li><label label-default=""
													class="tree-toggle nav-header">Buttons</label>
													<ul class="nav  tree">
														<li><a href="#">Colors</a></li>
														<li><a href="#">Sizes</a></li>
														<li><label label-default=""
															class="tree-toggle nav-header">Forms</label>
															<ul class="nav  tree">
																<li><a href="#">Horizontal</a></li>
																<li><a href="#">Vertical</a></li>
															</ul></li>
													</ul></li>
											</ul></li>
										<li class="divider"><hr style="border-color: #000"></li>
										<li><label label-default=""
											class="tree-toggle nav-header">Responsive</label>
											<ul class="nav  tree">
												<li><a href="#">Overview</a></li>
												<li><a href="#">CSS</a></li>
												<li><label label-default=""
													class="tree-toggle nav-header">Media Queries</label>
													<ul class="nav  tree">
														<li><a href="#">Text</a></li>
														<li><a href="#">Images</a></li>
														<li><label label-default=""
															class="tree-toggle nav-header">Mobile Devices</label>
															<ul class="nav  tree">
																<li><a href="#">iPhone</a></li>
																<li><a href="#">Samsung</a></li>
															</ul></li>
													</ul></li>
												<li><label label-default=""
													class="tree-toggle nav-header">Coding</label>
													<ul class="nav  tree">
														<li><a href="#">JavaScript</a></li>
														<li><a href="#">jQuery</a></li>
														<li><label label-default=""
															class="tree-toggle nav-header">HTML DOM</label>
															<ul class="nav  tree">
																<li><a href="#">DOM Elements</a></li>
																<li><a href="#">Recursive</a></li>
															</ul></li>
													</ul></li>
											</ul></li>
									</ul>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
		<!-- ENd main -->
	</div>
	<!-- end COntainer -->
	<jsp:include page="footer.jsp" />
</body>
</html>