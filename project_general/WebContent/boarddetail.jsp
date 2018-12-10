<%@page import="java.util.List"%>
<%@page import="com.pg.dtos.pgrepDtos"%>
<%@page import="com.pg.dtos.pgDtos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%
pgDtos dto = (pgDtos)request.getAttribute("dto");
//pgrepDtos dto1 = (pgrepDtos)request.getAttribute("dto1");
List<pgrepDtos> list = (List<pgrepDtos>)request.getAttribute("dto1");
%>

<body>
<h1>게시판 상세보기</h1>
제목 : <%=dto.getTitle() %> 날짜 : <%=dto.getTime()%> 조회수 : <%=dto.getView1() %>
<p>아이디 : <%=dto.getNickname()%>

<p><textarea rows="10" cols="60" readonly><%=dto.getContent()%>  좋아요 : <%=dto.getLike1()%> 싫어요 : <%=dto.getHate() %>
</textarea>


<p>
<p>

--------------------------------댓글 보기---------------------------------------------------------------------
<% for(int i=0; i<list.size(); i++) {
	pgrepDtos dto1 = list.get(i);
	%>
	<hr />
	<%=dto1.getCommentnum() %>
	<%=dto1.getContent() %>

<% 

}
%>



</body>
</html>