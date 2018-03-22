<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form>
	<!-- 添加员工时显示用户名 -->
		<c:if test="${empty requestScope.employee.id }">用户名：<form:input path="lastName" /><br></c:if>
		
		<!-- 更新时才显示员工的id和_method这个隐藏域 -->
		<c:if test="${!empty requestScope.employee.id }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="put">
			用户名：<form:input path="lastName" readonly="true"/><br>
		</c:if>
		
		邮箱：<form:input path="email"/><br>
		性别：<form:radiobutton path="gender" value="1" label="男"/>
		<form:radiobutton path="gender" value="0" label="女"/><br>
		部门：<form:select path="department.id" itemValue="id" itemLabel="departmentName" items="${requestScope.depts }"></form:select><br>
		<input type="submit">
	</form:form>
</body>
</html>