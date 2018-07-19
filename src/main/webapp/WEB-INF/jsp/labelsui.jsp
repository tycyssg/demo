<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<jsp:include page="header.jsp" />
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>

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



<div class="container" style="width:98%">
<div class="row">
    <div class="col-md-3">
        <div class="well" style="width:300px;">
            <div>
               <%--  <ul class="nav ">
                 <c:forEach var='item' items='${labelsDisplay}'>
                    <li>
                        <label label-default="" class="tree-toggle nav-header">${item.key}</label>
                        <ul class="nav  tree">
                        <c:forEach var='arrayItem' items='${item.value}' >
                            <li><a href="#">${arrayItem}</a></li>
                            </c:forEach>
							</ul>
                            </li>
                            <li class="divider"><hr style="border-color:#000"></li>
                            </c:forEach>
                        </ul> --%>
                      ${labelsDisplay}
                        
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