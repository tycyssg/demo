<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<body>

<script>
					
					
						var pwLen = false,pwLet = false,pwClet = false,pwNum = false;pwSpace = false;pwMatch = false;
						
 						function checkPassStrenght() {
							var pswd = document.getElementById("paw").value
							var pswdsec = document.getElementById("pawCheck").value
							
							//validate the length
							if ( pswd.length < 8 ) {
								$('#length').removeClass('valid').addClass('invalid');
								pwLen = false;
							} else {
								$('#length').removeClass('invalid').addClass('valid');
								pwLen = true;
							}
							
							//validate letter
							if ( pswd.match(/[A-z]/) ) {
								$('#letter').removeClass('invalid').addClass('valid');
								pwLet = true;
							} else {
								$('#letter').removeClass('valid').addClass('invalid');
								pwLet = false;
							}

							//validate capital letter
							if ( pswd.match(/[A-Z]/) ) {
								$('#capital').removeClass('invalid').addClass('valid');
								pwClet = true;
							} else {
								$('#capital').removeClass('valid').addClass('invalid');
								pwClet = false;
							}

							//validate number
							if ( pswd.match(/\d/) ) {
								$('#number').removeClass('invalid').addClass('valid');
								pwNum = true;
							} else {
								$('#number').removeClass('valid').addClass('invalid');
								pwNum = false;
							}
							
							//validate space
							if ( pswd.match(/[^a-zA-Z0-9\-\/]/) ) {
								$('#space').removeClass('invalid').addClass('valid');
								pwSpace = true;
							} else {
								$('#space').removeClass('valid').addClass('invalid');
								pwSpace = false;
							}
							
							//validate match
							if ( pswdsec === pswd ) {
								$('#passmatch').removeClass('invalid').addClass('valid');
								pwMatch = true;
							} else {
								$('#passmatch').removeClass('valid').addClass('invalid');
								pwMatch = false;
							}

					if(pwLen == true && pwLet == true && pwClet == true && pwNum == true && pwSpace == true && pwMatch == true){
								console.log("reach if part")
								 document.getElementById("submitRegForm").disabled = false
							}else{
								document.getElementById("submitRegForm").disabled = true
							}
							
						}
						
						function showValidation() {
							$('#pswd_info').show();
						}
						function hideValidation() {
							$('#pswd_info').hide();
						};
						
/* 						function matchPass(id){
							var pswd = document.getElementById(id).value
							
							//validate match
							if ( pswd === principalPassFieldId ) {
								$('#passmatch').removeClass('invalid').addClass('valid');
								pwMatch = true;
							} else {
								$('#passmatch').removeClass('valid').addClass('invalid');
								pwMatch = false;
							}

					if(pwLen == true && pwLet == true && pwClet == true && pwNum == true && pwSpace == true && pwMatch == true){
								console.log("reach if part")
								 document.getElementById("submitRegForm").disabled = false
							}else{
								document.getElementById("submitRegForm").disabled = true
							}
						} */
		
					</script>
						<div class="row">
		<div class="col-md-4 col-md-offset-4 text-center">
				<form action="" class="loginForm">
					<div class="input-group">
						<input type="text" id="name" class="form-control" placeholder="Full Name">
						<input type="password" id="paw" class="form-control" placeholder="Password" onkeyup="checkPassStrenght()" onfocus="showValidation()" onblur="hideValidation()" >
						<input type="password" id="pawCheck" class="form-control" placeholder="Repeat Password" onkeyup="checkPassStrenght()" onfocus="showValidation()" onblur="hideValidation()" >
						<input type="submit" id="submitRegForm" class="form-control" value="Submit" disabled>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-4">
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
		</div>
	</div>
</body>
</html>