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
  <form action="ex09_examRead.jsp" method = "post">
	  <h5>form read</h5>
	  <h6>테두리선 종류를 선택해주세요</h6>
	  <label>
	    <input type = "radio" name = "line" value = "10px solid tomato">실선
	  </label>
	  <label>
	    <input type = "radio" name = "line" value = "10px dotted tomato">점선
	  </label>
	  <label>
	    <input type = "radio" name = "line" value = "10px double tomato">Double
	  </label>
	  <label>
	    <input type = "radio" name = "line" value = "10px groove tomato">Groove
	  </label>
	  <h5>사진 선택</h5>
	  <select name = "img" class = "form-select" style = "width : 120px">
	   <option  value = "../sport/1.jpg">캉테</option>
	   <option  value = "../sport/2.jpg">홀란드</option>
	   <option  value = "../sport/3.jpg">음바페</option>
	   <option  value = "../sport/4.jpg">손흥민</option>
	   <option  value = "../sport/6.jpg">권은비</option>
	  </select>
	  <br>
	  <h5>날짜를 선택해주세요</h5>
	  <input type = "date" name = "today" value = "2023-10-13"><br><br>
	  <button type = "submit">전송</button>
  </form>
</body>
</html>