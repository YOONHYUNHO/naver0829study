package zex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {
  static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    String title = "TEST2";
    String content = "hahaha";
    String files = "";
    int id = 3;


    String sql = """
            UPDATE NOTICE
            SET
            TITLE = ?,
            CONTENT = ?,
            FILES = ?
            WHERE ID = ?
            """;

    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setString(1, title);
    pstmt.setString(2, content);
    pstmt.setString(3, files);
    pstmt.setInt(4, id);

    int result = pstmt.executeUpdate();
    System.out.println(result);


    pstmt.close();
    conn.close();

  }



}

