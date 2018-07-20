<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="header.jsp" />
  <head>
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="static/js/scriptDragAndDrop.js"></script>
    
  </head>

<body>
	<div id="maincontainer">
		<div id="mainContent">
			<jsp:include page="menu.jsp" />
			
			 <div class="container text-center" style="width:80%;"> 
										<h3>Arrange your test steps.</h3>
										<hr>
										<div id="formSuccessDiv"></div>
			</div>
			
    <div class="container" >
  	 <section class="panel no-radius even-margin"> 
		 <section class="panel-body"> 
			<section id="connected">
						
					<ul class="connected list" id="mylist">
					<c:forEach var='step' items='${testSteps}' >
						<li class="box-item" id="tst${step.id}" >${step.id}</li>
				</c:forEach>
					</ul>
			</section>
</section>
</section>

	<hr>
	<button type="button" class="btn btn-primary" onclick="myTst();" >Primary</button>
</div>


		</div>
		<!-- ENd main -->
	</div>
	<!-- end COntainer -->
	<jsp:include page="footer.jsp" />
</body>
</html>