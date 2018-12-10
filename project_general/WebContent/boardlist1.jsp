<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보드리스트ㅎㄴ</title>
<style>

* {
	width:1200px;
}
dt {
float : left;
}

#num,#id,#date,#likecount,#readcount {
width:150px;
}
#title {
	width:300px;
}


dt {
  
  width:150px;
  text-align:center;
  background-color:lightblue;
  border-bottom:2px solid black;
  padding:10px 5px;
}

.word {
float : left;
border-bottom:1px solid #ccc;
margin-top:0px;
}

dd {
  width:80px;
  text-align:center;
  float : left;
  margin-bottom:0px;
  }
  
  
  
  dl .sub,.data {
  width:200px;
  
  }
  
  div {
  margin-top:200px;
  padding-top:0px;
  margin-left:250px;
  }
  
  .sub {
  margin-left: 80px;
  }
  
  .name {
  margin-left: 50px;
  }
  
</style>
</head>
<body>
<h1>자유게시판</h1>

<div>
<dl>
<dt id="num">글번호</dt>
<dt id="title">제목</dt>
<dt id="id">아이디</dt>
<dt id="date">작성일</dt>
<dt id="likecount">좋아요</dt>
<dt id="readcount">조회수</dt>
</dl>

<dl class="word">
   <dd class="num">3</dd>
   <dd class="sub"><a href="#">월요일 입니다.</a></dd>
   <dd class="name">김민석</dd>
   <dd class="data">2000-10-10</dd>
   <dd class="likecount">1</dd>
   <dd class="count">1</dd>
  </dl>

<dl class="word">
   <dd class="num">3</dd>
   <dd class="sub"><a href="#">월요일 입니다.</a></dd>
   <dd class="name">김민석</dd>
   <dd class="data">2000-10-10</dd>
   <dd class="likecount">1</dd>
   <dd class="count">1</dd>
  </dl>
  
  <dl class="word">
   <dd class="num">3</dd>
   <dd class="sub"><a href="#">월요일 입니다.</a></dd>
   <dd class="name">김민석</dd>
   <dd class="data">2000-10-10</dd>
   <dd class="likecount">1</dd>
   <dd class="count">1</dd>
  </dl>
  
</div>


</body>
</html>