<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<!DOCTYPE html><html lang='en' class=''>
<head><script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/cliffpyles/pen/fxKDu?limit=all&page=26&q=draggable" />
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'><script src='https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js'></script>
<style class="cp-pen-styles">@import url(https://fonts.googleapis.com/css?family=Lato);
body {
  background-color: #eaeaea;
  color: #333;
  font-family: Lato;
  -webkit-font-smoothing: antialiased;
}
[contenteditable="true"]:focus {
  outline: 1px solid black;
}
h1 {
  margin: 20px;
  text-align: left;
  color: #DA4453;
}
h2 {
  text-align: right;
  line-height: 1;
  margin: 0 0 10px 0;
  padding: 0;
}
h3 {
  line-height: 1.5;
  margin: 0;
  padding: 0;
  color: #ED5565;
}
h4 {
  line-height: 1;
  margin: 0;
  padding: 0;
  text-align: left;
  color: #ED5565;
}
a {
  color: #e8273b;
  transition: all 0.3s ease-in-out;
}
a:hover {
  color: #c71528;
  text-shadow: 0px 0px 12px #ED5565;
}
#page {
  width: 960px;
  margin: 0px auto;
}
#users {
  float: left;
  margin: 0 0 0 20px;
}
#users h3 {
  text-align: right;
}
#completed-tasks {
  float: left;
  width: 23%;
  padding: 0px;
  overflow-x: hidden;
}
#completed-tasks.open {
  width: 23%;
}
#completed-tasks .actions {
  display: none;
}
#completed-tasks .task {
  border-width: 0px 0px 1px 0px;
}
#completed-tasks .task p {
  text-decoration: line-through;
}
.user-panel {
  display: inline-block;
  padding: 8px;
  width: 200px;
  vertical-align: top;
  background-color: #fff;
  border-radius: 3px;
}
.user-name.over ~ .task-list {
  border: 3px dashed #dadada;
}
.toolbar {
  text-align: right;
  line-height: 30px;
  padding: 0px 6px;
  display: none;
}
.task-list {
  position: relative;
  margin: 4px 0px 0px 0px;
}
.task {
  position: relative;
  background-color: #eaeaea;
  text-align: left;
  padding: 0px 0px 0px 4px;
  margin: 0px 0px 1px 0px;
  border: 1px solid #dadada;
  border-width: 1px 1px 0px 1px;
}
.task:last-child {
  border-width: 1px;
}
.task > p {
  color: #808080;
  margin: 0;
  padding: 0;
  line-height: 30px;
  display: inline-block;
  width: 90%;
  vertical-align: top;
}
.actions {
  position: absolute;
  display: inline-block;
  padding: 0px;
  margin: 0px -200px 0 0;
  width: 19px;
  height: 22px;
  z-index: 10;
  overflow: hidden;
  background-color: #fff;
  opacity: 0.5;
  transition: all 0.75s ease-in-out;
}
.actions:hover {
  width: 150px;
  opacity: 1;
}
.actions a {
  padding: 0px 10px;
}
.task.over {
  border-top: 3px dashed #dadada;
}
</style></head><body>
<!-- JJ -->
<div id="page">
	<div id="workarea">
		<h1>Drag and Drop Tasks</h1>
		<div id="completed-tasks">
			<h3>
				<em class="icon-ok icon-large"></em> Completed Tasks
			</h3>	
		</div><!-- #completed-tasks -->
		<div id="users" class="user-panels">
			<div id="user-1" class="user-panel">
				<h4 class="user-name">John Doe</h4>
				<div class="toolbar">
					<a href="#" class="add-task icon icon-plus"></a>
				</div>
				<div class="task-list">
					<div id="task-1" class="task">
						<p>task 1</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
					<div id="task-2" class="task">
						<p>task 2</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>

					</div>
					<div id="task-3" class="task">
						<p>task 3</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>

					</div>
					<div id="task-4" class="task">
						<p>task 4</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
				</div>
			</div>
			<div id="user-2" class="user-panel">
				<h4 class="user-name">Jane Doe</h4>
				<div class="toolbar">
					<a href="#" class="add-task icon icon-plus"></a>
				</div>
				<div class="task-list">
					<div id="task-5" class="task">
						<p>task 5</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
					<div id="task-6" class="task">
						<p>task 6</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
					<div id="task-7" class="task">
						<p>task 7</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
					<div id="task-8" class="task">
						<p>task 8</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
				</div>
			</div>
			<div id="user-3" class="user-panel">
				<h4 class="user-name">Suzy Q</h4>
				<div class="toolbar">
					<a href="#" class="add-task icon icon-plus"></a>
				</div>
				<div class="task-list">
					<div id="task-9" class="task">
						<p>task 9</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
					<div id="task-10" class="task">
						<p>task 10</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
					<div id="task-11" class="task">
						<p>task 11</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
					<div id="task-12" class="task">
						<p>task 12</p>
						<div class="actions">
							<a href="#" class="icon-caret-right"></a>
							<a href="#" class="icon-ok"></a>
							<a href="#" class="icon-pencil"></a>
							<a href="#" class="icon-trash"></a>
						</div>
					</div>
				</div>
			</div>
			
		</div><!-- #users -->
		
	</div><!-- #workarea -->
</div><!-- #page -->
<!-- SDG -->
<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script><script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script >;(function ( $, window, undefined ) {
  var pluginName = 'dragDrop',
	  document = window.document,
	  defaults = {
		  draggableSelector: ".draggable",
		  droppableSelector: ".droppable",
      	  appendToSelector: false
	  };


  function Plugin( element, options ) {
	  this.element = element;
	  this.options = $.extend( {}, defaults, options) ;

	  this._defaults = defaults;
	  this._name = pluginName;

	  this.init();
  }

  Plugin.prototype.init = function () {
	  var droppables = $(this.element).find(this.options.droppableSelector);
	  var draggables = $(this.element).find(this.options.draggableSelector).attr("draggable", "true");
    
    if(this.options.appendToSelector){
      var appendables = $(this.options.appendToSelector);
      
      appendables.on({
        'dragenter': function(ev){
          ev.preventDefault();
          return true;
        },
        'drop': function(ev){
          var data = ev.originalEvent.dataTransfer.getData("Text");
          var draggedEl = document.getElementById(data);
          var destinationEl = $(ev.target);

          destinationEl = destinationEl.closest(appendables.selector).siblings(droppables.selector).append(draggedEl);
          $('.active').removeClass('active');
          $('.over').removeClass('over');
          ev.stopPropagation();
          return false;
        },
        'dragover': function(ev){
          ev.preventDefault();
          $(ev.target).closest(appendables.selector).addClass('over');
          return true;
        },
        'dragleave': function(ev){
          ev.preventDefault();
          $(ev.target).closest(appendables.selector).removeClass('over');
          return true;
        }
      });
    }
    
    droppables.on({
      'mouseup': function(ev){
        $('.active').removeClass('active');
        return true;
      },
      'dragenter': function(ev){
        ev.preventDefault();
        return true;
      },
      'drop': function(ev){
        var data = ev.originalEvent.dataTransfer.getData("Text");
        var draggedEl = document.getElementById(data);
        var destinationEl = $(ev.target);
        
        destinationEl.closest(draggables.selector).before(draggedEl);
        $('.active').removeClass('active');
        $('.over').removeClass('over');
        ev.stopPropagation();
        return false;
      },
      'dragover': function(ev){
        ev.preventDefault();
        $(ev.target).closest(draggables.selector).addClass('over');
        return true;
      },
      'dragleave': function(ev){
        ev.preventDefault();
        $(ev.target).closest(draggables.selector).removeClass('over');
        return true;
      }
    });
    
    
    draggables.on({
      'mousedown': function(ev){
        $(ev.target).closest(draggables.selector).addClass('active');
        return true;
      },
      'mouseup': function(ev){
        $('.active').removeClass('active');
        return true;
      },
      'dragstart': function(ev){
        ev.originalEvent.dataTransfer.effectAllowed='move';
        ev.originalEvent.dataTransfer.setData("Text", ev.target.getAttribute('id'));
        ev.originalEvent.dataTransfer.setDragImage(ev.target,100,20);
        return true;
      },
      'dragend': function(ev){
        return true;
      }
    });
	
  };

  // A really lightweight plugin wrapper around the constructor, 
  // preventing against multiple instantiations
  $.fn[pluginName] = function ( options ) {
	return this.each(function () {
	  if (!$.data(this, 'plugin_' + pluginName)) {
		$.data(this, 'plugin_' + pluginName, new Plugin( this, options ));
	  }
	});
  }

}(jQuery, window));

$(document).ready(function(){
  $("#users").dragDrop({
		  draggableSelector: ".task",
		  droppableSelector: ".task-list",
      appendToSelector: ".user-name"
	});
  $("a.icon-trash").on("click", function(){
    $(this).closest(".task").remove();
  });
  $("a.icon-ok").on("click", function(){
    $(this).closest(".task").appendTo("#completed-tasks");
    $("#completed-tasks").addClass('open');
  });
  $("a.icon-pencil").on("click", function(){
    var task = $(this).closest(".task");
    task.attr("draggable", "false");
    task.find("p").attr("contenteditable", "true").on({
        "keypress": function(ev){
          if(ev.keyCode == 13)
          {
            ev.preventDefault();
            $(this).attr("contenteditable", "false");
            task.attr("draggable", "true");
          }
        },
        "focusout": function(ev){
          $(this).attr("contenteditable", "false");
            task.attr("draggable", "true");
        }
    }).focus();
  });
});
//# sourceURL=pen.js
</script>
</body></html>