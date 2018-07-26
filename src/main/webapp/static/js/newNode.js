var finalTree = {};

function populateWithNodes(){
for (var nodeIdex = 0; nodeIdex < nodeList.length; nodeIdex++) {
		//console.log(nodeList[nodeIdex]);
	}
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
			console.log(data);
	        addNodeToLayout(data,fatherId)
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


function formSuccess() {
	$("#formSuccessDiv").empty();

	$('<div class="alert alert-success" role="alert" >' +
		'Details successfully added!' +
		'</div>').appendTo("#formSuccessDiv")
}


function saveNode(idNode,idFather) {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var nodeWeClickedOn = $("div[data-id-node='"+idNode+"'][data-id-father='"+idFather+"']");
	console.log(nodeWeClickedOn);

	var nodeName = $(nodeWeClickedOn).find('name="nodeName"').val();
	
	$.ajax({
		type : "POST",
		url : "/savenode",
		contentType : "application/json",
		data : JSON.stringify({
			"idNode" : idNode,
			"idFather":idFather,
			"nodeName":nodeName,
			"children" : []
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



function addNodeToLayout(idNode,idFather){
	console.log(idNode+"<=>"+idFather)
	$('<div data-id-node="'+idNode+'" data-id-father="'+idFather+'">'+
		'<div class="row">'+
			'<div class="col-sm-8" style="padding-top:5px;" >'+
				'<input type="text" name="nodeName"/>'+
			'</div>'+

			'<div class="col-sm-2">'+
				'<button class="btn btn-primary btn-md" onclick="createNewNode('+idNode+')" >'+
					'<i class="fa fa-plus" aria-hidden="true"></i>'+
				'</button>'+
			'</div>'+

			'<div class="col-sm-2">'+
				'<button class="btn btn-success btn-md" onclick="saveNode('+idNode+','+idFather+')" >'+
					'<i class="fa fa-check" aria-hidden="true"></i>'+
				'</button>'+
			'</div>'+
		'</div>'+
	'</div>').appendTo('#nodeappend');

}