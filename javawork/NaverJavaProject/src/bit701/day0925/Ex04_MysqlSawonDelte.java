package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import db.DbConnect;

public class Ex04_MysqlSawonDelte {

  DbConnect db = new DbConnect();

  public void empDelete() {
    Scanner sc = new Scanner(System.in);
    System.out.println("삭제할 사원 이름");
    String name = sc.nextLine();

    String sql = "Delete FROM sawon WHERE name = '"+name+"'";
    System.out.println(sql);

    Connection conn = null;
    Statement stmt = null;

    conn = db.getMysqlConnection();
    try {
      stmt = conn.createStatement();
      int n = stmt.executeUpdate(sql);
      if(n == 0)
        System.out.println(name + "님은 없습니다.");
      else
        System.out.println("총 " + n + "명의 사원 정보를 삭제했습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("DELETE sql문 오류" + e.getMessage());
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  public static void main(String[] args) {
    Ex04_MysqlSawonDelte ex = new Ex04_MysqlSawonDelte();
    ex.empDelete();
  }

}
