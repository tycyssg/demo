
										<h3>Add your address</h3>
										<hr>
										<div id="formSuccessDivAdd"></div>
										
					<form:form class="form-horizontal" role="form"  id="addUserAddress" onsubmit="addUserAddress(); return false;" >
					<input type="hidden" name="user" value="${userLogat}" />
					<!-- Field Start -->
					<div class="row">
						<div class="col-sm-4 field-label-responsive text-right">
							<label for="line1">Line1</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-street-view" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="line1" class="form-control" id="line1"
										placeholder="Current Address: ${line1}" required autofocus>
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
							<label for="line2">Line 2</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-street-view" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="line2" class="form-control"
										id="line2" placeholder="Current Address: ${line2}" required autofocus>
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
							<label for="line2">House No/Name</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-home" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="houseno" class="form-control"
										id="houseno" placeholder="Current House: ${house}" required autofocus>
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
							<label for="city">City</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-building" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="city" class="form-control"
										id="city" placeholder="Current City: ${city}" required autofocus>
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
							<label for="city">Postcode</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
											<i class="fa fa-product-hunt" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="postcode" class="form-control"
										id="postcode" placeholder="Current Postcode: ${postcode}" required autofocus>
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
							<label for="country">Country</label>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="input-group mb-2 mr-sm-2 mb-sm-0">
									<div class="input-group-addon" style="width: 10%">
										<div style="width: 25px;">
										<i class="fa fa-flag" aria-hidden="true"></i>
										</div>
									</div>
									<input type="text" name="country" class="form-control"
										id="country" placeholder="Current Country: ${country}" required autofocus>
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
								<i class="fa fa-plus-square" aria-hidden="true"></i> Add address
							</button>
						</div>
					</div>
				</form:form>	
				<br />	
					<div class="alert alert-info" role="alert">
  				<strong>Info!</strong> Fill the form again if you want to change your details.
				</div><!-- END details form -->