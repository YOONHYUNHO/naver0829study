<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="javax.swing.DefaultBoundedRangeModel"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<% 
  MultipartRequest multipartRequest = null;
  // 업로드 경로
  String realPath = getServletContext().getRealPath("/save");
  System.out.println("path = " + realPath);
  // 업로드 사이즈
  int uploadSize = 1024 * 1024 * 5; // 5mb
      

  try { 
    multipartRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
    
    // DAO, DTO 선언
    SimpleBoardDto dto = new SimpleBoardDto();
    SimpleBoardDao dao = new SimpleBoardDao();
    // 데이터 읽기
    String writer = multipartRequest.getParameter("writer");
    String subject = multipartRequest.getParameter("subject");
    String content = multipartRequest.getParameter("content");
    // 업로드된 실제 파일명, 업로드 안했을 경우 null
    String photo = multipartRequest.getFilesystemName("upload");
    // null일 경우 "no"라고 저장
    if(photo == null) 
      photo = "no";
    
    // DTO에 넣기
    dto.setWriter(writer);
    dto.setSubject(subject);
    dto.setContent(content);
    dto.setPhoto(photo);
    // INSERT 메서드 호출
    dao.insertBoard(dto);
    // list.jsp로 이동
    response.sendRedirect("list.jsp");
    
    
  } catch(Exception e) {
    out.print("<h3>파일 업로드 오류 발생 : " + e.getMessage() + "</h3>");
  }
%>























