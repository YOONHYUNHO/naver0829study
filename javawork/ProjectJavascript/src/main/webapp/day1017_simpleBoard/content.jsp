<%@page import="simpleboard.data.AnswerBoardDao"%>
<%@page import="java.util.List"%>
<%@page import="simpleboard.data.AnswerBoardDto"%>
<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    span.day {
      font-size: 11px;
      color : gray;
    }
</style>
<script type="text/javascript">
  $(function() {
	  $("div.alist").hide(); // 처음에는 댓글 숨기기
	  
	  // 댓글 보이기 / 숨기기
	  $("h6.acount").click(function() {
		  $(this).next().slideToggle('fast');
	  });
	  
	  // 댓글 삭제
	  $(document).on("click", ".answerdel", function(){
		  let a = confirm("삭제하려면 [확인]을 눌러주세요");
		  if(a) {
			  // 태그에 넣어둔 idx, num 가져오기
			  let idx = $(this).attr("idx");
			  let num = $(this).attr("num");
			  // 댓글 삭제하는 파일로 이동
			  location.href = `answerdelete.jsp?idx=\${idx}&num=\${num}`;
		  }
	  });
  });
</script>
</head>
  <%
    // num 읽기
    String num = request.getParameter("num");
    // DAO 선언
    SimpleBoardDao dao = new SimpleBoardDao();
    // 조회수 증가
    dao.updateReadcount(num);
    // num에 해당하는 DTO 얻기
    SimpleBoardDto dto = dao.getData(num);
    // 날짜 출력 양식
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    // 댓글 가져오기
    AnswerBoardDao adao = new AnswerBoardDao();
    List<AnswerBoardDto> alist = adao.getBoardAnswers(num);
  %>
<body>
  <div style = "margin : 30px 50px">
    <table class = "table table-bordered" style = "width : 500px">
      <!-- 제목, 날짜, 작성자 -->
      <tr>
        
		      <h2><b><%=dto.getSubject() %></b></h2>
		      <span><b><%=dto.getWriter() %></b></span>
		      &nbsp;&nbsp;
		      <span class="day">
		        <%=sdf.format(dto.getWriteday()) %>
		        &nbsp;
		        조회&nbsp;<%=dto.getReadcount() %>
		      </span>
	       
	     </tr>
      <!-- 내용, 이미지 -->
      <tr height = "300" valign = "top">
        <td>
          <!-- 여러 줄일 경우 replace로 \n을 <br>로 변경 하거나 <pre> 태그로 출력 해야만 줄넘김이 된다. -->
          <%= dto.getContent().replace("\n", "<br>") %>
          <br><br>
          <%
            if(!dto.getPhoto().equals("no")) {
          %>
            <img src = "../save/<%= dto.getPhoto() %>" style = "max-width : 300px; border : 1px solid gray;">
          <%   
            }
          %>
        </td>
      </tr>
      <tr>
        <td>
          <h6 class = "acount" style = "cursor : pointer;">댓글<%= alist.size() %></h6>
          <div class = "alist" style = "margin-left : 20px">
            <%
              for(AnswerBoardDto adto:alist) {
            %>
              <b><%= adto.getNickname() %></b>
              : <span><%= adto.getContent() %></span>
              &nbsp;
              <span class = "day"><%= sdf.format(adto.getWriteday()) %></span>
              <!-- 삭제 아이콘 -->
              &nbsp;&nbsp;
              <i class="bi bi-trash answerdel" style = "cursor : pointer";
                idx = "<%= adto.getIdx() %>" num = "<%= num %>"></i>
              <br>
            <% 
              }
            %>
          </div>
        </td>
      </tr>
      <!-- 버튼 -->
      <tr>
        <td align = "center">
          <div style = "margin-bottom : 10px;">
            <form action = "./answerinsert.jsp" method = "post">
              <input type = "hidden" name = "num" value = "<%= num %>">
              <div class = "input-group" style = "width : 500px;">
                <input type = "text" name = "nickname" class = "form-control"
                style = "margin-left : 5px; width : 100px;" placeholder = "닉네임">
                <input type = "text" name = "content" class = "form-control"
                style = "margin-left : 5px; width : 300px;" placeholder = "댓글">
                
                <button type = "submit" class = "btn btn-sm btn-outline-success">저장</button>
              </div>
            </form>
          </div>
          <button type = "button" class = "btn btn-outline-success" style = "width : 100px;" onclick = "location.href = 'boardForm.jsp'">글쓰기</button>
          <button type = "button" class = "btn btn-outline-success" style = "width : 100px;" onclick = "location.href = 'list.jsp'">목록</button>
          <button type = "button" class = "btn btn-outline-success" style = "width : 100px;" onclick = "location.href = 'updateForm.jsp?num=<%= dto.getNum()%>'">수정</button>
          <button type = "button" class = "btn btn-outline-success" style = "width : 100px;" onclick = "location.href = 'boardDelete.jsp?num=<%= dto.getNum()%>'">삭제</button>
        </td>
      </tr>
    </table>  
  </div>
  
  
  
</body>
</html>










