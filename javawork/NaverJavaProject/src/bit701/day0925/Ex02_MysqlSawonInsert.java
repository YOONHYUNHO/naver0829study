package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import db.DbConnect;

public class Ex02_MysqlSawonInsert {
  DbConnect db = new DbConnect();

  public void sawonInsert() {
    Scanner sc = new Scanner(System.in);

    System.out.println("이름");
    String name = sc.nextLine();

    System.out.println("1- 100사이 점수");
    int score = Integer.parseInt(sc.nextLine());

    System.out.println("성별");
    String gender = sc.nextLine();

    System.out.println("부서");
    String buseo = sc.nextLine();

    String sql = "INSERT INTO sawon Values(null, '"+ name +"', "+score+", '"+gender+"', '"+buseo+"' )" ;
    System.out.println(sql);

    Connection conn = null;
    Statement stmt = null;

    conn = db.getMysqlConnection();

    try {
      stmt = conn.createStatement();
      stmt.execute(sql);
      System.out.println("데이터 추가 완료");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("Insert sql문 오류" + e.getMessage());
    } finally {
      db.dbClose(stmt, conn);
    }
  }


  public static void main(String[] args) {
    Ex02_MysqlSawonInsert ex = new Ex02_MysqlSawonInsert();
    ex.sawonInsert();
  }
}
