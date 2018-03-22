<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 测试文件上传 -->
	<form action="${pageContext.request.contextPath}/testUpload" method="post" enctype="multipart/form-data">
		描述：<input type="text" name="desc"><br>
		文件：<input type="file" name="file"><br>
		<input type="submit">
	</form>
	
	<!-- 使用@RequestBody测试文件上传 -->
	<form action="${pageContext.request.contextPath}/testRequestBody" method="post" enctype="multipart/form-data">
		描述：<input type="text" name="desc"><br>
		文件：<input type="file" name="file"><br>
		<input type="submit">
	</form>
	
	<a href="${pageContext.request.contextPath }/testResponseEntity">下载文件</a><br>
	<a href="${pageContext.request.contextPath }/testMyInterceptor">测试自定义拦截器</a><br>
	<a href="${pageContext.request.contextPath }/testI18n">测试国际化</a><br>
	<a href="${pageContext.request.contextPath }/testI18n?language=zh_CN">中文</a><br>
	<a href="${pageContext.request.contextPath }/testI18n?language=en_US">English</a><br>
	
</body>
</html>