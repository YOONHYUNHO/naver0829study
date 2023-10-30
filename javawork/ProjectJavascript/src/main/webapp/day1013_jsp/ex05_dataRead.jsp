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
  <%
    // get 방식 form data 읽기
    String irum = request.getParameter("irum"); // 태그 name에 입력한 값을 문자열 형식으로 반환
    String currentPage = request.getParameter("currentPage");
    String message = request.getParameter("message");
  %>
</body>

  <h5>form에 출력</h5>
  <pre style = "font-size : 2em">
    이름 : <%= irum %>
    페이지번호 : <%= currentPage %>
    메세지 : <%= message %>
  </pre>
</html>