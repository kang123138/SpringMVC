<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#Json").click(function() {
				var url = $(this).attr("href"); 
				var callback = function(datas) {
					for (var i = 0; i < datas.length; i++) {
						alert(datas[i].lastName + "-" + datas[i].email + "-" + datas[i].gender);
					}
				};
				var type = "json";
				$.post(url,callback,type);
			});
		})
	</script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/emps" >获取所有员工信息</a>
	<a id="Json" href="${pageContext.request.contextPath }/testJson" >处理JSON</a>
	<a href="${pageContext.request.contextPath }/testJson1" >处理JSON1</a>
	<a href="${pageContext.request.contextPath }/testJson2" >处理JSON2</a>
</body>
</html>