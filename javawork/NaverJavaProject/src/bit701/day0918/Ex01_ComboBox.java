package bit701.day0918;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


// 1. 상속
public class Ex01_ComboBox extends JFrame{

  // 6. 판넬 생성
  JPanel p = new JPanel();
  // 7. 콤보박스 선언
  JComboBox<String> combo;



  // 2-1. 버튼 선언
  JRadioButton rbYellow, rbMagenta, rbGray, rbBlue;

  // 2-5. 라벨 선언
  JLabel lblMessage;


  // 2. 생성자
  public Ex01_ComboBox(String title) {
    // 4. 부모
    super(title);
    this.setBounds(400, 100, 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 메서드
    this.setDesign(); // 5. 메서드 생성
    this.setVisible(true); // Visible 전에 생성
  }

  private void setDesign() {
    // 8. list 생성 
    Vector<String> list = new Vector<String>();
    list.add("빨강");
    list.add("초록");
    list.add("분홍");
    list.add("오렌지");

    // 9. 콤보박스 생성
    combo = new JComboBox<String>(list);
    // 10. 상단에 추가
    //  this.add("North",combo); // 상단 전체에 추가
    // 10-1. 패널 추가
    JPanel pTop = new JPanel();
    pTop.add(combo);
    this.add("North", pTop);

    // 2-6. p 패널에 라벨 추가
    lblMessage = new JLabel("Have a Nice Day");
    lblMessage.setFont(new Font("Comic Sans MS" , Font.BOLD, 30));
    p.add(lblMessage);

    // 11. Center에는 JPanel p를 추가
    p.setBackground(Color.red);
    this.add("Center", p);

    // 12. 콤보박스 이벤트 - ItemListener(내부익명클래스)
    combo.addItemListener(new ItemListener() {

      @Override
      public void itemStateChanged(ItemEvent e) {
        // 13. 선택한 문자열을 얻는다.
        String selectColor = (String)combo.getSelectedItem(); // Object 형태 -> String 형변환
        // System.out.println(selectColor); // 문자열을 가져오는지 확인
        switch(selectColor)
        {
          case "빨강" :
            p.setBackground(Color.red);
            break;
          case "분홍" :
            p.setBackground(Color.pink);
            break;
          case "오렌지" :
            p.setBackground(Color.orange);
            break;
          case "초록" :
            p.setBackground(Color.green);
            break;
        }
      }
    });

    // 2-2. 버튼그룹 - 4개 라디오 버튼 추가
    ButtonGroup bg = new ButtonGroup();
    rbYellow = new JRadioButton("노랑");
    rbMagenta = new JRadioButton("핑크");
    rbGray = new JRadioButton("회색");
    rbBlue = new JRadioButton("파랑");

    // 2-3. 버튼을 같은 그룹으로 묶기(4개중 1선택)
    bg.add(rbYellow);
    bg.add(rbBlue);
    bg.add(rbMagenta);
    bg.add(rbGray);

    // 2-4. 버튼을 이판 패널에 묶어서 넣은 후 프레임에 추가
    JPanel pBottom = new JPanel();
    pBottom.add(rbYellow);
    pBottom.add(rbBlue);
    pBottom.add(rbMagenta);
    pBottom.add(rbGray);
    this.add("South" , pBottom);

    // 2-7. 글자색 변경 이벤트(배열이 아니므로 각각 이벤트 추가)

    rbYellow.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        lblMessage.setForeground(Color.yellow);
      }
    });
    rbMagenta.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        lblMessage.setForeground(Color.magenta);
      }
    });
    rbGray.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        lblMessage.setForeground(Color.gray);
      }
    });
    rbBlue.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        lblMessage.setForeground(Color.blue);
      }
    });
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 3. 생성자 호출
    Ex01_ComboBox ex = new Ex01_ComboBox("ComboBox");
  }

}
