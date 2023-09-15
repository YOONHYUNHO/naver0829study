package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex08_Canvas extends JFrame {
	
		// 캔버스 멤버변수로 선언
		MyCanvas myCanvas = new MyCanvas();
		
		public Ex08_Canvas(String title) {
			super(title); // Jframe의 문자열을 받는 생성자 호출
			this.setLocation(300, 100); // 프레임의 시작위치
			this.setSize(500, 500); // 프레임의 너비, 높이
//			this.getContentPane().setBackground(Color.green); // Color 상수를 이용해서 변경
//			this.getContentPane().setBackground(new Color(200, 255, 180));
			
			// 디자인이나 이벤트를 구현 할 메서드 호출
			this.setDesign();
			
			this.setVisible(true); // true : 프레임 보이기 , false : 숨기기
			
			// 윈도우 이벤트 발생(Frame) WindowAdapter - 익명 내부클래스
			this.addWindowListener(new WindowAdapter() {
				
				// Window의 x버튼 클릭 시 호출 메서드
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(Ex08_Canvas.this, "프레임을 종료합니다");
					// 실제 종료
					System.exit(0);
					super.windowClosing(e);
				}
			});
		}
			
		
		// 캔버스 내부 클래스
		class MyCanvas extends Canvas {
			
			String imageIcon1 = "D:\\naver0829\\image\\연예인사진\\20.jpg";
			
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				
				// 원그리기
				g.setColor(new Color(255, 100, 255));
				g.drawOval(50, 50, 100, 100); // 테두리선만 있는 원
				
				// 채워진 원
				g.setColor(Color.orange);
				g.fillOval(200, 50, 100, 100);
				
				// 테두리만 있는 사각형
				g.setColor(Color.green);
				g.drawRect(50, 200, 100, 100);
				
				// 채워진 사각형
				g.setColor(Color.pink);
				g.fillRect(200, 200, 100, 100);
				
				Image image1 = new ImageIcon(imageIcon1).getImage();
				
				// 이미지 그리기
				g.drawImage(image1, 300, 220, this);
			
				// 크기 변경해서 출력
				g.drawImage(image1, 300, 30, 100, 100, this);
			}
		}
		private void setDesign() {
			
			this.add(myCanvas, "Center");
		}

		public static void main(String[] args) {
			
			Ex08_Canvas s = new Ex08_Canvas("캔버스");
		}

}
