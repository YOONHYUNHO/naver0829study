package bit701.day0915;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class Ex07_FileMemo extends JFrame {
	JTextArea memoArea;
	JButton btnSave, btnOpen, btnClear;
	
	JButton[] btn = new JButton[6];
	String[] buttonTitle = {"노랑", "오랜지", "분홍", "핑크", "초록", "빨강"};
	Color[] buttonColor = {Color.yellow, Color.orange, Color.magenta, Color.pink, Color.green,
			Color.red};
	
	
	public Ex07_FileMemo(String title) {
		super(title); // Jframe의 문자열을 받는 생성자 호출
		this.setLocation(300, 100); // 프레임의 시작위치
		this.setSize(500, 600); // 프레임의 너비, 높이
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
//				JOptionPane.showMessageDialog(Ex07_FileMemo.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
	
	
	
	private void setDesign() {
		
		btnSave = new JButton("파일저장");
		btnOpen = new JButton("파일열기");
		btnClear = new JButton("내용지우기");
		
		JPanel p = new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		p.add(btnClear);
		
		// Panel에 North 추가
		this.add(p , "North");
		
		memoArea = new JTextArea("내용을 입력");
		this.add(memoArea, "Center"); // 데이터가 길 경우 스크롤바 x
		
		this.add(new JScrollPane(memoArea), "Center"); // 스크롤바
		
		// 버튼 : 지우기
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				memoArea.setText("");
			}
		});
		
		// 버튼 : 저장
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				FileDialog dlg = new FileDialog(Ex07_FileMemo.this, "메모장저장", FileDialog.SAVE);
				dlg.setVisible(true);
//				System.out.println("디렉토리 : " + dlg.getDirectory());
//				System.out.println("파일명 : " + dlg.getFile());
				
				// 취소 시 메서드 종료
				if (dlg.getDirectory() == null)
					return;
				String fileName = dlg.getDirectory()+dlg.getFile() + "txt";
				String memoText = memoArea.getText(); // 저장할 내용
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					// 저장
					fw.write(memoText);
					// 메시지
					memoArea.setText("저장 완료");
				} catch (IOException e1) {
					System.out.println("오류 " + e1.getMessage()); 
				} finally {
					try {
						fw.close();
					} catch (NullPointerException | IOException e1) {
						// close 시 나올만 Exception 두 개 나열
					}
				}
			}
		});
		
		
		// 버튼 : 열기
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileDialog dlg = new FileDialog(Ex07_FileMemo.this, "파일열기", FileDialog.LOAD);
				dlg.setVisible(true);
				// 취소 시 메서드 종료
				if(dlg.getDirectory() == null)
					return;
				
				String fileName = dlg.getDirectory()+dlg.getFile();
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(fileName);
					br = new BufferedReader(fr);
					
					// 메모장 기본 내용
					memoArea.setText("");
					while(true)
					{
						String line = br.readLine();
						if(line == null)
							break;
						
						memoArea.append(line + "\n");
					}
						
					
					// 메모장의 기본 내용
				} catch(IOException e1) {
					System.out.println("파일 읽기 오류" + e1.getMessage());
				} finally {
					
					try {
						br.close();
						fr.close();
					} catch (IOException | NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
			}
		});
	
	
	}

	public static void main(String[] args) {
		
		Ex07_FileMemo s = new Ex07_FileMemo("간단한 메모장");
	}

}
