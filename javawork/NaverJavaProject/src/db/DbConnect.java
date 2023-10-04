package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
  static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

  static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
  static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

  public DbConnect() {
    // 1. Class.forName(MYSQL_DRIVER) -> try/catch
    try {
      Class.forName(MYSQL_DRIVER);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      System.out.println("Mysql 드라이버 오류" + e.getMessage());    
    }

    try {
      Class.forName(ORACLE_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println("Oracle 드라이버 오류" + e.getMessage());    
    }  
  }

  //Mysql 연결
  public Connection getMysqlConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("Mysql 연결 실패" + e.getMessage());
    }
    return conn;
  }

  // Oracle 연결
  public Connection getOracleConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("Oracle 연결 실패" + e.getMessage());
    }
    return conn;
  }

  //Close() #1
  public void dbClose(Statement stmt, Connection conn) {
    try {
      stmt.close();
      conn.close();
    } catch (SQLException| NullPointerException e) {
      System.out.println("close 오류" + e.getMessage());
      // TODO: handle exception
    }
  }

  //Close() #2
  public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
    try {
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException| NullPointerException e) {
      System.out.println("close 오류" + e.getMessage());
      // TODO: handle exception
    }
  }

  //Close() #3
  public void dbClose(PreparedStatement pstmt, Connection conn) {
    try {
      pstmt.close();
      conn.close();
    } catch (SQLException| NullPointerException e) {
      System.out.println("close 오류" + e.getMessage());
      // TODO: handle exception
    }
  }

  //Close() #4
  public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
    try {
      rs.close();
      pstmt.close();
      conn.close();
    } catch (SQLException| NullPointerException e) {
      System.out.println("close 오류" + e.getMessage());
      // TODO: handle exception
    }
  }

}
