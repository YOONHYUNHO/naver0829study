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

import bit701.day0915.Ex09_FileImageLoad.MyCanvas;

public class Ex10_FileRandom extends JFrame {
	
	JButton btnImageFile, btnImageFile1, btnImageFile2, btnImageFile3;
	Image image, imageCar;
	MyCanvas myCanvas = new MyCanvas();
	
	String initImage = "D:\\naver0829\\image\\연예인사진\\seolhyeon.jpg";
	String initImage1 = null;
	String[] imageArray = new String[6];
	int ran =0;
	
	public Ex10_FileRandom(String title) {
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
//				JOptionPane.showMessageDialog(Ex10_FileRandom.this, "프레임을 종료합니다");
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
				btnImageFile = new JButton("이미지 변경");
				btnImageFile.setBounds(50, 50, 100, 50);
				p.add(btnImageFile);
				btnImageFile1 = new JButton("차");
				p.add(btnImageFile1);
				btnImageFile2 = new JButton("차");
				p.add(btnImageFile2);
				btnImageFile3 = new JButton("차");
				p.add(btnImageFile3);
				this.add("North", p);
				
			
				
				
				
				// 사진을 image로 변환
				image = new ImageIcon(initImage).getImage();
				imageCar = new ImageIcon(initImage1).getImage();
				
				this.add("Center", myCanvas);
				
				// 파일 버튼 이벤트
				btnImageFile.addActionListener(new ActionListener() {
					// 처음 시작 시 자동호출, 그리고 프레임 크기 변경시에도 자동호출
					@Override
					public void actionPerformed(ActionEvent e) {
						initImage1 = "D:\\naver0829\\image\\mycar\\mycar1.png";
						image = new ImageIcon(initImage1).getImage();
						
						// 캔버스의 paint 메서드는 버튼을 누른다고 자동호출x 
						// 강제호출
						myCanvas.repaint();
					}
				});
				
				// 버튼1 이벤트
				btnImageFile1.addActionListener(new ActionListener() {
					
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						int random = (int)((Math.random()*6)+1);
						
						
						String init1 = "D:\\naver0829\\image\\mycar\\mycar" + random + ".png";
							
						image = new ImageIcon(init1).getImage();
							myCanvas.repaint();
					}
				});
				
				// 버튼2 
				btnImageFile2.addActionListener(new ActionListener() {
					// 처음 시작 시 자동호출, 그리고 프레임 크기 변경시에도 자동호출
					@Override
					public void actionPerformed(ActionEvent e) {
						initImage1 = "D:\\naver0829\\image\\mycar\\mycar1.png";
						image = new ImageIcon(initImage1).getImage();
						
						// 캔버스의 paint 메서드는 버튼을 누른다고 자동호출x 
						// 강제호출
						myCanvas.repaint();
					}
				});
		
				// 버튼3 
				btnImageFile3.addActionListener(new ActionListener() {
					// 처음 시작 시 자동호출, 그리고 프레임 크기 변경시에도 자동호출
					@Override
					public void actionPerformed(ActionEvent e) {
						initImage1 = "D:\\naver0829\\image\\mycar\\mycar1.png";
						image = new ImageIcon(initImage1).getImage();
						
						// 캔버스의 paint 메서드는 버튼을 누른다고 자동호출x 
						// 강제호출
						myCanvas.repaint();
					}
				});
				
	}

	public static void main(String[] args) {
		
		Ex10_FileRandom s = new Ex10_FileRandom("랜덤");
	}
}