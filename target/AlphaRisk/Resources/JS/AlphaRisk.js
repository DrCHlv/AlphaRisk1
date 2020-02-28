function menu2Page(msg){
	if(msg != ""){
		$.post(msg,function(data){
			$('#content').html(data);
		});
	}
}

function menu2Controller(msg){
	if(msg != ""){
		layer.msg(msg);
		window.location.href=msg;
	}
}