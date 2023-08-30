package bit701.day0830;

public class AsciiEx3 {

	public static void main(String[] args) {
		// char, int는 같은 타입?
		char a1 = 65;
		int a2 = 'B';
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println((int)a1);
		System.out.println((char)a2);
	
		System.out.printf("%d의 아스키문자는 %c이다\n", (int)a1, a1);
		
		char b1 = 'C';
		int b2 = 68;
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1+10); 
		/* 
		 	묵시적 형변환에 의해서 char와 int로 계산 하면 int로 값 도출 
			char + int = int
			long + int = long
			int + int = int
			double + int = double
			String + int = String
			String + double = String
		*/
		
		
		/* 
		 * print나 println은 모든 타입 출력이 가능하다.
		 * 타입별로 여러개를 같은 이름으로 생성했기 때문이다.
		 * 이런 메서드를 중복함수(overloding method)라고 한다.
		*/
		
		System.out.println((char)(b1+2)); // 강제 형변환
		
		
		System.out.println(5/2); // int와 int의 연산으로 결과는 int 타입
		System.out.println(5.0/2); 
		System.out.println((double)5/2); 
		System.out.println((double)(5/2)); 
	
	}
}