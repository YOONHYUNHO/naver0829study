<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  // num 읽기
  String num = request.getParameter("num");
  // dao 선언
  SimpleBoardDao dao = new SimpleBoardDao();
  // delete 메서드 호출
  dao.deleteBoard(num);
  // list.jsp, redirect 이동
  response.sendRedirect("list.jsp");
%>