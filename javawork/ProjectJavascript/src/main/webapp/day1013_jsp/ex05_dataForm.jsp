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
  <h5>폼 태그 action 읽기</h5>
  <form action="./ex05_dataRead.jsp" method="get">
    이름 : <input type = "text" name = "irum"><br>
    페이지 번호 : <input type = "number" name = "currentPage" value = "1"><br>
    메세지 : <input type = "text" name = "message"><br>
    <button type = "submit"j>서버로 전송</button>
  </form>
</body>
</html>