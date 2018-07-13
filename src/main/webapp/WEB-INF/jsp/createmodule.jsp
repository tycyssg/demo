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


			<script type="text/javascript"
				src="../static/js/createTestParamForm.js"></script>
			<div class="container">
				<form:form class="form-horizontal" role="form"
					onsubmit="createModuleReceiver(); return false;"
					id="createModuleForm">
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<h2>Module general settings!</h2>
							<hr>
							<div id="formSuccessDiv"></div>

						</div>
					</div>
					<!-- Filed Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Label</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-tags" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="label" class="form-control" id="name"
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
					<!-- Filed End -->
					<!-- Filed Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Category Name</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-tag" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="catname" class="form-control"
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
					<!-- Filed End -->
					<!-- Filed Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Category Description</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-info" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="catdes" class="form-control"
										id="catdesid" placeholder="Pagination with arrows" required
										autofocus>
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
					<!-- Filed End -->
					<!-- Filed Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Tutorial Link</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-youtube-play" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="catlink" class="form-control"
										id="catlinkid" placeholder="http://youtube.com" required
										autofocus>
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
					<!-- Filed End -->

					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<h2>Module Files Setting</h2>
							<hr>
						</div>
					</div>
					<!-- End Module settings -->
					<!-- Select Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Select the module file extension.</label>
						</div>
						<div class="col-sm-4">
							<div class="input-group" style="margin-left: -17px;">
								<span class="input-group-addon"><div style="width: 25px;">
										<i class="fa fa-file-code-o" aria-hidden="true"></i>
									</div></span> <select class="form-control" id="propertytype"
									name="fileextension">
									<option value="" disabled selected>Select Language
										Extension</option>
									<option value=".py">Python</option>
									<option value=".java">Java</option>
									<option value=".swift">Swift</option>
								</select>
							</div>
						</div>
					</div>
					<!-- Select End-->
					<br />
					<!-- Select Start -->
					<div class="row">
						<div class="col-sm-4"></div>

						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-cog fa-spin fa-fw"></i>
										</div>
									</div>
									<input type="text" class="form-control" id="desinputid"
										placeholder="Insert your code below" readonly>
								</div>
								<textarea class="form-control" id="catcodeid" rows="5"
									name="catcode"></textarea>
							</div>
						</div>
					</div>
					<!-- Select End-->
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
					<!-- Param Setting -->
					<div class="row">
						<div class="col-sm-4 text-right">
							<button class="btn btn-primary btn-md" onclick="addFile()"
								style="margin-top: 10px;">
								<i class="fa fa-plus" aria-hidden="true"></i> Add Param Form
							</button>
						</div>

						<!-- Param Form Start -->
						<div class="col-sm-4 text-right" id="divtoapp"></div>


						<!-- Param form end -->
					</div>
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
				</div><!-- ENd main -->
</div><!-- end COntainer -->
<jsp:include page="footer.jsp" />
</body>
</html>