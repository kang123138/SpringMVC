<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是成功页面</h1>
	
	<table cellspacing="0" border="1" cellpadding="10" align="center" style="text-align: center">
		<tr>
			<th>姓名</th>
			<th>邮箱</th>
			<th>工资</th>
			<th>部门</th>
			<th colspan="2">操作</th>
		</tr>
	<c:forEach items="${requestScope.emps }" var="emps">
		<tr>
			<td>${emps.lastName }</td>
			<td>${emps.email }</td>
			<td>${emps.salary }</td>
			<td>${emps.deptId }</td>
			<td><a href="#">编辑</a></td>
			<td><a href="#">删除</a></td>
		</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>