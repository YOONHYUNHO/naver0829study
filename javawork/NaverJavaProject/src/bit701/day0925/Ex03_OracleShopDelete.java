package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import db.DbConnect;

public class Ex03_OracleShopDelete {
  DbConnect db = new DbConnect();

  public void shopDelete() {
    Scanner sc = new Scanner(System.in);
    System.out.println("삭제 할 상품명 입력");

    String sang = sc.nextLine();
    String sql = "Delete from shop WHERE sang_name = '"+sang+"'";
    System.out.println(sql);

    Connection conn = null;
    Statement stmt = null;

    conn = db.getOracleConnection();
    try {

      stmt = conn.createStatement();
      // 성공적으로 삭제된 레코드의 수 반환
      int n = stmt.executeUpdate(sql);

      if(n == 0) 
        System.out.println(sang + "상품은 목록에 없습니다.");
      else
        System.out.println("총 " + n + "개의 "+ sang + " 상품을 삭제했습니다."); 
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("DELETE sql문 오류" + e.getMessage());

    } finally {
      db.dbClose(stmt, conn);
    }
  }
  public static void main(String[] args) {
    Ex03_OracleShopDelete ex = new Ex03_OracleShopDelete();
    ex.shopDelete();
  }

}
