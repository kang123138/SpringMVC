<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form>
		<!-- path属性就相当于input中的name属性 -->
		用户名：<form:input path="lastName" />
		<br>
		邮箱：<form:input path="email" />
		<br>
		性别：<form:radiobutton path="gender" value="1" label="男" />
		<form:radiobutton path="gender" value="0" label="女" />
		<br>
		部门：<form:select path="department.id" items="${requestScope.depts }"
			itemValue="id" itemLabel="departmentName"></form:select>
		<input type="submit">
	</form:form>


</body>
</html>