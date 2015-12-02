//表格显示
$(function() {
	var table = $("#example").DataTable({

		"ordering" : false,
		// "searching" : false,
		"iDisplayLength" : 5,
		// 设置每页显示记录的下拉菜单
		"aLengthMenu" : [ [ 5, 10, 15 ], [ "5", "10", "15" ] ],
		"scrollX" : true,
		"pagingType" : "full_numbers",
		"oLanguage" : {
			"sLengthMenu" : "每页显示 _MENU_ 条",
			"sZeroRecords" : "无匹配数据",
			"sInfo" : "当前显示  _START_ - _END_ 条   共  _TOTAL_ 条记录",
			"sInfoEmpty" : "当前显示   0 ~ 0 条 / 共 0 条记录",
			"sInfoFiltered" : "/ 从 _MAX_ 条记录中筛选出",
			"sSearch" : "搜索:",
			"oPaginate" : {
				"sFirst" : "首页",
				"sLast" : "尾页",
				"sPrevious" : "上一页",
				"sNext" : "下一页"
			}
		},
		
	});
	
});
