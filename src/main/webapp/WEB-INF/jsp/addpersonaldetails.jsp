                    <div class="container text-center" style="width:80%;"> 
										<h3>Complete your personal details.</h3>
										<hr>
										<div id="formSuccessDiv"></div>
					<script type="text/javascript" src="static/js/editUserDetails.js"></script>					
					<form:form class="form-horizontal" role="form"  id="addUserDetails" onsubmit="addUserDetails(); return false;" >
					<input type="hidden" name="user" value="${userLogat}" />
					<!-- Field Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="name">Name</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-address-card-o" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="name" class="form-control" id="name"
										placeholder="Current name : ${name}" required autofocus>
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
							<label for="name">Surname</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-address-card-o" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="surname" class="form-control"
										id="catid" placeholder="Current surname : ${surname}" required autofocus>
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
							<label for="name">Phone</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-phone-square" aria-hidden="true"></i>
										</div>
									</div>
									<input type="number" name="phone" class="form-control"
										id="catid" placeholder="Current phone : ${phone}" required autofocus min="0" step="1">
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
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4" style="margin-left: -90px;">
							<button type="submit" class="btn btn-success">
								<i class="fa fa-plus-square" aria-hidden="true"></i> Add details
							</button>
						</div>
					</div>
				</form:form>	
				<br />	
					<div class="alert alert-info" role="alert">
  				<strong>Info!</strong> Fill the form again if you want to change your details.
				</div><!-- END details form -->
				<jsp:include page="addpersonaladdress.jsp" />
				</div>
				