package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import db.DbConnect;

public class Ex06_MysqlSawonUpdate {

  DbConnect db = new DbConnect();

  public void empUpdate() {
    Scanner sc = new Scanner(System.in);
    System.out.println("수정할 번호?");
    String num = sc.nextLine();
    System.out.println("수정할 이름");
    String name = sc.nextLine();
    System.out.println("수정할 점수");
    int score = Integer.parseInt(sc.nextLine());
    System.out.println("수정할 부서");
    String dept = sc.nextLine();

    String sql = "UPDATE sawon SET name = '"+name+"', score = "+score+", buseo = '"+dept+"' where num = " + num;
    System.out.println(sql);

    Connection conn = null;
    Statement stmt = null;

    conn = db.getMysqlConnection();
    try {
      stmt = conn.createStatement();
      int n = stmt.executeUpdate(sql);
      if(n == 0) 
        System.out.println("번호가 없습니다.");
      else 
        System.out.println("수정 완료");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("UPDATE sql문 오류" + e.getMessage());
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  public static void main(String[] args) {
    Ex06_MysqlSawonUpdate ex = new Ex06_MysqlSawonUpdate();
    ex.empUpdate();
  }

}
