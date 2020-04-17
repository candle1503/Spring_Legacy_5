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
<h1>${board} Write Form</h1>
	<div class="row">
	<table class="table table-hover">
		<tr>
			<td>Title</td>
			<td>Writer</td>
			<td>Contents</td>
			<td>HIT</td>
		</tr>
		
		<tr>
			<td>${vo.title}</td>
			<td>${vo.writer}</td>
			<td>${vo.contents}</td>
			<td>${vo.hit}</td>
		</tr>
	</table>			
		<label for="comment">Contents:</label>
      <textarea class="form-control" rows="15" id="text" name="text" readonly="readonly">${vo.contents}</textarea>
      <br>
</div>

	<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger">글삭제</a>
	<a href="./${board}Update?num=${vo.num}" class="btn btn-info">글수정</a>

</div>
</body>
</html>