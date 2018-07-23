<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="header.jsp" />
  <head>
	<link href="static/css/testmanager.css" rel="stylesheet">    
  </head>

<body>
	<div id="maincontainer">
		<div id="mainContent">
			<jsp:include page="menu.jsp" />


<script>
$(document).ready(function () {

	$('.star').on('click', function () {
      $(this).toggleClass('star-checked');
    });

    $('.ckbox label').on('click', function () {
      $(this).parents('tr').toggleClass('selected');
    });

    $('.btn-filter').on('click', function () {
      var $target = $(this).data('target');
      if ($target != 'all') {
        $('.table tr').css('display', 'none');
        $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
      } else {
        $('.table tr').css('display', 'none').fadeIn('slow');
      }
    });

 });
</script>

<div class="container" style="width:80%">
	<div class="row">
		<section class="content">
			<h1>Tests Manager</h1>
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="pull-right">
							<div class="btn-group">
								<button type="button" class="btn btn-success btn-filter" data-target="cat1">Fav category 1</button>
								<button type="button" class="btn btn-warning btn-filter" data-target="cat2">Fav category 2</button>
								<button type="button" class="btn btn-danger btn-filter" data-target="cat3">Fav category 3</button>
								<button type="button" class="btn btn-default btn-filter" data-target="all">All categories</button>
							</div>
						</div>
						
						<div class="table-container">
							<table class="table table-filter">
								<tbody>
									<tr data-status="cat1"><!-- Start Row -->
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox1">
												<label for="checkbox1"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										
										<td>
											<div class="container-fluid" style="background-color:white;padding:0;">
											 <div class="row" style="line-height:48px;">
											    <div class="col-sm-1 text-center">
											    <a href="#">
													<img src="static/icons/testsicon.png" width="48" height="48">
													</a>
											    </div>
											    
											    <div class="col-sm-8">
											    <em class="text-secondary pull-right">23/07/2018</em>
											    <strong class="test-tag-green pull-right">(tag)&nbsp;&nbsp;</strong>
											    <h5><strong class="title">Something</strong>
											    <p>Ut enim ad minim veniam, quis nostrud exercitation...</p>
											    </h5>
											    
											    </div>
											    <div class="col-sm-3 text-center" style="padding-top:5px;">
											    <nav class="test-manager-settings-buttons">
											    <a href="#"><span class="glyphicon glyphicon-pencil" title="Edit Test"></span></a>
											    <a href="#"><span class="glyphicon glyphicon-trash"  title="Delete Test"></span></a>
											     <a href="#"><span class="glyphicon glyphicon-play"  title="Start Test"></span></a>
											    </nav>
											    </div>
  												</div>
											
											</div>
											
										</td>
									</tr><!-- End Row -->
										<tr data-status="cat2"><!-- Start Row -->
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox1">
												<label for="checkbox1"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										
										<td>
											<div class="container-fluid" style="background-color:white;padding:0;">
											 <div class="row" style="line-height:48px;">
											    <div class="col-sm-1 text-center">
											    <a href="#">
													<img src="static/icons/testsicon.png" width="48" height="48">
													</a>
											    </div>
											    
											    <div class="col-sm-8">
											    <em class="text-secondary pull-right">23/07/2018</em>
											    <strong class="test-tag-orange pull-right">(tag)&nbsp;&nbsp;</strong>
											    <h5><strong class="title">Something</strong>
											    <p>Ut enim ad minim veniam, quis nostrud exercitation...</p>
											    </h5>
											    
											    </div>
											    <div class="col-sm-3 text-center" style="padding-top:5px;">
											    <nav class="test-manager-settings-buttons">
											    <a href="#"><span class="glyphicon glyphicon-pencil" title="Edit Test"></span></a>
											    <a href="#"><span class="glyphicon glyphicon-trash"  title="Delete Test"></span></a>
											     <a href="#"><span class="glyphicon glyphicon-play"  title="Start Test"></span></a>
											    </nav>
											    </div>
  												</div>
											
											</div>
											
										</td>
									</tr><!-- End Row -->
										<tr data-status="cat3"><!-- Start Row -->
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox1">
												<label for="checkbox1"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										
										<td>
											<div class="container-fluid" style="background-color:white;padding:0;">
											 <div class="row" style="line-height:48px;">
											    <div class="col-sm-1 text-center">
											    <a href="#">
													<img src="static/icons/testsicon.png" width="48" height="48">
													</a>
											    </div>
											    
											    <div class="col-sm-8">
											    <em class="text-secondary pull-right">23/07/2018</em>
											    <strong class="test-tag-red pull-right">(tag)&nbsp;&nbsp;</strong>
											    <h5><strong class="title">Something</strong>
											    <p>Ut enim ad minim veniam, quis nostrud exercitation...</p>
											    </h5>
											    
											    </div>
											    <div class="col-sm-3 text-center" style="padding-top:5px;">
											    <nav class="test-manager-settings-buttons">
											    <a href="#"><span class="glyphicon glyphicon-pencil" title="Edit Test"></span></a>
											    <a href="#"><span class="glyphicon glyphicon-trash"  title="Delete Test"></span></a>
											     <a href="#"><span class="glyphicon glyphicon-play"  title="Start Test"></span></a>
											    </nav>
											    </div>
  												</div>
											
											</div>
											
										</td>
									</tr><!-- End Row -->
									
								
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
			</div>
		</section>
		
	</div>
</div>




		</div>
		<!-- ENd main -->
	</div>
	<!-- end COntainer -->
	<jsp:include page="footer.jsp" />
</body>
</html>