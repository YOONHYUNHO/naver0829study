package bit701.day0919;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
// 1. JFrame 상속
// 6. implements Runnable
public class Ex04_ClientChat extends JFrame implements Runnable, ActionListener{
  // 3. 멤버 변수 선언
  String nickName;
  JTextArea area;
  JTextField tfNickName, tfMessage, tfServerIp;
  JButton btnSend, btnConnect;
  Socket clientSocket;

  // 11. 서버에서 보낸 메세지를 읽고 출력 - 소켓이 있어야만 가능
  BufferedReader br;
  PrintWriter pw;

  // 2. JFrame 구현
  public Ex04_ClientChat() {
    this.setBounds(1000, 100, 400, 400);
    this.setDesign();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    Object ob = e.getSource();
    // 메세지 입력 후 엔터를 누르거나 전송 버튼을 누를 경우 같은 코드 실행
    if(ob == tfMessage || ob == btnSend) {
      System.out.println("메세지");
      pw.println("2 : " + tfMessage.getText() + "\n");
      pw.flush();

      // 입력한 문자열 지우기
      tfMessage.setText("");
      tfMessage.requestFocus(); // 포커스
    }

  }
  // 7. run() 메서드 오버라이드
  @Override
  public void run() {
    //    System.out.println("ㅎㅇ"); // 호출 확인

    // 9. 서버에 접속
    try {
      clientSocket = new Socket(tfServerIp.getText(), 6000);
      InputStream is = null;
      try {

        is = clientSocket.getInputStream();
        br = new BufferedReader(new InputStreamReader(is));
        pw = new PrintWriter(clientSocket.getOutputStream());
        area.append("서버에 접속 성공 \n");

        // 서버에 닉네임 전송
        pw.println("1 : " + nickName + "\n");
        pw.flush();
        // 서버가 언제 메세지를 보낼지 모르기 때문에 while문을 열어두고 메세지가 올때마다 실시간으로 출력
        while(true) {
          String message = br.readLine();
          area.append(message + "\n");
          this.autoScroll();
        }
      } catch (IOException e) {

      }


    } catch (IOException e) {
      area.append("서버에 접속 실패 : " + e.getMessage() + "\n");

    }
  }

  // 10. 오토 스크롤
  public void autoScroll() {
    int n = area.getDocument().getLength(); // 총 라인수
    area.setCaretPosition(n); // 마지막줄로 위치 변경
  }


  // 4. 디자인 메서드 생성
  private void setDesign() {
    JPanel pTop = new JPanel();
    tfNickName = new JTextField("윤현호", 5); // 초 기 값
    tfServerIp = new JTextField("192.168.0.44");
    btnConnect = new JButton("서버접속"); 
    pTop.add(new JLabel("닉네임 : "));
    pTop.add(tfNickName);
    pTop.add(tfServerIp);
    pTop.add(btnConnect);
    this.add("North", pTop);

    area = new JTextArea();
    this.add("Center", new JScrollPane(area));

    JPanel pBottom = new JPanel();
    tfMessage = new JTextField(25);
    btnSend = new JButton("전송");
    pBottom.add(tfMessage);
    pBottom.add(btnSend);
    this.add("South", pBottom);

    // 5. 접속 버튼 - 이벤트 생성
    btnConnect.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // 8. 닉네임을 읽어서 창 제목으로 넣기
        nickName = tfNickName.getText();
        Ex04_ClientChat.this.setTitle(nickName + "님 채팅창");

        // 8-1. run() 메서드 호출
        Thread th = new Thread(Ex04_ClientChat.this);
        th.start();
      }
    });

    // 메세지 입력 후 엔터 또는 전송 버튼 누를때 이벤트 발생 둘 다 같은 메서드 호출 - 기능이 동일
    tfMessage.addActionListener(this);
    btnSend.addActionListener(this);
  }

  public static void main(String[] args) {
    Ex04_ClientChat client = new Ex04_ClientChat();

  }


}
