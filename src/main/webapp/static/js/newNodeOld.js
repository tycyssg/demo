var nodeList = [
	{"id":1,"nodeName":"anyname","childrens":[5,6,7]},
	{"id":2,"nodeName1":"anyname1","childrens":[5,6,7]},
	{"id":3,"nodeName2":"anyname2","childrens":[5,6,7]}
	]

/*
window.onload = function() {

		var list = ${nodeList};
		$.each(list, function( index, value ) {
			alert( index + ": " + value );
		});
}
*/

function saveNode(id,fatherId) {
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
					
				var nodeN = $(id).val();
				var nodeFather = $(fatherId).val();
				
				var children = [];
				
				console.log("Node Name"+nodeN);
				console.log("Node Father"+nodeFather);
				
				$.ajax({
					type : "POST",
					url : "/savenode",
					contentType : "application/json",
					data : JSON.stringify({
						"nodeName" : nodeN,
						"nodeFather":nodeFather,
						"childrens" : children
					}),
					success : formSuccess(),
					dataType : "json",
					
					async : true,
					    beforeSend: function(xhr) {
					        xhr.setRequestHeader("Accept", "application/json");
					        xhr.setRequestHeader("Content-Type", "application/json");
					        xhr.setRequestHeader(header, token);
					    }
				});
			}

			function formSuccess() {
				$("#formSuccessDiv").empty();

				$('<div class="alert alert-success" role="alert" >' +
					'Details successfully added!' +
					'</div>').appendTo("#formSuccessDiv")
			}

			
			function addNewNode(idNode,father){
				console.log("La inceput de addNewNode id"+idNode+" father"+father);
				
				var idFather;
				if(isNaN(father)){
					idFather = $(father).attr('id');
					console.log("in the if "+idFather);
				}else{
					idFather = "idFather"+father;
					console.log("in the else "+idFather);
				}
				
				
				$(
				'<div class="row">'+
				'<div class="col-sm-8" style="padding-top:5px;" >'+
				'<input type="hidden" name="fatherNode" value="'+idNode+' "id="idFather'+idNode+'" />'+
				'<input type="text" name="nodeName" id="nodeId'+idNode+'" />'+
				'</div>'+
				'<div class="col-sm-2">'+
				'<button class="btn btn-primary btn-md" onclick="createNewNode(idFather'+idNode+')" >'+
				'<i class="fa fa-plus" aria-hidden="true"></i>'+
				'</button>'+
				'</div>'+
				'<div class="col-sm-2">'+
						'<button class="btn btn-success btn-md" onclick="saveNode(nodeId'+idNode+','+idFather+')" >'+
						'<i class="fa fa-check" aria-hidden="true"></i>'+
				'</button>'+
				'</div>'+
				'</div>'
				).appendTo('#nodeappend');
				
				console.log("trimit in save node nodeId"+idNode+","+idFather);
			}
			
			function createNewNode(fatherId){
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
					
				
				$.ajax({
					type : "POST",
					url : "/createNewNode",
					contentType : "application/json",
					data : JSON.stringify({}),
					success :function(data){
				        addNewNode(data,fatherId)
					},
					dataType : "json",		
					async : true,
					    beforeSend: function(xhr) {
					        xhr.setRequestHeader("Accept", "application/json");
					        xhr.setRequestHeader("Content-Type", "application/json");
					        xhr.setRequestHeader(header, token);
					    }
				});
			}
			