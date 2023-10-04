package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02_MysqlJdbc {
  // 2. mysql 드라이버 선언
  static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
  // 1. 생성자 생성
  public Ex02_MysqlJdbc() {
    try {
      Class.forName(MYSQL_DRIVER);
      //      System.out.println("성공");
    } catch (ClassNotFoundException e) {
      System.out.println("오류" + e.getMessage());
      e.printStackTrace();
    }

  }

  public void sawonAlldatas() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null; // SELECT일 경우에만 필요
    String sql = "select * from sawon order by num";
    try {
      conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
      //      System.out.println("연결 성공");
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql); 

      int total = 0;
      int cnt = 0;
      System.out.println("상품번호\t상품명\t가격\t색상");
      System.out.println("=".repeat(40));
      while(rs.next()) {
        String num = rs.getString("num");
        String name = rs.getString("name");
        int score = rs.getInt("score");
        String gender = rs.getString("gender");
        String buseo = rs.getString("buseo");
        cnt++;
        total += score;
        System.out.println(num + "\t" + name + "\t" + score + "\t" + gender
            + "\t" + buseo);
      }
      System.out.println("\n 총점수 : " + total);
      System.out.println("\n 평균 : " + total/cnt);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("연결 실패" + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        stmt.close();
        conn.close();
      } catch (SQLException|NullPointerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }

  public static void main(String[] args) {
    Ex02_MysqlJdbc ex = new Ex02_MysqlJdbc();
    ex.sawonAlldatas();
  }


}
