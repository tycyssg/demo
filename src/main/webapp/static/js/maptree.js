var formId = 0;
function addFile() {
	formId++;
	$(  	
		'<div id="dynamicform' + formId + '" class="formParamWrapper" style="clear:both;padding-bottom:5px;">' +
		'<div class="form-group">' +
		'<div class="input-group mb-2 mr-sm-2 mb-sm-0">' +
		' <div class="input-group-addon" style="width: 5%"><div style="width:25px;"><i class="fa fa-user"></i></div></div>' +
		'<input type="text" name="paramname[]" class="form-control" id="name" placeholder="Parameter Name" required autofocus>' +
		'</div>' +
		'<div class="input-group mb-2 mr-sm-2 mb-sm-0">' +
		'<button class="btn btn-danger btn-md" onclick="removeForm(dynamicform' + formId + ');" ><i class="fa fa-minus" aria-hidden="true"></i></button>' +
		'<button class="btn btn-primary btn-md" onclick="removeForm(dynamicform' + formId + ');" ><i class="fa fa-plus" aria-hidden="true"></i></button></div>' +
		'</div>' +
		'</div>' +
		'</div>'
		

	).appendTo('#divtoapp');

}

function removeForm(id) {
	$(id).empty();
}

function createModuleReceiver() {
	
	var arrParamName = [];
	arrParamName = $('input[name="paramname[]"]');
	var arrParamType = [];
	arrParamType = $('select[name="paramtype[]"]');
	var arrParams = [];
	var arrayOfLines = $('#catcodeid').val().split('\n');
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var obj = arrParamName;
			$.each(obj, function (index, element) {
				arrParams[index] = {
						"paramname":element.value,
						"paramtype":arrParamType[index].value
				}
			});
	
	
	$.ajax({
		type : "POST",
		url : "createmodulereceiver",
		contentType : "application/json",
		data : JSON.stringify({
			"label" : $('[name="label"]').val(),
			"catname" : $('[name="catname"]').val(),
			"catdes" : $('[name="catdes"]').val(),
			"catlink" : $('[name="catlink"]').val(),
			"fileextension" : $('[name="fileextension"]').val(),
			"catcode" : arrayOfLines,
			"params" : arrParams
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
	 document.getElementById("createModuleForm").reset();
	 
	$('<div class="alert alert-success" role="alert" >' +
		'Module was successfully created!' +
		'</div>').appendTo("#formSuccessDiv")
}

