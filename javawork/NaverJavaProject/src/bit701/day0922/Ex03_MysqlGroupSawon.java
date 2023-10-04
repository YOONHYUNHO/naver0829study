package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex03_MysqlGroupSawon {

  static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

  public Ex03_MysqlGroupSawon() {
    try {
      Class.forName(MYSQL_DRIVER);
      //      System.out.println("성공");
    } catch (ClassNotFoundException e) {
      System.out.println("오류" + e.getMessage());
      e.printStackTrace();
    }
  }

  private void sawonBunseok() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = "SELECT buseo, count(*) count, max(score) maxscore, min(score) minscore,\n"
        + " avg(score) avgscore\n"
        + "FROM sawon GROUP BY buseo;";
    try {
      conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      int cnt = 0;
      int total = 0;
      System.out.println("부서\tcount\tmaxscore\tminscore\tavgscore");
      System.out.println("=".repeat(40));
      while(rs.next()) {
        String dept = rs.getString("buseo");
        int count = rs.getInt("count");
        int max = rs.getInt("maxscore");
        int min = rs.getInt("minscore");
        double avg = rs.getDouble("avgscore");

        System.out.println(dept + "\t" + count + "\t" + max + "\t" + min
            + "\t" + avg);
      }


    } catch (SQLException e) {
      // TODO Auto-generated catch block
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
    Ex03_MysqlGroupSawon ex = new Ex03_MysqlGroupSawon();
    ex.sawonBunseok();
  }

}
