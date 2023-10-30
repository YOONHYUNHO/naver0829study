package simpleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DbConnect;

public class AnswerBoardDao {
  DbConnect db = new DbConnect();

  public void insertAnswer(AnswerBoardDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    String sql = """
              insert into 
              answersboard
              values(null, ?, ?, ?, now());
            """;

    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, dto.getNum());
      pstmt.setString(2, dto.getNickname());
      pstmt.setString(3, dto.getContent());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {

      db.dbClose(pstmt, conn);
    }

  }

  public void deleteAnswer(String idx) {
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    String sql = """
              delete from answersboard where idx = ?
            """;

    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, idx);

      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  public List<AnswerBoardDto> getBoardAnswers(String num) {
    List<AnswerBoardDto> list = new Vector<AnswerBoardDto>();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = """
              select * from answersboard where num = ?
            """;

    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, num);

      rs = pstmt.executeQuery();

      while(rs.next()) {
        AnswerBoardDto dto = new AnswerBoardDto();
        dto.setIdx(rs.getString("idx"));
        dto.setNum(rs.getString("num"));
        dto.setNickname(rs.getString("nickname"));
        dto.setContent(rs.getString("content"));
        dto.setWriteday(rs.getTimestamp("writeday"));

        list.add(dto);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }

    return list;
  }
}
