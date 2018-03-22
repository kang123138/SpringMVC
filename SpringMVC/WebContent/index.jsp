<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/hellowSpringMVC">HelloSpringMVC</a>
	<br>
	<a href="${pageContext.request.contextPath }/hellowSpringMVC1">testvalue</a>
	<br>
	<a href="${pageContext.request.contextPath }/hellowSpringMVC3">testMehod</a>
	<br>
	<form action="${pageContext.request.contextPath }/hellowSpringMVC3"
		method="post">
		<input type="submit" value="测试方法属性method">
	</form>

	<a
		href="${pageContext.request.contextPath }/hellowSpringMVC4?username=admin&password=root">testparams</a>
	<br>
	<a href="${pageContext.request.contextPath }/hellowSpringMVC5">testHeaders</a>
	<br>
	<a
		href="${pageContext.request.contextPath }/hellowSpringMVC6/u">testAnt</a>
	<br>
	<a href="${pageContext.request.contextPath }/testVariable/abc">testPathVariable</a>
	<br>
	<a href="${pageContext.request.contextPath }/testREST/1">测试REST风格的GET请求</a>
	<br>

	<form action="${pageContext.request.contextPath }/testREST"
		method="post">
		<input type="submit" value="测试REST风格的POST请求">
	</form>

	<form action="${pageContext.request.contextPath }/testREST/1"
		method="post">
		<input type="hidden" name="_method" value="put">
		<input type="submit" value="测试REST风格的PUT请求">
	</form>
	
	<form action="${pageContext.request.contextPath }/testREST/2"
		method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="测试REST风格的DELETE请求">
	</form>
	
	<a href="${pageContext.request.contextPath }/testRequestParam?username=admin">测试@RequestParam注解</a><br>
	
	<a href="${pageContext.request.contextPath }/testRequestHeader">测试@RequestHeader注解</a><br>
	<a href="${pageContext.request.contextPath }/testRequestCookie">测试@RequestCookie注解</a><br>
</body>
</html>