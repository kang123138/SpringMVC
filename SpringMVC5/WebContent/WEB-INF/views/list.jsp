<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty requestScope.emps}">
			<h1>当前没有员工哟，嘿嘿嘿</h1>
		</c:when>
		<c:otherwise>

			<table  align="center" border="1" style="text-align: center;margin-top: 165px" cellpadding="10" cellspacing="0">
				<tr>
					<th>工号</th>
					<th>姓名</th>
					<th>邮箱</th>
					<th>性别</th>
					<th>部门</th>
					<th colspan="2">操作</th>
				</tr>

				<c:forEach items="${requestScope.emps}" var="emps">
					<tr>
						<td>${emps.id }</td>
						<td>${emps.lastName }</td>
						<td>${emps.email }</td>
						<td>${emps.gender }</td>
						<td>${emps.department.id }</td>
						<td><a href="#">编辑</a></td>
						<td><a href="#">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>