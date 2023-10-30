package simpleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DbConnect;

public class SimpleBoardDao {
  DbConnect db = new DbConnect();

  // 목록
  public List<SimpleBoardDto> getAllList() {
    List<SimpleBoardDto> list = new Vector<SimpleBoardDto>();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = """
                SELECT * FROM simpleboard 
                ORDER BY num DESC
            """;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()) {
        SimpleBoardDto dto = new SimpleBoardDto();
        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setPhoto(rs.getString("photo"));
        dto.setReadcount(rs.getInt("readcount"));
        dto.setWriteday(rs.getTimestamp("writeday"));

        list.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }


    return list;
  }


  // INSERT
  public void insertBoard(SimpleBoardDto dto) {
    String sql = """
            INSERT INTO simpleboard
            (writer, subject, content, photo, writeday)
            values(?, ?, ?, ?, now()) 
            """;
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getPhoto());

      pstmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  // 내용 보기
  public SimpleBoardDto getData(String num) {
    SimpleBoardDto dto = new SimpleBoardDto();
    String sql = """
              SELECT * FROM simpleboard
              WHERE num = ?
            """;
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      rs = pstmt.executeQuery();

      if(rs.next()) {
        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setPhoto(rs.getString("photo"));
        dto.setReadcount(rs.getInt("readcount"));
        dto.setWriteday(rs.getTimestamp("writeday"));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }


    return dto;
  }

  // 조회수 증가
  public void updateReadcount(String num) {
    String sql = """
              UPDATE simpleboard
              SET readcount = readcount + 1 WHERE num = ?;
            """;
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  // DELETE
  public void deleteBoard(String num) {
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;

    String sql = """
              DELETE FROM simpleboard
              WHERE num = ?
            """;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }


  // UPDATE
  public void updateBoard(SimpleBoardDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;

    String sql = "";
    // 사진은 수정하지 않았을경우 null 값을 가진다 null 아닐 경우에만 photo를 수정
    if(dto.getPhoto() == null) {
      // 사진 수정 x
      sql = """
              UPDATE simpleboard
              SET writer = ? , subject = ?, content = ?
              WHERE num = ?
              """;
    } else {
      // 사진 수정 o
      sql = """
              UPDATE simpleboard 
              SET writer = ?, subject = ?, content = ?, photo = '#1'
              WHERE num = ?
              """.replace("#1", dto.getPhoto());
    }


    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getNum());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }
}
