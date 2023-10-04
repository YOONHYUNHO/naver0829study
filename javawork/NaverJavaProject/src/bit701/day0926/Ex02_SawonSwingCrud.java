package bit701.day0926;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import db.DbConnect;

public class Ex02_SawonSwingCrud extends JFrame{
  JTextField tfName, tfScore;
  JComboBox<String> cbGender;
  JComboBox<String> cbBuseo;
  JTable table;
  DefaultTableModel tableModel;
  JButton btnAdd, btnDel, btnSearch, btnAll;

  DbConnect db = new DbConnect();

  public Ex02_SawonSwingCrud() {
    super("사원관리");
    this.setBounds(1000, 100, 500, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setDesign();
    this.setVisible(true);
  }
  private void setDesign() {

    // 상단
    tfName = new JTextField(4);
    tfScore = new JTextField(4);
    String[] cbTitle = {"여자", "남자"};
    cbGender = new JComboBox<String>(cbTitle);
    String[] cbDept = {"홍보부", "교육부", "총무부", "인사부", "화물팀"};
    cbBuseo = new JComboBox<String>(cbDept);
    JPanel pTop = new JPanel();
    pTop.add(new JLabel("이름"));
    pTop.add(tfName);
    pTop.add(new JLabel("점수"));
    pTop.add(tfScore);
    pTop.add(new JLabel("성별"));
    pTop.add(cbGender);
    pTop.add(new JLabel("부서"));
    pTop.add(cbBuseo);
    this.add("North", pTop);

    // 하단
    btnAdd = new JButton("추가");
    btnDel = new JButton("삭제");
    btnSearch = new JButton("검색");
    btnAll = new JButton("전체 조회");
    JPanel pBottom = new JPanel();
    pBottom.add(btnAdd);
    pBottom.add(btnDel);
    pBottom.add(btnSearch);
    pBottom.add(btnAll);


    // Center Table
    String[] title = {"번호", "이름", "점수", "성별", "부서" };
    tableModel = new DefaultTableModel(title, 0);
    table = new JTable(tableModel);
    this.add("Center", new JScrollPane(table));

    // 버튼 이벤트
    btnAdd.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // 데이터를 가져온다
        String name = tfName.getText();
        String score = tfScore.getText();
        String gender = (String)cbGender.getSelectedItem();
        String dept = (String)cbBuseo.getSelectedItem();
        if(name.length() == 0 || score.length() == 0) 
          return;
        // DB에 INSERT하는 메서드 호출
        insertsawon(name, score, gender, dept);
        // DB로부터 다시 데이터를 가져와서 출력
        sawonSelectAll();
        // 입력값 초기화
        tfName.setText("");
        tfScore.setText("");
      }
    });

    btnDel.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // 선택한 행 번호를 얻는다.
        int row = table.getSelectedRow();
        System.out.println(row); // 선택 x , -1 리턴
        if(row == -1) {
          JOptionPane.showMessageDialog(Ex02_SawonSwingCrud.this, "삭제할 행을 선택하세요");
        } else {
          // row행의 0번 열이 num값
          String num = table.getValueAt(row, 0).toString();
          deletesawon(num);
          // 삭제 후 데이터 다시 불러온다.
          sawonSelectAll();
        }


      }
    });

    // 전체 조회
    btnAll.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        sawonSelectAll();

      }
    });
    this.add("South", pBottom);

    btnSearch.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // 검색할 이름 입력받기
        String searchName = JOptionPane.showInputDialog("검색할 부서를 입력해주세요");
        //        System.out.println(searchName);
        if(searchName == null)
          return; // 취소 누를 경우 이벤트 종료
        else
          searchsawon(searchName); // 이름이 포함된 모든 데이터를 테이블에 출력
      }


    });


    // 초기 DB 데이터 가져오기
    sawonSelectAll();
  }
  public static void main(String[] args) {
    Ex02_SawonSwingCrud ex = new Ex02_SawonSwingCrud();
  }
  // DB METHOD
  public void sawonSelectAll() {
    // 기존 테이블의 데이터를 모두 삭제
    tableModel.setRowCount(0);

    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = """
            SELECT * FROM sawon
            ORDER BY buseo DESC
            """;
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Vector<String> data = new Vector<String>();
        String num = rs.getString("num");
        String name = rs.getString("name");
        String score = rs.getString("score");
        String gender = rs.getString("gender");
        String dept = rs.getString("buseo");


        // Vector에 순서대로 추가
        data.add(num);
        data.add(name);
        data.add(score);
        data.add(gender);
        data.add(dept);

        // 테이블에 추가
        tableModel.addRow(data);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }

  }
  // DB에 추가
  public void insertsawon(String name, String score, String gender, String dept) {
    //    System.out.println(name);
    //    System.out.println(phone);
    //    System.out.println(blood);
    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;
    String sql = """
            INSERT INTO sawon
            VALUES (null, ?, ?, ?, ?)
            """;
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, score);
      pstmt.setString(3, gender);
      pstmt.setString(4, dept);

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // DB 삭제
  public void deletesawon(String num) {
    //    System.out.println(num);
    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;

    String sql = """
            DELETE FROM sawon
            WHERE num = ?
            """;
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      int n = pstmt.executeUpdate();
      if(n == 0) 
        System.out.println("삭제할 멤버가 없습니다.");
      else
        System.out.println(n + "명의 사원이 삭제되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }



  }
  public void searchsawon(String searchName) {
    tableModel.setRowCount(0);

    Connection conn = db.getMysqlConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = """
            SELECT * FROM sawon
            WHERE buseo = ?
            """;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, searchName);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Vector<String> data = new Vector<String>();
        String num = rs.getString("num");
        String name = rs.getString("name");
        String score = rs.getString("score");
        String gender = rs.getString("gender");
        String dept = rs.getString("buseo");


        // Vector에 순서대로 추가
        data.add(num);
        data.add(name);
        data.add(score);
        data.add(gender);
        data.add(dept);

        // 테이블에 추가
        tableModel.addRow(data);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }


  }

}
