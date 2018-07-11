<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<jsp:include page="header.jsp" />
<body>
		<jsp:include page="menu.jsp" />

<div class="intro-header"> 
<div class="container"  align="center">

<div class="tab-content custom-tab-content" align="center">
<div class="subscribe-panel">
<h1>Welcome to User Control Panel ${userLogat}</h1>
<p>Invite a friend</p>
                
                <form:form action="invitesomeone" method="post">
                    	
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i></span>
									<input type="hidden" name="username" value="${userLogat}" />
									<input type="text" class="form-control input-lg" name="email" id="email"  placeholder="Enter your Email"/>
								</div>
							</div>
							<div class="col-md-4"></div>
                    <br/><br/><br/>
                    <button class="btn btn-warning btn-lg">Invite</button>
              </form:form>

</div>
</div>
</div>
</div>


</body>
</html>