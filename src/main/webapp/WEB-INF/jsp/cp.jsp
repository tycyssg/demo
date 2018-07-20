<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<jsp:include page="header.jsp" />
<body>
<script type="text/javascript" src="static/js/editUserDetails.js"></script>

	<div id="maincontainer">
		<div id="mainContent">
			<jsp:include page="menu.jsp" />

			<div class="container content-center"
				style="width: 100%; height: 100%;">
				<div class="row">
					<script src="${pageContext.request.contextPath}/static/js/cpanelmenu.js"></script>
					<div class="col-md-9 col-md-push-3  well admin-content" id="home"
						style="width: 70%;">
						<p>Hello! This is a forked snippet. It is for users, which use
							one-page layouts.It is for users, which use one-page lIt is for
							users, which use one-page lIt is for users, which use one-page l
						</p>
					</div>
					<div class="col-md-9 col-md-push-3  admin-content" id="settings" style="width: 70%;">
					
						<div class="container">
					
					 <div class="panel with-nav-tabs panel-primary">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1primary" data-toggle="tab">Dashboard</a></li>
                            <li><a href="#tab2primary" data-toggle="tab">Edit PersonalDetails</a></li>
                            <li><a href="#tab3primary" data-toggle="tab">Change your password</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown">More <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#tab4primary" data-toggle="tab">Primary 4</a></li>
                                    <li><a href="#tab5primary" data-toggle="tab">Primary 5</a></li>
                                </ul>
                            </li>
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">Primary 1</div>
                        <div class="tab-pane fade" id="tab2primary"><!-- Tab2start-->
                        
                        <div class="container text-center" style="width:80%;"> 
										<h3>Complete your personal details.</h3>
										<hr>
										<div id="formSuccessDiv"></div>
										
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
							</div>
										</div>
                        
                        </div><!-- Tab2end -->
                        <div class="tab-pane fade" id="tab3primary">Primary 3</div>
                        <div class="tab-pane fade" id="tab4primary">Primary 4</div>
                        <div class="tab-pane fade" id="tab5primary">Primary 5</div>
                    </div>
                </div>
            </div>

						</div>


					</div>
					<!-- End settings -->
					<div class="col-md-9 col-md-push-3  well admin-content" id="editp"
						style="width: 70%;">
						<p>Hello! This is a forked snippet. edit panel</p>
						<p>
							Here's the original one from BhaumikPatel: <a
								href="http://bootsnipp.com/snippets/featured/vertical-admin-menu"
								target="_BLANK">Vertical Admin Menu</a> <br> Thank you
							Baumik!
						</p>
					</div>

					<div class="col-md-9 col-md-push-3  well admin-content" id="invite"
						style="width: 70%;">
						<p>Hello! This is a forked snippet. invite firend</p>
						<p>
							Here's the original one from BhaumikPatel: <a
								href="http://bootsnipp.com/snippets/featured/vertical-admin-menu"
								target="_BLANK">Vertical Admin Menu</a> <br> Thank you
							Baumik!
						</p>
					</div>
					<div class="col-md-3 col-md-pull-9 pull-right"
						style="width: 15%; margin-right: 7%;">
						<ul class="nav nav-pills nav-stacked admin-menu">
							<li class="active"><a href="#" data-target-id="home"><i
									class="fa fa-home fa-fw"></i>Home</a></li>
							<li><a href="#" data-target-id="settings"><i
									class="fa fa-cogs fa-fw"></i>Settings</a></li>
							<li><a href="#" data-target-id="editp"><i
									class="fa fa-list-alt fa-fw"></i>Edit Profile</a></li>
							<li><a href="#" data-target-id="invite"><i
									class="fa fa-file-o fa-fw"></i>Invite to your team</a></li>
							<!--<li><a href="#" data-target-id="charts"><i class="fa fa-bar-chart-o fa-fw"></i>Charts</a></li>
                <li><a href="#" data-target-id="table"><i class="fa fa-table fa-fw"></i>Table</a></li>
                <li><a href="#" data-target-id="forms"><i class="fa fa-tasks fa-fw"></i>Forms</a></li>
                <li><a href="#" data-target-id="calender"><i class="fa fa-calendar fa-fw"></i>Calender</a></li>
                <li><a href="#" data-target-id="library"><i class="fa fa-book fa-fw"></i>Library</a></li>
                <li><a href="#" data-target-id="applications"><i class="fa fa-pencil fa-fw"></i>Applications</a></li> -->

						</ul>
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