package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import db.DbConnect;

public class Ex09_StudentCrud {
  DbConnect db = new DbConnect();
  Scanner sc = new Scanner(System.in);

  public int getMenu() {
    System.out.println("1. 추가 2. 삭제 3. 수정 4. 출력 5. 검색 6. 종료");
    int menu = Integer.parseInt(sc.nextLine());
    return menu;
  }

  public void insertStudent() {
    System.out.println("이름");
    String name = sc.nextLine();
    System.out.println("혈액형");
    String blood = sc.nextLine();
    System.out.println("핸드폰 번호");
    String hp = sc.nextLine();

    String sql = """
            INSERT INTO student(name, blood, phone, writeday)
            VALUES(?, ?, ?, CURDATE())
            """;
    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, blood);
      pstmt.setString(3, hp);
      pstmt.execute();
      System.out.println("학생 추가 완료");
    } catch (SQLException e) {
      System.out.println("INSERT 실패" + e.getMessage());
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  public void deleteStudent() {
    System.out.println("삭제할 학생의 번호?");
    int num = Integer.parseInt(sc.nextLine());

    String sql = """
            DELETE FROM student
            WHERE num = ?
            """;
    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, num);
      int n = pstmt.executeUpdate();
      if(n == 0) 
        System.out.println("삭제할 학생이 없습니다.");
      else 
        System.out.println(num + "번 학생이 삭제되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  public void updateStudent() {
    System.out.println("수정할 학생의 번호?");
    int num = Integer.parseInt(sc.nextLine());
    System.out.println("수정할 이름");
    String name = sc.nextLine();
    System.out.println("수정할 혈액형");
    String blood = sc.nextLine();
    System.out.println("수정할 번호");
    String hp = sc.nextLine();
    System.out.println("수정할 날짜");
    String date = sc.nextLine();

    String sql = """
            UPDATE student SET
            name = ?,
            blood = ?,
            phone = ?,
            writeday = ?
            WHERE num = ?
            """;
    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, blood);
      pstmt.setString(3, hp);
      pstmt.setString(4, date);
      pstmt.setInt(5, num);
      int n = pstmt.executeUpdate();
      if(n == 0)
        System.out.println("변경할 학생의 번호가 없습니다.");
      else 
        System.out.println(n + "번 학생의 정보가 변경되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public void selectAllStudent() {
    System.out.println("번호\t이름\t혈액형\t휴대폰번호\t날짜");
    System.out.println("=".repeat(50));

    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = """
            SELECT * FROM student
            ORDER BY num
            """;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      while(rs.next()) {
        int num = rs.getInt("num");
        String name = rs.getString("name");
        String blood = rs.getString("blood");
        String phone = rs.getString("phone");
        Timestamp date = rs.getTimestamp("writeday");
        System.out.println(num + "\t" + name + "\t" +
            blood + "\t" + phone + "\t" + sdf.format(date));

      }



    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }
  }
  // 검색 - 번호 끝 4자리로 검색
  public void searchPhone() {
    System.out.println("번호\t이름\t혈액형\t휴대폰번호\t날짜");
    System.out.println("=".repeat(50));

    System.out.println("검색할 번호는?");
    String hp = sc.nextLine();

    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = """
            SELECT * FROM student
            WHERE phone LIKE '%' ?
            """;
    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, hp);
      rs = pstmt.executeQuery();

      System.out.println(hp + "검색 결과");

      int cnt = 0;
      while(rs.next()) {
        int num = rs.getInt("num");
        String name = rs.getString("name");
        String blood = rs.getString("blood");
        String phone = rs.getString("phone");
        String date = rs.getString("writeday");

        System.out.println(++cnt + "번" );
        System.out.println("번호 : " + num);
        System.out.println("이름 : " + name);
        System.out.println("혈액형 : " + phone);
        System.out.println("휴대폰번호 : " + phone);
        System.out.println("날짜 : " + date);
        System.out.println("-".repeat(50));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    Ex09_StudentCrud ex = new Ex09_StudentCrud();
    while(true) {

      System.out.println("=".repeat(50));
      int menu = ex.getMenu();
      System.out.println("=".repeat(50));

      switch(menu) {
        case 1: 
          ex.insertStudent();
          break;

        case 2: 
          ex.deleteStudent();
          break;

        case 3: 
          ex.updateStudent();
          break;

        case 4: 
          ex.selectAllStudent();
          break;

        case 5: 
          ex.searchPhone();
          break;

        default: 
          System.out.println("프로그램 종료");
          System.exit(0);
      }
    }

  }

}
