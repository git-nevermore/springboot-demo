/**
 * 获取全部用户信息
 * @returns
 */
function getAllUser() {
	var res = '';
	$.ajax({
		url : "/list",
		dataType : "json",
		type : "get",
		async : false,
		success : function(result) {
			//表单数据填充操作
		}
	});
	return res;
}

//获取单个用户
function getUser() {
	var res = '';
	$.ajax({
		url : "/user",
		dataType : "json",
		type : "get",
		async : false,
		success : function(result) {
			//表单数据填充操作
		}
	});
	return res;
}