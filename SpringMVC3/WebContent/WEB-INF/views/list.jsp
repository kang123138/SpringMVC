<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(".del").click(function() {
					// alert(confirm("确定"));
					var name = $(this).parents("tr").children("td:eq(0)").html();
					// 获取超链接中的URL
					// var hrefValue = this.href;
					// alert(this.href);
					// 添加判断条件
					if(!confirm("您确定删除《" + name + "》员工吗？")) {
						return false; 
					}
					var hrefValue = $(this).attr("href");
					$("form:eq(0)").attr("action",hrefValue).submit();
					return false;
				});    
			})
		</script>
</head>
<body>

	<!-- 	<form action="" method="post">
			<input type="hidden" name="_method" value="delete">
		</form> -->
		
		<!-- 建一个表单来发送post请求，actions属性让链接的href赋值 -->
		<form action="" method="post">
			<input type="hidden" name="_method" value="delete">
		</form>
	<!--  使用表单来遍历展示request域	-->
	<c:choose>
		<c:when test="${empty requestScope.emps }">
			<h1>不好意思，没有员工,你要能找出来，我就让你嘿嘿嘿</h1>
		</c:when>
		<c:otherwise>
			<table border="1"
				style="margin: auto; margin-top: 160px; text-align: center"
				cellspacing="0" cellpadding="10">
				<tr>
					<th>姓名</th>
					<th>邮箱</th>
					<th>性别</th>
					<th>部门</th>
					<th colspan="2"">操作</th>
				</tr>
				<c:forEach items="${requestScope.emps }" var="emps">
					<tr>
						<td>${emps.lastName }</td>
						<td>${emps.email }</td>
						<td>${emps.gender }</td>
						<td>${emps.department.id }</td>
						<td><a
							href="${pageContext.request.contextPath }/updateEmp/${emps.id }">编辑</a></td>
						<td><a
							href="${pageContext.request.contextPath }/deleteEmp/${emps.id }"
							class="del">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath }/addEmp">添加员工</a>
</body>
</html>