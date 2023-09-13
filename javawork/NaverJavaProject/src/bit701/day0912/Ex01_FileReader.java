package bit701.day0912;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Ex01_FileReader {

	static final String FILENAME = "D:/naver0829/memo1.txt"; // 같은 static은 FILENAME으로 접근
	
	public static void main(String[] args) throws IOException {
		
		// 파일에 개인정보 저장
		FileWriter fw = null;
		
		// 생성
		//fw = new FileWriter(FILENAME); // 파일이 없으면 생성, 없으면 덮어쓴다.
		fw = new FileWriter(FILENAME, true); // 실행 시 기존 파일에 내용을 추가
		
		// 파일에 내용 저장하기
		fw.write("이름 : 김종국\n");
		fw.write("핸드폰 : 010-5678-1234\n");
		fw.write("----------------------\n");
		
		// 파일 닫기
		fw.close();
		System.out.println("탐색기를 열고 memo1.txt 파일을 확인하세요");
	}

}
