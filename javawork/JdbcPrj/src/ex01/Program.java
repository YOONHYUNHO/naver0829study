package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {
  static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    String sql = """
            SELECT * FROM NOTICE
            """;

    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while(rs.next()) {
      int id = rs.getInt("id");
      String title = rs.getString("title");
      String writeId = rs.getString("writer_id");
      Date regDate = rs.getDate("regdate");
      String content = rs.getString("content");
      int hit = rs.getInt("hit");
      System.out.printf("id : %d, title : %s, writeid : %s, regDate : %s"
          + " content : %s, hit : %d\n ", id, title, writeId, regDate, content, hit);
    }
    rs.close();
    stmt.close();
    rs.close();

  }
}
