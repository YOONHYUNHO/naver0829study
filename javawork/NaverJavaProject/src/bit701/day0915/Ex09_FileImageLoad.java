package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bit701.day0904.Ex8_Book133;

public class Ex09_FileImageLoad extends JFrame {
	
	JButton btnImageFile;
	String initImage = "D:\\naver0829\\image\\mycar\\mycar1.png";
	Image image;
	MyCanvas myCanvas = new MyCanvas();
	
	public Ex09_FileImageLoad(String title) {
		super(title); // Jframe의 문자열을 받는 생성자 호출
		this.setLocation(300, 100); // 프레임의 시작위치
		this.setSize(500, 600); // 프레임의 너비, 높이
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
//				JOptionPane.showMessageDialog(Ex09_FileImageLoad.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
		
	// 캔버스 내부 클래스
	class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			super.paint(g);
			if(image.getWidth(this) >= 300)
				g.drawImage(image, 50, 10, 400, 450, this);
			else // 300 미만 너비를 가진 이미지는 원래 사이즈대로 출력
				
				g.drawImage(image, 50, 10, this);
		}
	}
	
	
	private void setDesign() {
		// 상단에는 패널 안에 버튼 추가 후 프레임에 패널 추가
		JPanel p = new JPanel();
		btnImageFile = new JButton("이미지 파일 가져오기");
		p.add(btnImageFile);
		this.add("North", p);
		
		// 사진을 image로 변환
		image = new ImageIcon(initImage).getImage();
		
		this.add("Center", myCanvas);
		
		// 파일 버튼 이벤트
		btnImageFile.addActionListener(new ActionListener() {
			// 처음 시작 시 자동호출, 그리고 프레임 크기 변경시에도 자동호출
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 이미지 파일 가져오기
				FileDialog dlg = new FileDialog(Ex09_FileImageLoad.this, "이미지 열기", FileDialog.LOAD);
				dlg.setVisible(true);
				// 취소 시 종료
				if(dlg.getDirectory() == null)
					return;
				// 파일 경로와 파일명 가져오기
				initImage = dlg.getDirectory()+dlg.getFile();
				// image 생성
				image = new ImageIcon(initImage).getImage();
				
				// 캔버스의 paint 메서드는 버튼을 누른다고 자동호출x 
				// 강제호출
				myCanvas.repaint();
			}
		});
		
	}

	public static void main(String[] args) {
		
		Ex09_FileImageLoad s = new Ex09_FileImageLoad("이미지 뷰어");
	}
	
}