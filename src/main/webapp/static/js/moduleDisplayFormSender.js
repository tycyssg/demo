//document.getElementsByName('param3')[0].checked

(function ($) {
    $.fn.serializeFormJSON = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);



function moduleDisplaySender() {
		
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var myData = $("#moduleDisplayForm").serializeFormJSON();
	
	console.log(myData);
	
	$.ajax({
		type : "POST",
		url : "moduledisplayreceiver",
		contentType : "application/json",
		data : JSON.stringify(myData),
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
	 document.getElementById("moduleDisplayForm").reset();
	 
	$('<div class="alert alert-success" role="alert" >' +
		'Module was successfully created!' +
		'</div>').appendTo("#formSuccessDiv")
}

