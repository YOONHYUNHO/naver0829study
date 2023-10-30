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
<!-- 
     jsp에서 페이지 이동하는 방법
     1. forward : url 주소 변경 x , request, response등이 그대로 전달
     2. redirect : url 주소 변경 o , request, response등이 새로 생성, 전달 x 
 -->
 
 <%
  String code = "Bitcamp";
  // get 방식으로 전달
  response.sendRedirect("ex06_redirect.jsp?code=" + code +"&color=green");
 %>
</body>
</html>