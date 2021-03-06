<%@page import="com.pg.dtos.pgDtos"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>

* {
  margin:0; padding:0;
}

body {
  font-size:14px;
  font-family:"맑은 고딕";
}

 a {
    color:#000;
   text-decoration:none;
   cursor:pointer;
  }

  a:hover {
    color:yellowgreen;
    text-decoration:underline;
  }

#board {
  width:830px;
  margin:30px auto 10px;
}

  #title {
    height:45px;
   font-weight:bold;
   font-size:16px;
    clear:both;
  }

.list dl dt {
  float:left;
}

.list dl dd {
  float:left;
}

   .list .num {width:60px;} 
.list .sub {width:410px;} 
.list .name {width:95px;} 
.list .data {width:85px;} 
.list .count {width:60px;} 


.list dt {
  width:150px;
  text-align:center;
  background-color:lightblue;
  border-bottom:2px solid black;
  padding:10px 5px;
  }

.list dd {
  width:150px;
  text-align:center;
  padding:8px 5px;
  border-bottom:1px solid #ccc;
}

  .list dd.sub {
  text-align:center; padding-left:5px; width:410px;
}

#board .list-bot {
   clear: both;
   text-align:center;
   padding:10px 10px;
}

#writebt {
	margin-left: 790px;
	margin-top : 10px;
}

#notice {
	text-align:center;
border-bottom:10px 5px solid #ccc;
margin-top: 10px;

}

</style>

</head>
<body>
<%
List<pgDtos> list = (List<pgDtos>)request.getAttribute("list");

%>
<form action="PgController.do" method="post">
<div id="board">

<div id="title">
    <h3>l 게시판</h3>
</div>

<div class="list"> 

  <dl>
   <dt class="num">번호</dt>
   <dt class="sub">제목</dt>
   <dt class="name">작성자</dt>
   <dt class="data">작성일</dt>
   <dt class="count">조회수</dt>
   <dt class="count">좋아요</dt>
   
  </dl>
	<dl id="notice">공지</dl>
  <dl>
   <dd class="num">3</dd>
   <dd class="sub"><a href="#">월요일 입니다.</a></dd>
   <dd class="name">김민석</dd>
   <dd class="data">2000-10-10</dd>
   <dd class="count">1</dd>
   <dd class="count">1</dd>
   
  </dl>
  
  <dl>
   <dd class="num">2</dd>
   <dd class="sub"><a href="#">화요일 입니다.</a></dd>
   <dd class="name">김준면</dd>
   <dd class="data">2000-10-10</dd>
   <dd class="count">1</dd>
      <dd class="count">1</dd>
   
  </dl>

  <dl>
   <dd class="num">1</dd>
   <dd class="sub"><a href="#">수요일 입니다.</a></dd>
   <dd class="name">김종인</dd>
   <dd class="data">2000-10-10</dd>
   <dd class="count">1</dd>
      <dd class="count">1</dd>
   
  </dl>
  
  
  
  <p style="text-align:center">------------------------------------------------------------------------------------------------------------------------------------------------</p>
  <% for(int i=0; i<list.size(); i++) {
	  pgDtos dto = list.get(i);
	  %>
	  <dl>
	    <dd class="num"><%=dto.getFreenum() %></dd>
   <dd class="sub"><a href="PgController.do?command=boarddetail&seq=<%=dto.getFreenum()%>"><%=dto.getTitle() %></a></dd>
   <dd class="name"><%=dto.getNickname() %></dd>
   <dd class="data"><%=dto.getTime() %></dd>
   <dd class="count"><%=dto.getView1() %></dd>
   <dd class="count"><%=dto.getLike1() %></dd>
	  
	  
	  </dl>
<% 	  
  }
  %>
  
    <dl>
   <dd class="num">1</dd>
   <dd class="sub"><a href="#">수요일 입니다.</a></dd>
   <dd class="name">김종인</dd>
   <dd class="data">2000-10-10</dd>
   <dd class="count">1</dd>
   <dd class="count">1</dd>
   
  </dl>
</div>
<button type="button" id="writebt" onclick="locainsert()">글쓰기</button>

<div class="list-bot">
<p>
  <a href="#">◀</a>
  <a href="#">◁</a>
  <a href="#">1</a>
  <a href="#">2</a>
  <a href="#">3</a>
  <a href="#">4</a>
  <a href="#">5</a> 
  <a href="#">▷</a>
  <a href="#">▶</a>
</p>
</div>

<input type="button" value="위로가기"/>

<select>
<option value="아이디">아이디</option>
<option value="제목">제목</option>
<option value="제목+내용">제목+내용</option>
<option value="분류">분류</option>

</select>
<input type="text" size="20" placeholder="검색어 입력">
<input type="button" value="검색" />

<select>
<option value="10개씩보기">10개씩보기</option>
<option value="30개씩보기">30개씩보기</option>
<option value="50개씩보기">50개씩보기</option>


</select>
</div>
</form>
<script>
function locainsert() {
	alert("locainsert");
	location.href = "PgController.do?command=insertform";
	
}


</script>
</body>
</html>