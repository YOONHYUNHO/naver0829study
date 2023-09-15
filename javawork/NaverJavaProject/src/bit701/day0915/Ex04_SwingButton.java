package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex04_SwingButton extends JFrame implements ActionListener {
	
	JButton btn1, btn2;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			System.out.println("버튼 1");
			this.getContentPane().setBackground(Color.red);
		} else { 
			System.out.println("버튼 2");
			this.getContentPane().setBackground(Color.blue);
		}
	
	}
	
	public Ex04_SwingButton(String title) {
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
				JOptionPane.showMessageDialog(Ex04_SwingButton.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
		
	private void setDesign() {
		
		btn1 = new JButton("버튼 #1"); // 버튼 생성
		
		// 프레임에 추가
		this.add(btn1, "South"); // BorderLayout(기본) 위치 지정 North, South, East, West, Center
		
		btn2 = new JButton("버튼 #2");
		
		this.add(btn2, "North");
		
		// 버튼 1,2에 이벤트가 발생하도록 추가
		btn1.addActionListener(this); // ()의 this는 이벤트 메서드가 구현된 클래스의 인스턴스
		btn2.addActionListener(this); // 각각 다른 이벤트를 발생하려면 내부 클래스를 따로 생성
		
		
	}

	public static void main(String[] args) {
		
		Ex04_SwingButton s = new Ex04_SwingButton("버튼");
	}

}	


