<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
  String cho = request.getParameter("cho");
  String sel = request.getParameter("sel");
 
  System.out.println(cho + " / " + sel);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

  function a(b){
    var cho = document.getElementById("cho").value;
    var sel;
 
    if(cho == "off"){
      alert("이미 투표를 하셨습니다.");

    }else{
      alert("당신이 선택한 그림은 " + b + "번 그림 입니다.");
      cho = "off";
      sel = b;
    }
    // alert(cho + " / " + sel);
 
    document.selPic.sel.value = sel;
    document.selPic.cho.value = cho;
    document.selPic.submit();
  }
</script>
</head>


<body>
  <form id='selPic' name='selPic' action='12_000.JSP' method="post">
    <input type='hidden' id='sel' name='sel' value=<%=sel%> />
    <input type='hidden' id='cho' name='cho' value = <%=cho%> />
  </form>
 
   1. <a href='javascript:a("1");' ><img src='http://shopping.phinf.naver.net/20160708_24/08aa487f-1c5d-4fad-94fa-1547c19b6017.jpg'></a>
  2. <a href='javascript:a("2");' ><img src='http://shopping.phinf.naver.net/20160707_3/ab81500c-f4a0-40ce-927b-75cbc13761c8.jpg'></a>
  3. <a href='javascript:a("3");' ><img src='http://shopping.phinf.naver.net/20160617_28/03070f7d-0b09-4ee4-817c-77dc5944ab67.jpg'></a>


</body>

</html>