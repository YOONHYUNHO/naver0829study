<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyShopDao"%>
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
<%
  String num = request.getParameter("num");
  
  // dao 선언
  MyShopDao dao = new MyShopDao();
  // dtom 얻기
  MyShopDto dto = dao.getItems(num);
  // 날짜 출력 양식
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm");
%>
<body>
  <div style = "margin : 30px 50px">
    <h4><b><%= dto.getItem() %></b></h4>
    <br>
    <img src = "../shop/<%= dto.getPhoto() %>" style = "width : 300px; border : 5px inset gray;" align = left hspace = 20>
    <br><br><br><br>
    색상 : <b style = "background-color : <%= dto.getColor() %>"><%= dto.getColor() %></b>
    <br><br>
    가격 : <%= dto.getPrice()%>원
    <br><br>
    등록일 : <%= sdf.format(dto.getWriteDay()) %>
  </div>
  <div class = "buttons">
    <button type = "button" class = "btn btn-outline-secondary" onclick = "location.href = 'myShopUpdateform.jsp?num=<%=dto.getNum() %>'">수정</button>
    <button type = "button" class = "btn btn-outline-secondary" onclick = "location.href = 'myShopDelete.jsp?num=<%=dto.getNum() %>'">삭제</button>
    <button type = "button" class = "btn btn-outline-secondary" onclick = "location.href = 'myShop.jsp'">목록</button>
  </div>
  
  
  
  
  
  
</body>
</html>