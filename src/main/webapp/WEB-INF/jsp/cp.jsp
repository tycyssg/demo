<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<jsp:include page="header.jsp" />
<body>
	<jsp:include page="menu.jsp" />



<div class="container" style="margin-left:0;">
        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked admin-menu">
                <li class="active"><a href="#" data-target-id="home"><i class="fa fa-home fa-fw"></i>Home</a></li>
                <li><a href="#" data-target-id="widgets"><i class="fa fa-list-alt fa-fw"></i>Widgets</a></li>
                <li><a href="#" data-target-id="pages"><i class="fa fa-file-o fa-fw"></i>Pages</a></li>
                <li><a href="#" data-target-id="charts"><i class="fa fa-bar-chart-o fa-fw"></i>Charts</a></li>
                <li><a href="#" data-target-id="table"><i class="fa fa-table fa-fw"></i>Table</a></li>
                <li><a href="#" data-target-id="forms"><i class="fa fa-tasks fa-fw"></i>Forms</a></li>
                <li><a href="#" data-target-id="calender"><i class="fa fa-calendar fa-fw"></i>Calender</a></li>
                <li><a href="#" data-target-id="library"><i class="fa fa-book fa-fw"></i>Library</a></li>
                <li><a href="#" data-target-id="applications"><i class="fa fa-pencil fa-fw"></i>Applications</a></li>
                <li><a href="#" data-target-id="settings"><i class="fa fa-cogs fa-fw"></i>Settings</a></li>
            </ul>
        </div>
        <div class="col-md-9 col-md-push-3 well admin-content" id="home">
            <p>
                Hello! This is a forked snippet.
                It is for users, which use one-page layouts.It is for users, which use one-page lIt is for users, which use one-page lIt is for users, which use one-page l
            </p>
            <p>
                Here's the original one from BhaumikPatel: <a href="http://bootsnipp.com/snippets/featured/vertical-admin-menu" target="_BLANK">Vertical Admin Menu</a>
                <br>
                Thank you Baumik!
            </p>
        </div>
        <div class="col-md-9 well admin-content" id="widgets">
            Widgets
        </div>
        <div class="col-md-9 well admin-content" id="pages">
            Pages
        </div>
        <div class="col-md-9 well admin-content" id="charts">
            Charts
        </div>
        <div class="col-md-9 well admin-content" id="table">
            Table
        </div>
        <div class="col-md-9 well admin-content" id="forms">
            Forms
        </div>
        <div class="col-md-9 well admin-content" id="calender">
            Calender
        </div>
        <div class="col-md-9 well admin-content" id="library">
            Library
        </div>
        <div class="col-md-9 well admin-content" id="applications">
            Applications
        </div>
        <div class="col-md-9 well admin-content" id="settings">
            Settings
        </div>
    </div>
</div>
<script type="text/javascript">
window.onload = function() {
    var navItems = $('.admin-menu li > a');
    var navListItems = $('.admin-menu li');
    var allWells = $('.admin-content');
    var allWellsExceptFirst = $('.admin-content:not(:first)');
    
    allWellsExceptFirst.hide();
    navItems.click(function(e)
    {
        e.preventDefault();
        navListItems.removeClass('active');
        $(this).closest('li').addClass('active');
        
        allWells.hide();
        var target = $(this).attr('data-target-id');
        $('#' + target).show();
    });
};
</script>
	
	
	<hr>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><span class="glyphicon glyphicon-folder-close"></span> Home</a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table">
                                <tbody><tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-pencil text-primary"></span> Articles</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-flash text-success"></span> News</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-file text-info"></span> About</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-comment text-success"></span> Comments</a> <span class="badge">42</span>
                                    </td>
                                </tr>
                            </tbody></table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"><span class="glyphicon glyphicon-user"></span> Profile</a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tbody><tr>
                                    <td>
                                        <a href="#">Change Password</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Notifications</a> <span class="label label-info">9</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Import</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#" class="text-danger"><span class="glyphicon glyphicon-trash text-danger"></span> Delete Account</a>
                                    </td>
                                </tr>
                            </tbody></table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><span class="glyphicon glyphicon-th"></span> Examples</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tbody><tr>
                                    <td>
                                        <a href="#">Orders</a> <span class="label label-success">$ 42</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Invoices</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Shipments</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Logging</a>
                                    </td>
                                </tr>
                            </tbody></table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
    						<span class="glyphicon glyphicon-file"></span> Reports</a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tbody><tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-usd"></span> Sales</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-user"></span> Customers</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-tasks"></span> Products</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</a>
                                    </td>
                                </tr>
                            </tbody></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9">
        </div>
    </div>
</div>

	<%-- 
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
 --%>

</body>
</html>