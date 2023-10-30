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
  request.setCharacterEncoding("utf-8");
  String name = request.getParameter("name");
  String java = request.getParameter("java");
  String jsp = request.getParameter("jsp");
  String spring = request.getParameter("spring");
  String[] hp1 = request.getParameterValues("hp1");
  String hp2 = request.getParameter("hp2");
  String tcolor = request.getParameter("tcolor");
  String bcolor = request.getParameter("bcolor");
  
  // 점수 계산
  int sum = 0;
  double avg = 0;
  try {
	  sum = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
	  avg = sum / 3.0;
  } catch(NumberFormatException e) {
    sum = 0;
    avg = 0;
  }
%>
<body>
  <div style = "font-size : 22px; color : <%=tcolor %>; background-color : <%=bcolor%>; width : 500px;">
	  이름 : <b><%= name %></b><br>
	  <b>
	   java : <%= java %>&nbsp;&nbsp; jsp : <%=jsp %> &nbsp;&nbsp; spring : <%=spring %><br>
	   sum : <%=sum %> &nbsp;&nbsp; avg : <%=avg %>
	  </b>
	  
		<div style = "display : none"><%= hp1 == null ? 0 : hp1.length %></div> <br>
	  <%
	    if(hp1 != null) {
	     for(int i = 0; i < hp1.length; i++) {
	  %>
	      <b>핸드폰 : <%= hp1[i] %>-<%= hp2 %></b>
	  <%    
	     }
	    }
	  %>    
  </div>




</body>
</html>