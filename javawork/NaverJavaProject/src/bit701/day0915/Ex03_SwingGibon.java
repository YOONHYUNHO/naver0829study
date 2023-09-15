package bit701.day0915;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex03_SwingGibon extends JFrame {
	
	public Ex03_SwingGibon(String title) {
		super(title); // Jframe의 문자열을 받는 생성자 호출
		this.setLocation(300, 100); // 프레임의 시작위치
		this.setSize(300, 300); // 프레임의 너비, 높이
//		this.getContentPane().setBackground(Color.green); // Color 상수를 이용해서 변경
		this.getContentPane().setBackground(new Color(200, 255, 180));
		
		// 디자인이나 이벤트를 구현 할 메서드 호출
		this.setDesign();
		
		this.setVisible(true); // true : 프레임 보이기 , false : 숨기기
		
		// 윈도우 이벤트 발생(Frame) WindowAdapter - 익명 내부클래스
		this.addWindowListener(new WindowAdapter() {
			
			// Window의 x버튼 클릭 시 호출 메서드
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex03_SwingGibon.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
		
	private void setDesign() {
		
		
	}

	public static void main(String[] args) {
		
		Ex03_SwingGibon s = new Ex03_SwingGibon("안녕");
	}

}
