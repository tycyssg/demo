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
	
	
	
	window.onload = function() { 
		var dragging, placeholders = $();
		$.fn.sortable = function(options) {
			var method = String(options);
			options = $.extend({
				connectWith: false
			}, options);
			return this.each(function() {
				if (/^enable|disable|destroy$/.test(method)) {
					var items = $(this).children($(this).data('items')).attr('draggable', method == 'enable');
					if (method == 'destroy') {
						items.add(this).removeData('connectWith items')
							.off('dragstart.h5s dragend.h5s selectstart.h5s dragover.h5s dragenter.h5s drop.h5s');
					}
					return;
				}
				var isHandle, index, items = $(this).children(options.items);
				var placeholder = $('<' + (/^ul|ol$/i.test(this.tagName) ? 'li' : 'div') + ' class="sortable-placeholder">');
				items.find(options.handle).mousedown(function() {
					isHandle = true;
				}).mouseup(function() {
					isHandle = false;
				});
				$(this).data('items', options.items)
				placeholders = placeholders.add(placeholder);
				if (options.connectWith) {
					$(options.connectWith).add(this).data('connectWith', options.connectWith);
				}
				items.attr('draggable', 'true').on('dragstart.h5s', function(e) {
					if (options.handle && !isHandle) {
						return false;
					}
					isHandle = false;
					var dt = e.originalEvent.dataTransfer;
					dt.effectAllowed = 'move';
					dt.setData('Text', 'dummy');
					index = (dragging = $(this)).addClass('sortable-dragging').index();
				}).on('dragend.h5s', function() {
					if (!dragging) {
						return;
					}
					dragging.removeClass('sortable-dragging').show();
					placeholders.detach();
					if (index != dragging.index()) {
						dragging.parent().trigger('sortupdate', {item: dragging});
					}
					dragging = null;
				}).not('a[href], img').on('selectstart.h5s', function() {
					this.dragDrop && this.dragDrop();
					return false;
				}).end().add([this, placeholder]).on('dragover.h5s dragenter.h5s drop.h5s', function(e) {
					if (!items.is(dragging) && options.connectWith !== $(dragging).parent().data('connectWith')) {
						return true;
					}
					if (e.type == 'drop') {
						e.stopPropagation();
						placeholders.filter(':visible').after(dragging);
						dragging.trigger('dragend.h5s');
						return false;
					}
					e.preventDefault();
					e.originalEvent.dataTransfer.dropEffect = 'move';
					if (items.is(this)) {
						if (options.forcePlaceholderSize) {
							placeholder.height(dragging.outerHeight());
						}
						dragging.hide();
						$(this)[placeholder.index() < $(this).index() ? 'after' : 'before'](placeholder);
						placeholders.not(placeholder).detach();
					} else if (!placeholders.is(this) && !$(this).children(options.items).length) {
						placeholders.detach();
						$(this).append(placeholder);
					}
					return false;
				});
			});
		};
		}


	window.onload = function() { 
					$('.sortable').sortable();
					$('.handles').sortable({
						handle: 'span'
					});
					$('.connected').sortable({
						connectWith: '.connected'
					});
					$('.exclude').sortable({
						items: ':not(.disabled)'
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
                <ul class="nav ">
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
                        </ul>
            </div>
        </div>
    </div>
</div>
</div>
<div class="container">
	<div class="row">
	 <section class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
	   <section class="panel no-radius even-margin"> 
		 <section class="panel-body">   
			<section id="connected">
					<ul class="connected list">
						<li>Item 1</li>
						<li>Item 2</li>
						<li>Item 3</li>
						<li>Item 4</li>
						<li>Item 5</li>
						<li>Item 6</li>
					</ul>
					<ul class="connected list no2">
					
					</ul>
				</section>
		 </section>
		</section>
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