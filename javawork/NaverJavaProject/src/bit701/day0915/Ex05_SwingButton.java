package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex05_SwingButton extends JFrame {
	
	JButton btn1, btn2, btn3;
	
	public Ex05_SwingButton(String title) {
		super(title); // Jframe의 문자열을 받는 생성자 호출
		this.setLocation(300, 100); // 프레임의 시작위치
		this.setSize(300, 300); // 프레임의 너비, 높이
//		this.getContentPane().setBackground(Color.green); // Color 상수를 이용해서 변경
//		this.getContentPane().setBackground(new Color(200, 255, 180));
		
		// 디자인이나 이벤트를 구현 할 메서드 호출
		this.setDesign();
		
		this.setVisible(true); // true : 프레임 보이기 , false : 숨기기
		
		// 윈도우 이벤트 발생(Frame) WindowAdapter - 익명 내부클래스
		this.addWindowListener(new WindowAdapter() {
			
			// Window의 x버튼 클릭 시 호출 메서드
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex05_SwingButton.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
	
	// 버튼 이벤트 내부클래스
	class MyColorButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btn1)
				Ex05_SwingButton.this.getContentPane().setBackground(Color.orange);
			else
				Ex05_SwingButton.this.getContentPane().setBackground(Color.magenta);
		}
		
	}
		
	private void setDesign() {
		
		
		// 자바에서 제공하는 레이아웃 안쓰고 직접 위치지정
		this.setLayout(null);
		
		// 버튼 1
		btn1 = new JButton("오랜지");
		btn1.setBounds(50, 50, 100, 50); // x , y , width , height
		this.add(btn1);
		
		// 버튼 2
		btn2 = new JButton("분홍");
		btn2.setBounds(180, 50, 100, 50); // x , y , width , height
		this.add(btn2);
		
		// 버튼 1,2는 내부클래스 MyColorButton의 이빈트를 호출
		btn1.addActionListener(new MyColorButton());
		btn2.addActionListener(new MyColorButton());
		
		// 버튼3 
		btn3 = new JButton("버튼 글자 & 배경 변경");
		btn3.setBounds(40, 130, 180, 50);
		this.add(btn3);
		
		// 버튼3 익명 내부 클래스 형태
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn1.setBackground(Color.green);
				btn1.setForeground(Color.red);
				
				btn2.setBackground(Color.pink);
				btn2.setForeground(Color.blue);
				
				btn3.setBackground(Color.black);
				btn3.setForeground(Color.yellow);
				
			}
		});
	}

	public static void main(String[] args) {
		
		Ex05_SwingButton s = new Ex05_SwingButton("이벤트 연습");
	}

	

}
