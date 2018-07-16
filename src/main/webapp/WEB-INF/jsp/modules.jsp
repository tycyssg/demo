<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<jsp:include page="header.jsp" />
<head>



</head>

<body>
	<div id="maincontainer">
		<div id="mainContent">
			<jsp:include page="menu.jsp" />

	<script type="text/javascript">
/* 	window.onload = function() { 
	    $('label.tree-toggler').click(function () {
	        $(this).parent().children('ul.tree').toggle(300);
	    });
	}; */
	window.onload = function() { 
	$('.tree-toggle').click(function () {
		$(this).parent().children('ul.tree').toggle(200);
	});
}
	</script>
	

	<div class="container">
    <div class="row">
         <h1>Bootstrap Tree Menu Example</h1>

    </div>
</div>
<div class="row">
    <div class="col-md-3">
        <div class="well">
            <div>
                <ul class="nav ">
                    <li>
                        <label label-default="" class="tree-toggle nav-header">Bootstrap</label>
                        <ul class="nav  tree">
                            <li><a href="#">JavaScript</a>

                            </li>
                            <li><a href="#">CSS</a>

                            </li>
                            <li>
                                <label label-default="" class="tree-toggle nav-header">Buttons</label>
                                <ul class="nav  tree">
                                    <li><a href="#">Colors</a>

                                    </li>
                                    <li><a href="#">Sizes</a>

                                    </li>
                                    <li>
                                        <label label-default="" class="tree-toggle nav-header">Forms</label>
                                        <ul class="nav  tree">
                                            <li><a href="#">Horizontal</a>

                                            </li>
                                            <li><a href="#">Vertical</a>

                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="divider"><hr style="border-color:#000"></li>
                    <li>
                        <label label-default="" class="tree-toggle nav-header">Responsive</label>
                        <ul class="nav  tree">
                            <li><a href="#">Overview</a>

                            </li>
                            <li><a href="#">CSS</a>

                            </li>
                            <li>
                                <label label-default="" class="tree-toggle nav-header">Media Queries</label>
                                <ul class="nav  tree">
                                    <li><a href="#">Text</a>

                                    </li>
                                    <li><a href="#">Images</a>

                                    </li>
                                    <li>
                                        <label label-default="" class="tree-toggle nav-header">Mobile Devices</label>
                                        <ul class="nav  tree">
                                            <li><a href="#">iPhone</a>

                                            </li>
                                            <li><a href="#">Samsung</a>

                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <label label-default="" class="tree-toggle nav-header">Coding</label>
                                <ul class="nav  tree">
                                    <li><a href="#">JavaScript</a>

                                    </li>
                                    <li><a href="#">jQuery</a>

                                    </li>
                                    <li>
                                        <label label-default="" class="tree-toggle nav-header">HTML DOM</label>
                                        <ul class="nav  tree">
                                            <li><a href="#">DOM Elements</a>

                                            </li>
                                            <li><a href="#">Recursive</a>

                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
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