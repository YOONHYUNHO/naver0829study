<%@page import="data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
</style>
</head>
<body>
<!-- jsp에서 페이지 이동하는 방법
     1. forward : url 주소 변경 x , request, response등이 그대로 전달
     2. redirect : url 주소 변경 o , request, response등이 새로 생성, 전달 x 
 -->

<h3 class = "alter alter-danger">ex02_forward 파일</h3>
 
<%
  // ex1에서 request에 저장해둔 데이터를 가져오기
  String msg = (String)request.getAttribute("msg");
  List<ShopDto> list = (List<ShopDto>)request.getAttribute("list");
%>
<h2>ex01에서 저장해둔 msg : <%= msg %></h2>
<h2>ex01에서 저장해둔 ShopDto List</h2>
<%
  for(ShopDto dto : list) {
%>    
  <h4>상품명 : <%=dto.getItem() %></h4>
  <h4>상품명 : <%=dto.getPrice() %></h4>
  <hr>
<%
  }
%>





</body>
</html>