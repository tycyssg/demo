/**
 * 
 */
// websockets logic
var socket = new WebSocket("ws://localhost:8080/server");
var messageTextArea = document.getElementById("messages");
var fileTextArea = document.getElementById("fname");
var nameHidden = document.getElementById("name");
var fileHidden = document.getElementById("file");

// Websockets Messages
socket.onopen = function(message) {
	processOpen(message);
};
socket.onmessage = function(message) {
	processMessage(message);
};
socket.onclose = function(message) {
	processClose(message);
};
socket.onerror = function(message) {
	processError(message);
};

function processOpen(message) {
	socket.send(nameHidden.value + " " + fileHidden.value);
	messageTextArea.value += "Server Connect..\n";
}

function processMessage(message) {
	if (message.data.substring(0, 6) == "System"
			|| message.data.substring(0, 4) == "CHAT") {
		messageTextArea.value += message.data + "\n";
	} else {
		var array = message.data.split("+");
		var outFnct = array[1].length;

		$("#" + array[0]).val(array[1]);
		$("#" + array[0]).css("background-color", "#9BFFAF");
		$("#" + array[0]).attr('disabled', 'disabled');

		setTimeout(function() {
			var inFnct = array[1].length;
			if (outFnct == inFnct) {
				$("#" + array[0]).css("background-color", "white");
				$("#" + array[0]).removeAttr('disabled');
			}
		}, 5000);
	}

}

function sendMessage() {
	
	if (textMessage.value != "close") {
		socket.send("You: " + textMessage.value);
		messageTextArea.value += "You: " + textMessage.value + "\n";
	} else {
		socket.close();
	}
}

function processClose(message) {
	socket.send("Client disconnected...");
	messageTextArea.value += "Server Disconnect...\n";
}

function processError(message) {
	socket.send("Client Error");
	messageTextArea.value += "error...\n";
}


//Write in file logic start
var lineBefore;


function processIds(idInfo) {
	lineBefore = document.getElementById(idInfo).value;
	document.getElementById(idInfo).readOnly = false;
	console.log("On focus sunt here")
}

function updateFile(id) {
	console.log("On blur sunt here")
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var lineAfter;
	
			var timeNow = new Date().getTime();
			lineAfter = document.getElementById(id).value;

//New Way to send
	
	$.ajax({
		type : "POST",
		url : "send-update",
		contentType : "application/json",
		data : {
			before : lineBefore,
			after : lineAfter,
			fileName : fileHidden.value,
			time : timeNow
		},
		success : function(data, status) {
			var localId = clickId;
			document.getElementById(localId+"m").innerHTML = status;
			$('#' + localId + 'h').removeClass('hr-primary').addClass('hr-success');
	setTimeout(function() {
			document.getElementById(localId+ "m").innerHTML = "";
			$('#'+ localId+'h').removeClass('hr-success').addClass('hr-primary');
	}, 1500);
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

function updateFormsWithSocket(id){
	console.log("On keyup sunt here")
	var idAndLine = id+"+"+ document.getElementById(id).value;
	socket.send(idAndLine);
}