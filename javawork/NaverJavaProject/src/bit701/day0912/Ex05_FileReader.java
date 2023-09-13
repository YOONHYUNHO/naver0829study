package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex05_FileReader {
	
	static final String SUNGJUK_FILE = "D:/naver0829/sungjuk.txt";
	Sungjuk[] sung = new Sungjuk[20];
	int count;
	
	public Ex05_FileReader() throws IOException {
		// 파일 읽어서 sung 배열에 담기( 줄 단위로 읽은 후 ,로 분리해서 넣기 )
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(SUNGJUK_FILE);
			br = new BufferedReader(fr);
		
			count = 0;
			while(true)
			{	
				String line = br.readLine();
				// null 이면 종료
				if(line == null)
					break;
				// ,로 분리
				String[] data = line.split(",");
				String name = data[0];
				int kor = Integer.parseInt(data[1]);
				int eng = Integer.parseInt(data[2]);
			
				//Sungjuk 클래스 생성 - count 번지
				sung[count] = new Sungjuk(name, kor, eng);
				count++;
				
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("파일x");
		}
	}
	
	public void dataList()
	{
		// 이름 국어 영어 총점 평균
		System.out.println("총 " + count + "명" );
		System.out.println("이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(40));
		for(int i = 0; i < count; i++)
		{
			Sungjuk s = sung[i];
			int total = s.getKor() + s.getEng();
			double avg = total / 2.0;
			System.out.println(s.getName() + "\t" + 
			s.getKor() + "\t" + s.getEng() + "\t" + total + "\t" + avg);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Ex05_FileReader ex = new Ex05_FileReader();
		ex.dataList();
		
		
	}
}
