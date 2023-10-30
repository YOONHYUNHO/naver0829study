<%@page import="simpleboard.data.AnswerBoardDto"%>
<%@page import="simpleboard.data.AnswerBoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
    
    thead th {
      text-align: center;
    }
    a:link {
     text-decoration : none;
     color : black;
    }
    /* 한 번이라도 클릭한 글에만 적용 */
    a:visited {
      text-decoration : none;
      color : gray;
    }
    a:hover {
      text-decoration : underline;
      color : blue;
    }
    .photoIcon {
      font-size : 0.8em;
      color : gray;
    }
</style>
</head>
<%
  // DAO 선언
  SimpleBoardDao dao = new SimpleBoardDao();
  // 전체 데이터 가져오기
  List<SimpleBoardDto> list = dao.getAllList();
  // 날짜 형식
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
  // 댓글 dao 선언
  AnswerBoardDao adao = new AnswerBoardDao();
 
%>
<body>
  <div style = "margin : 30px 50px">
    <button type = "button" class = "btn btn-success btn-sm" onclick = "location.href = 'boardForm.jsp'">글쓰기</button>
    <br>
    <h5>총 <%= list.size() %>개의 게시글이 있습니다.</h5>
    <br>
    <table class = "table table-striped" style = "width : 600px;">
      <thead>
        <th width = "50">번호</th>
        <th width = "300">제목</th>
        <th width = "80">작성자</th>
        <th width = "100">작성일</th>
        <th width = "70">조회</th>
      </thead>
      <tbody>
        <%
          if(list.size() == 0) {
        %>
          <tr height = "50">
            <td colspan = "5" align = "center">
              <h5>등록된 글이 없습니다.</h5>
            </td>
          </tr>
        <%   
          } else {
          // 게시글 일련번호
          int n = 0;
          for(SimpleBoardDto dto : list) {
            // 댓글 갯수 가져오기
            int acount = adao.getBoardAnswers(dto.getNum()).size();
            // dto에 저장
            dto.setAnswercount(acount);
        %>
            <tr align = "center">
              <td><%= list.size() - n++ %></td>
              <td align = "left">
                <!-- 해당 글에 대한 num 값을 같이 전달 -->
                <a href = "content.jsp?num=<%=dto.getNum() %>">
                  <%= dto.getSubject() %>
                  <%
                    if(!dto.getPhoto().equals("no")) {
                  %>
                      <i class="bi bi-image photoIcon"></i>
                  <%   
                    }
                  if(acount > 0) {
                  %>
                   &nbsp;
                   <span style = "color : red">(<%= dto.getAnswercount() %>)</span>
                  <%
                  }
                  %>
                </a>
              </td>
              <td><%= dto.getWriter() %></td>
              <td><%= sdf.format(dto.getWriteday()) %></td>
              <td><%= dto.getReadcount() %></td>
            </tr>
        <%
          }
        %>
        <% 
          }
        %>
      </tbody>
    </table>
  </div>
</body>
</html>