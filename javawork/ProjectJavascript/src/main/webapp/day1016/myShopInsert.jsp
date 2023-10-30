<%@page import="myshop.data.MyShopDao"%>
<%@page import="myshop.data.MyShopDto"%>
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
    // 한글 Encoding
    request.setCharacterEncoding("utf-8");
    // dao, dto선언
    MyShopDao dao = new MyShopDao();
    MyShopDto dto = new MyShopDto();
    // 입력 값을 읽어서 dto에 저장
    String item = request.getParameter("item");
    String photo = request.getParameter("photo");
    String color = request.getParameter("color");
    int price = Integer.parseInt(request.getParameter("price"));
    
    dto.setItem(item);
    dto.setPhoto(photo);
    dto.setColor(color);
    dto.setPrice(price);
    // Insert 메서드 호출(DB 저장)
    dao.insertShop(dto);
    // 목록 페이지로 이동(redirect)
    response.sendRedirect("myShop.jsp");
  %>
</body>
</html>