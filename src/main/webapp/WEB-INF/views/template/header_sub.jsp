<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- nav -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
<%--       <li><a href="<%= request.getContextPath() %>/point/pointList">Point</a></li> --%>	<!--요즘은 안쓴다  -->
      <li><a href="${pageContext.request.contextPath}/notice/noticeList">NOTICE</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberList">MEMBER LIST</a></li>
       <li><a href="${pageContext.request.contextPath}/qna/qnaList">Q&A</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty member}">
      <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${not empty member}">
       <li><a href="${pageContext.request.contextPath}/member/memberPage"><span class="glyphicon glyphicon-user"></span> My Page</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
      </c:if>
    </ul>
  </div>
</nav>

    
</body>
</html>