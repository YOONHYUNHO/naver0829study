package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {
  static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    String title = "TEST2";
    String writerId = "newlec";
    String content = "hahaha";
    String files = "";


    String sql = """
            INSERT INTO notice (
              title,
              writer_id,
              content,
              files
            ) VALUES (
              ?,?,?,?
            )
            """;

    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setString(1, title);
    pstmt.setString(2, writerId);
    pstmt.setString(3, content);
    pstmt.setString(4, files);

    int result = pstmt.executeUpdate();
    System.out.println(result);


    pstmt.close();
    conn.close();

  }



}

