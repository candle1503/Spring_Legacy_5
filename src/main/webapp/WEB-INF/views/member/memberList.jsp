<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header_sub.jsp"></c:import>
<div class="container">
		<div class="row">
			<h1>${board} List</h1>
			
		</div>
			<table class="table table-hover">
				<tr bgcolor="gray" >
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
				</tr>

			<c:forEach items="${list}" var="vo">				
				<tr>
					<td>${vo.id}</td>
					<td>${vo.name}</td>
					<td>${vo.phone}</td>
					<td>${vo.email}</td>		
				</tr>
			</c:forEach>

			</table>
			
			<div>
				<a href="./${board}Write" class="btn btn-danger">WRITE</a>
			</div>
			
		</div>
</body>
</html>