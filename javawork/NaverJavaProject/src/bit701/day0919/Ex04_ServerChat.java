package bit701.day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
// 6. Thread를 상속 받을 수 없기 때문에 Runnable 구현
public class Ex04_ServerChat extends JFrame implements Runnable {

  // 2. JTextArea 인스턴스 생성
  JTextArea area;


  // 14. 접속하는 클라이언트 저장 Vector
  Vector<ClientMember> listMember = new Vector<ClientMember>();


  // 4. 
  public Ex04_ServerChat() {
    super("채 팅 서 버");
    this.setBounds(700, 100 , 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setdesign();
    this.setVisible(true);
  }

  // 7. Runnable을 구현 할 메서드 생성 - 1번 Thread
  @Override
  public void run() {
    //    System.out.println("호출"); // 8-1. 호출 확인
    // 9. 서버 소켓 생성
    ServerSocket serverSocket = null;
    // 10. 
    try {
      serverSocket = new ServerSocket(6000);
      area.append("서버 소켓 생성 성공 \n");

      // 11. 접속하는 클라이언트 허용 - 메인스레드는 따로 존재
      while(true) {
        // 대기중 
        // 12. 클라이언트 접속이 허용이 되면 Socket 생성
        Socket socket = serverSocket.accept();

        // 14-1. 허용 클라이언트 Vector에 추가
        ClientMember clientMember = new ClientMember(socket);
        listMember.add(clientMember);
        // 각 클라이언트의 run 메서드 호출
        clientMember.start();

        // 13. 접속 클라이언트 ip 확인
        area.append("접속 허용 IP : " + socket.getInetAddress().getHostAddress() + "\n");
        this.autoScroll();
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      area.append("서버 소켓 생성 실패 : " + e.getMessage()+ "\n");
    }


  }

  // 11. 접속한 클라이언트와 대화를 주고 받을 내부 클래스
  class ClientMember extends Thread {
    Socket mySocket;
    BufferedReader br; // 읽기
    PrintWriter pw; // 출력
    String nickName;

    public ClientMember(Socket socket) {
      mySocket = socket;

      // 11-1. 대화를 주고 받을 수 있도록 io 클래스 얻기
      InputStream is = null;
      try {
        is = mySocket.getInputStream();
        br = new BufferedReader(new InputStreamReader(is));
        pw = new PrintWriter(mySocket.getOutputStream());
      } catch (IOException e) {
        //        // TODO Auto-generated catch block
        //        e.printStackTrace();
      }

    }

    @Override
    public void run() {
      // 15. 
      while(true) {
        // 클라이언트가 보낸 메세지를 읽는다.
        try {
          String message = br.readLine();
          // 처음 접속 시 : 1|  닉네임 메세지 : 2|메세지
          area.append(message + "\n");
          Ex04_ServerChat.this.autoScroll();
          String[] arr = message.split("\\|");
          //          System.out.println(arr[0] + ", " + arr[1]);

          switch(arr[0]) {
            case "1" :
              this.nickName = arr[1];
              // 접속한 모든 클라인트들한테 입장 알림
              for(ClientMember mem : listMember) {
                mem.pw.println(this.nickName + ">> 님이 입장하였습니다.\n");
                mem.pw.flush(); // 전송
              }
              break;
            case "2" : 
              // 보낸 메세지가 arr[1]에 들어있다.
              // 접속한 모든 클라이언트에게 누가 어떤 메세지를 보냈는지 알린다.
              for(ClientMember mem : listMember) {
                mem.pw.println(this.nickName + arr[1] + "\n");
                mem.pw.flush(); // 전송
              }
              break;
          }
        } catch (IOException|ArrayIndexOutOfBoundsException e) {
          //            e.printStackTrace();
        }

      }
    }
  }

  // 10. 오토 스크롤
  public void autoScroll() {
    int n = area.getDocument().getLength(); // 총 라인수
    area.setCaretPosition(n); // 마지막줄로 위치 변경
  }

  // 5.
  private void setdesign() {
    area = new JTextArea();
    this.add(new JScrollPane(area));
  }

  public static void main(String[] args) {
    // 3. 
    Ex04_ServerChat severChat = new Ex04_ServerChat();

    // 8. 
    Thread th = new Thread(severChat);
    th.start(); // 1번 run 메서드 호출

  }


}






























