package bit701.day0918;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex03_TableFile extends JFrame{

  // 1. 변수 선언
  JTable table;
  DefaultTableModel model;
  JTextField tfName, tfAge, tfAddr;
  JButton btnAdd;

  // 5. 파일 이름
  final static String FILENAME = "C:\\naver0829study\\javawork\\NaverJavaProject\\member.txt";

  public Ex03_TableFile(String title) {
    super(title); // Jframe의 문자열을 받는 생성자 호출
    this.setLocation(300, 100); // 프레임의 시작위치
    this.setSize(400, 300); // 프레임의 너비, 높이

    // 디자인이나 이벤트를 구현 할 메서드 호출
    this.setDesign();
    this.setVisible(true); // true : 프레임 보이기 , false : 숨기기

    // 윈도우 이벤트 발생(Frame) WindowAdapter - 익명 내부클래스
    this.addWindowListener(new WindowAdapter() {

      // Window의 x버튼 클릭 시 호출 메서드
      @Override
      public void windowClosing(WindowEvent e) {
        // 6. 종료 전에 테이블의 내용을 member.txt에 추가 
        FileWriter fw = null; // 저장

        try {
          // 7. 기존 파일에 추가(없을 경우 새로 생성)
          fw = new FileWriter(FILENAME, true); 
          // 8. 행 갯수로 확인
          int row = table.getRowCount();
          for(int i = 0; i < row; i++)
          {
            String name = (String) model.getValueAt(i, 0);
            String age = (String) model.getValueAt(i, 1);
            String addr = (String) model.getValueAt(i, 2);

            fw.write(name + "," + age + "," + addr + "\n"); // 파일 한 줄 단위 저장
          }
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        } finally {
          try {
            fw.close();
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }

        //        JOptionPane.showMessageDialog(Ex03_TableFile.this, "프레임을 종료합니다");
        // 실제 종료
        System.exit(0);
        super.windowClosing(e);
      }
    });
  }

  private void setDesign() {
    // 2. 입력칸 생성
    JPanel p = new JPanel();
    tfName = new JTextField(4);
    tfAge = new JTextField(3);
    tfAddr = new JTextField(5);
    btnAdd = new JButton("추가");
    p.add(new JLabel("이름"));
    p.add(tfName);
    p.add(new JLabel("나이"));
    p.add(tfAge);
    p.add(new JLabel("주소"));
    p.add(tfAddr);
    p.add(btnAdd);
    this.add("North", p);

    // 3. table 생성
    model = new DefaultTableModel
        (new String[] {"이름" , "나이", "주소"},  0); // 일단 행 0개로 설정
    table = new JTable(model);
    this.add("Center", new JScrollPane(table));

    // 4. 버튼 이벤트
    btnAdd.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // 4-1. 입력 값을 Vector에 넣는다.
        Vector<String> data = new Vector<String>();
        data.add(tfName.getText());
        data.add(tfAge.getText());
        data.add(tfAddr.getText());
        // 4-2. addRow 메서드로 행을 추가
        model.addRow(data);
        // 4-3. 입력 갑을 제거한다.
        tfName.setText("");
        tfAge.setText("");
        tfAddr.setText("");
      }
    });
  }

  public static void main(String[] args) {

    Ex03_TableFile s = new Ex03_TableFile("안녕");
  }

}
