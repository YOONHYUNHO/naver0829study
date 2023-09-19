package bit701.day0918;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex02_Table extends JFrame{

  JTable table1;

  JTable table2;

  // 2. 생성자
  public Ex02_Table(String title)
  {
    // 4. 부모생성자
    super(title);
    this.setBounds(400, 100, 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 메서드
    this.setDesign();
    this.setVisible(true);
  }

  private void setDesign() {
    // 5. table 2개를 넣기 위해서 2행 1열로 레이아웃 변경
    this.setLayout(new GridLayout(2, 1));

    // 6. table 생성
    //    table1 = new JTable(5, 4); // 5행 4열의 빈 테이블 생성
    //    this.add(table1);

    // 7. 제목과 3개의 빈 행을 추가(Model을 이용)
    DefaultTableModel model = new DefaultTableModel
        (new String[] {"이름", "나이", "주소"},3); // 배열 선언 필수
    table1 = new JTable(model); 
    // 제목 출력 x -> this.add(table1);
    this.add(new JScrollPane(table1)); // scoroll이 가능하도록 만들어줘야 제목도 생성 가능

    // 8. table2에는 데이터 입력(데이터 추가는 불가)
    String[][] data = {
        {"권은비", "56", "강남구"},
        {"손흥민", "31", "여의도"},
        {"이강인", "22", "부평구"}
    };
    table2 = new JTable(data, new String[] {"이름", "나이", "주소"});
    this.add(new JScrollPane(table2));
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 3. 생성자 호출
    Ex02_Table ex = new Ex02_Table("JTable");
  }

}