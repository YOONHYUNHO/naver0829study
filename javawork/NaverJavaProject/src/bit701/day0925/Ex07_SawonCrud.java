package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import db.DbConnect;

public class Ex07_SawonCrud {
  // 1. DB, SCANNER 선언
  DbConnect db = new DbConnect();
  Scanner sc = new Scanner(System.in);

  public void selectAll() {
    System.out.println("번호\t사원명\t점수\t성별\t부서");
    System.out.println("=".repeat(50));

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = """
            SELECT * FROM sawon
            ORDER BY num
            """;
    conn = db.getMysqlConnection();
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()) {
        int num = rs.getInt("num");
        String name = rs.getString("name");
        int score = rs.getInt("score");
        String gender = rs.getString("gender");
        String dept = rs.getString("buseo");
        System.out.println(num +"\t" + name + "\t" + score + "\t" + gender + "\t" + dept);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }

  }

  public void InsertEmp() {
    System.out.println("이름");
    String name = sc.nextLine();

    System.out.println("1- 100사이 점수");
    int score = Integer.parseInt(sc.nextLine());

    System.out.println("성별");
    String gender = sc.nextLine();

    System.out.println("부서");
    String buseo = sc.nextLine();

    String sql = "INSERT INTO sawon (name, score, gender, buseo) VALUES(?, ?, ?, ?)";

    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql); // pstmt 생성 시 sql 검사
      // ? 갯수만큼 값을 넣어준다
      pstmt.setString(1, name);
      pstmt.setInt(2, score);
      pstmt.setString(3, gender);
      pstmt.setString(4, buseo);
      // 실행
      pstmt.execute(); // 주의 sql문을 값으로 넣지 않음
      System.out.println("사원정보를 추가하였습니다.");
    } catch (SQLException e) {
      System.out.println("INSERT sql문 오류" + e.getMessage());
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  public void DeleteEmp() {
    System.out.println("삭제할 사원의 이름은?");
    String name = sc.nextLine();
    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;

    String sql = 
            """
            DELETE FROM sawon
            WHERE name =?
            """;
    try {
      pstmt = conn.prepareStatement(sql);
      // ? 갯수만큼 바인딩
      pstmt.setString(1, name);
      // 삭제된 인원을 알고 싶을 경우 executeUpdate
      int n = pstmt.executeUpdate();

      if(n == 0) 
        System.out.println("삭제할 사원이 없습니다.");
      else
        System.out.println(n + "명 삭제되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  public void UpdateEmp() {
    System.out.println("수정할 사원의 번호는?");
    int num = Integer.parseInt(sc.nextLine());
    System.out.println("수정할 사원 이름은?");
    String name = sc.nextLine();
    System.out.println("수정할 점수는?");
    int score = Integer.parseInt(sc.nextLine());
    System.out.println("수정할 부서는");
    String dept = sc.nextLine();
    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;

    String sql = 
            """
            UPDATE sawon SET
            name = ?,
            score = ?,
            buseo = ?
            WHERE num = ?
            """;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setInt(2, score);
      pstmt.setString(3, dept);
      pstmt.setInt(4, num);

      int n = pstmt.executeUpdate();
      if(n == 0) 
        System.out.println("수정할 인원이 없습니다.");
      else
        System.out.println("수정했습니다.");

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }
  public int getMenu() {
    // 2. 메뉴
    int menu = 0;
    System.out.println("1. 추가 2. 삭제 3. 수정 4. 조회 5. 종료");
    menu = Integer.parseInt(sc.nextLine());
    return menu;
  }

  public static void main(String[] args) {

    Ex07_SawonCrud ex = new Ex07_SawonCrud();

    // 3. 
    while(true) {
      int menu = ex.getMenu();
      switch(menu) {
        case 1:
          ex.InsertEmp();
          break;
        case 2:
          ex.DeleteEmp();
          break;
        case 3:
          ex.UpdateEmp();
          break;
        case 4:
          ex.selectAll();
        default:
          System.out.println("시스템을 종료합니다.");
          System.exit(0);
      }
      System.out.println("-".repeat(30));
    }
  }

}
