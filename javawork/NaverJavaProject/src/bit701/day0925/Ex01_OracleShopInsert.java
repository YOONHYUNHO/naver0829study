package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import db.DbConnect;

public class Ex01_OracleShopInsert {
  DbConnect db = new DbConnect();

  public void shopInsert() {
    Scanner sc = new Scanner(System.in);
    System.out.println("상품명 입력");
    String sang = sc.nextLine();

    System.out.println("가격 입력");
    int price = Integer.parseInt(sc.nextLine()); 

    System.out.println("색상 입력");
    String color = sc.nextLine();

    String sql = "Insert INTO shop VALUES(seq_shop.nextval, '"+ sang +"', "+price+", '"+color+"')";
    System.out.println(sql);

    Connection conn = null;
    Statement stmt = null;

    // db 연결
    conn = db.getOracleConnection();
    // statement
    try {
      stmt = conn.createStatement();
      // 실행
      //      boolean b = stmt.execute(sql);
      //      int n = stmt.executeUpdate(sql); // 반환 타입이 int : sql문을 성공한 갯수
      //      System.out.println(b + ", " + n);
      stmt.execute(sql);
      System.out.println("데이터 추가 완료");
    } catch (SQLException e) {
      System.out.println("Insert sql문 오류" + e.getMessage());
    } finally {
      db.dbClose(stmt, conn);
    }

  }
  public static void main(String[] args) {
    Ex01_OracleShopInsert ex = new Ex01_OracleShopInsert();
    ex.shopInsert();
  }

}






























