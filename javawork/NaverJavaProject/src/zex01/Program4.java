package zex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {
  static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

  public static void main(String[] args) throws ClassNotFoundException, SQLException {


    int id = 3;


    String sql = """
            DELETE NOTICE
            WHERE ID = ?
            """;

    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setInt(1, id);


    int result = pstmt.executeUpdate();
    System.out.println(result);


    pstmt.close();
    conn.close();

  }



}

