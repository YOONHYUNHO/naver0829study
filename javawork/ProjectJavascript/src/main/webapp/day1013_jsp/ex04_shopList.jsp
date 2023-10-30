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
    div.box {
      width : 50px;
      height : 50px;
      border : 1px solid black;
    }
    img.photo {
      width : 80px;
      height : 100px
      border : 1px solid black;
    }
</style>
</head>
<body>
  <%
    List<ShopDto> list = new Vector<>();
    list.add(new ShopDto("플렛슈즈", "14", 23000, "orange"));
    list.add(new ShopDto("머리끈", "26", 8000, "darkorange"));
    list.add(new ShopDto("머리띠", "30", 15000, "skyblue"));
    list.add(new ShopDto("스카프", "10", 59000, "magenta"));
    list.add(new ShopDto("자켓", "31", 23000, "white"));
    
  %>
  
  <table class = "table table-bordered" style = "width : 500px;">
    <tr>
      <th width = 70>번 호</th>
      <th width = 150>상품명</th>
      <th width = 100>가 격</th>
      <th width = 140>사 진</th>
      <th>색 상</th>
    </tr>
  <%
    int n = 0;
    for(ShopDto dto:list) {
  %>
    <tr>
      <td><%= ++n %></td>
      <td><%= dto.getItem() %></td>
      <td><%= dto.getPrice() %></td>
      <td align = center><img class ="photo" src = "../shop/<%= dto.getPhoto()  %>.jpg"></td>
      <td><div class = "box" style = "background-color : <%= dto.getColor() %>"></div></td>
    </tr>
  <% 
    }
  %>  
  </table>
</body>
</html>