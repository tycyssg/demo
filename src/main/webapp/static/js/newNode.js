function saveNode(id,fatherId) {
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
					
				var nodeN = $(id).val();
				var nodeFather = $(fatherId).val();
				
				$(id).val(nodeN);
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


			function addNewNode(id,father){
				var previousNodeName;
				var fatherId = father+id;

				console.log($(father).val());
				console.log(id);
				console.log($(father).attr('id'));
				
				if(father === "fatherId"){
					previousNodeName = $(father).val();
				}
				else{
					previousNodeName = $(fatherId).val();
				}
				
				$(
				'<div class="row">'+
				'<div class="col-sm-8" style="padding-top:5px;" >'+
				'<input type="hidden" name="fatherNode" value="'+previousNodeName+'" id="'+fatherId+'" />'+
				'<input type="text" name="nodeName" id="nodeId'+id+'" />'+
				'</div>'+
				'<div class="col-sm-2">'+
				'<button class="btn btn-primary btn-md" onclick="createNewNode('+fatherId+')" >'+
				'<i class="fa fa-plus" aria-hidden="true"></i>'+
				'</button>'+
				'</div>'+
				'<div class="col-sm-2">'+
						'<button class="btn btn-success btn-md" onclick="saveNode(nodeId'+id+','+fatherId+')" >'+
						'<i class="fa fa-check" aria-hidden="true"></i>'+
				'</button>'+
				'</div>'+
				'</div>'
				).appendTo('#nodeappend');

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
			