package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Ex02_FileWriter {

	static final String FILENAME = "D:/naver0829/memo1.txt"; // 같은 static은 FILENAME으로 접근
	
	public static void main(String[] args) throws IOException {
		
		FileReader fr = null;
		BufferedReader br = null;
	
		try {
			
			fr = new FileReader(FILENAME); // 줄단위로 읽는 멤버메서드x, 2차 생성 ->
			br = new BufferedReader(fr);
		
			/* br.readLine() 한 줄씩 읽고 더 이상 읽을 내용이 없을 경우 null 값을 반환
			 * while문으로 처리 null 값이 나오면 빠져 나감
			*/
			while(true)
			{
				// 파일의 내용을 한 줄씩 읽는다.
				String line = br.readLine();
				
				// 더 이상 읽을 내용이 없을 경우 while문을 종료한다.
				if(line == null)
					break;
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			
			// 해당 파일이 없을 경우 예외 발생 catch 영역 실행
			System.out.println("해당 파일을 찾을수 없습니다." + e.getMessage());
		}
		
		// 열려있는 자원을 닫음(역순)
		br.close();
		fr.close();
	}

}
