<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<jsp:include page="header.jsp" />

<body>

	<!-- script to change the login form to reg one -->
	<script>
		window.onload = function() {
			var s = new URL(location.href).searchParams.get('register');
			if (s == "newacc") {
				$('#loginbox').hide();
				$('#signupbox').show();
			}
			var h = new URL(location.href).searchParams.get('hash');
			
			document.getElementById('hashInput').value = h;

			
		}
	</script>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						<a href="#">Forgot password?</a>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<c:if test="${emptyUserOrMail eq true}">
						<div class="alert alert-warning" role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
							<strong>Warning!</strong> You have the fill all inputs during the registration process.
						</div>
					</c:if>
					
				<c:if test="${specialChars eq true}">
						<div class="alert alert-danger" role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
							<strong>Error!</strong> Only letters and numbers are allowed!
						</div>
					</c:if>
					<c:if test="${emailExist eq true}">
						<div class="alert alert-danger" role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
							<strong>Error!</strong> Your email already exist in our records!
						</div>
					</c:if>
							<c:if test="${emailValid eq true}">
						<div class="alert alert-danger" role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
							<strong>Error!</strong> Your email is invalid!
						</div>
					</c:if>
							<c:if test="${userExist eq true}">
						<div class="alert alert-danger" role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
							<strong>Error!</strong> User name already exist!
						</div>
					</c:if>
					<c:if test="${linkExpired eq true}">
						<div class="alert alert-danger" role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
							<strong>Your invitation has expired!</strong> Ask your friend to invite you again or
							register yourself.
						</div>
					</c:if>

				<c:if test="${param.error != null}">
						<div class="alert alert-danger" role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>Invalid
							Username or Password
						</div>
					</c:if>
					
					<c:if test="${param.logout != null}">
						<div class="alert alert-success" role="alert">
							<i class="fa fa-sign-out" aria-hidden="true"></i> You
							successfully loged out!
						</div>
					</c:if>
					
					<c:if test="${accCreated eq true}">
						<div class="alert alert-warning" role="alert">
							<i class="fa fa-id-card-o" aria-hidden="true"></i> You
							account was successfully created!
						</div>
					</c:if>


					<form:form id="loginform" class="form-horizontal" role="form"
						action="${pageContext.request.contextPath}/signin" method="POST">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="username" value=""
								placeholder="username" required autofocus>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password" required autofocus>
						</div>



						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1"> Remember me
								</label>
							</div>
						</div>


						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<button type="submit" id="btn-login" class="btn btn-success">Login
								</button>
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									Don't have an account! <a href="#"
										onClick="$('#loginbox').hide(); $('#signupbox').show()">
										Sign Up Here </a>
								</div>
								<a href="/"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;HOME</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

	</div>
	
	<div id="signupbox" style="display: none; margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign Up</div>
				<div
					style="float: right; font-size: 85%; position: relative; top: -10px">
					<a id="signinlink" href="#"
						onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign
						In</a>
				</div>
			</div>
			<div class="panel-body">
				<form:form id="signupform" class="form-horizontal" role="form" action="registeracc" method="POST">

					<div id="signupalert" style="display: none"
						class="alert alert-danger">
						<p>Error:</p>
						<span></span>
					</div>
					<input type="hidden" name="hashString" id="hashInput"  />
					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Username</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="username"
								placeholder="Username" required autofocus>
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Email</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="email"
								placeholder="Email Address" required autofocus>
						</div>
					</div>

					
					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" id="paw" class="form-control" name="password" placeholder="Password" onkeyup="checkPassStrenght()" onfocus="showValidation()" onblur="hideValidation()" required autofocus >
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Repeat Password</label>
						<div class="col-md-9">
								<input type="password" id="pawCheck" class="form-control" name="passwordr" placeholder="Repeat Password" onkeyup="checkPassStrenght()" onfocus="showValidation()" onblur="hideValidation()" required autofocus>
						</div>
					</div>
					<div class="aro-pswd_info">
				<div id="pswd_info">
					<h4>Password must be requirements</h4>
					<ul>
						<li id="letter" class="invalid">At least <strong>one letter</strong></li>
						<li id="capital" class="invalid">At least <strong>one capital letter</strong></li>
						<li id="number" class="invalid">At least <strong>one number</strong></li>
						<li id="length" class="invalid">Be at least <strong>8 characters</strong></li>
						<li id="space" class="invalid">be<strong> use [~,!,@,#,$,%,^,&,*,-,=,.,;,']</strong></li>
						<li id="passmatch" class="invalid">Match<strong> the password</strong></li>
					</ul>
				</div>
				</div>
				
					
					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<input type="submit" id="submitRegForm" class="form-control" value="Submit" disabled>
						</div>
					</div>
				<script src="${pageContext.request.contextPath}/static/js/passStrenght.js"></script>
				
					<div style="border-top: 1px solid #999; padding-top: 20px"
						class="form-group">

						<div class="col-md-offset-3 col-md-9">

							<div class="alert alert-warning" role="alert">
								<h5>
									<i class="fa fa-refresh fa-spin fa-fw"></i>Our Website Name
								</h5>
							</div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>




					
				
</body>
</html>