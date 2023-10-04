package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01_OraclJdbc {
  // 2. 오라클 드라이버 선언
  static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
  static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
  // 1. 생성자 생성
  public Ex01_OraclJdbc() {
    try {
      Class.forName(ORACLE_DRIVER);
      System.out.println("성공");
    } catch (ClassNotFoundException e) {
      System.out.println("오류" + e.getMessage());
      e.printStackTrace();
    }

  }

  public void shopAllDatas() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null; // SELECT일 경우에만 필요
    String sql = "select * from shop order by sang_no";
    try {
      conn = DriverManager.getConnection(ORACLE_URL, "angel"  , "a1234");
      //      System.out.println("연결 성공");
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql); // SELECT문은 무조건 executeQuery, 반환타입이 ResultSet


      System.out.println("상품번호\t상품명\t가격\t색상");
      System.out.println("=".repeat(40));
      int total = 0;
      // rs.next() : 다음 데이터로 이동 하고 true를 반환, 없을 경우 false 반환
      while(rs.next()) {
        // 데이터를 가져올때 인덱스로 가져오거나 컬럼명으로 가져온다.
        /* 1. 인덱스
        String no = rs.getString(1);
        String name = rs.getString(2);
        int price = rs.getInt(3);
        String color = rs.getString(4); */

        // 2. 컬럼
        String no = rs.getString("sang_no");
        String name = rs.getString("sang_name");
        int price = rs.getInt("sang_price");
        String color = rs.getString("sang_color");

        total += price;

        System.out.println(no + "\t" + name + "\t" + price + "\t" + color);
      }
      System.out.println("\n 총금액 :" + total);

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
    Ex01_OraclJdbc ex = new Ex01_OraclJdbc();
    ex.shopAllDatas();
  }


}
