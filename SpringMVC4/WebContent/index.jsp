<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/testPOJO"
		method="post">
		工号：<input type="text" name="id"><br> 姓名：<input
			type="text" name="lastName"><br> 邮箱：<input type="text"
			name="email"><br> 工资：<input type="text" name="salary"><br>
		部门编号<input type="text" name="dept.id"><br> 部门名称<input
			type="text" name="dept.name"> <br> <input type="submit"
			value="提交">
	</form>

	<a href="${pageContext.request.contextPath }/testServletAPI">测试原生ServeltAPI</a>
	<br>
	<a href="${pageContext.request.contextPath }/testModel">测试原生testModel</a>
	<br>
	<a href="${pageContext.request.contextPath }/testModelAndView">测试testModelAndView</a>
	<br>
	<a href="${pageContext.request.contextPath }/testMap">测试入参中传map</a>
	<br>
	<a href="${pageContext.request.contextPath }/testSession">测试入参中传session</a>
	<br>
	
	<form action="${pageContext.request.contextPath }/testModelAttribute"
		method="post">
		<!-- 
			假设从数据库中查询出了要更新的User对象，User对象的信息是：
				1-Xugang-222222-xugang@dym.com	
			要求：更新用户信息是不能更新用户的密码，即用户的密码不能显示在表单中	
		 -->
		<input type="hidden" name="id" value="1"><br> 
		姓名：<input type="text" name="username"><br> 
		邮箱：<input type="text" name="email"><br> 
		<input type="submit">
	</form>
</body>
</html>