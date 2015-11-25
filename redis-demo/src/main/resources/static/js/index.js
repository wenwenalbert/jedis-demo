//表格显示
$(function() {
	var table = $("#example").DataTable({

		"columnDefs" : [ {
			"visible" : false,
			"targets" : -1
		} ]

	});
	
	$('#example-getting-started').multiselect({
		includeSelectAllOption: true,
		selectAllText: 'All',
		buttonWidth: '200px',
		allSelectedText: 'All',
	});
});

$('#datetimepicker').datetimepicker({
	format : 'yyyy-mm-dd',
	language : 'zh-CN',
	weekStart : 0,
	todayBtn : true,
	todayHighlight : true,
	autoclose : true,
	startView : 2,
	minView : 2,
	forceParse : true,
	pickDate: false
});

function uploadFile() {
	var files = $("#file")[0].files; // js 获取文件对象
	
	var FileController = "/file/upload"; // 接收上传文件的后台地址
	
	console.log(files);
	var form = new FormData();
	if (files.length != 0) {
		
		for (var j = 0; j < files.length; j++) {
			form.append("files", files[j]); // 文件对象
		}
	}
	console.log($("#name").val());
	form.append("name", $("#name").val());
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = callback;
	xmlHttpRequest.open("post", FileController, true);
	
	xmlHttpRequest.send(form);
}

function callback() {
	// 接收响应数据
	// 判断对象状态是否交互完成，如果为4则交互完成
	if (xmlHttpRequest.readyState == 4) {
		// 判断对象状态是否交互成功,如果成功则为200
		if (xmlHttpRequest.status == 200) {
			// 接收数据,得到服务器输出的纯文本数据
			var response = xmlHttpRequest.responseText;
			alert(response);
		}
	}
}