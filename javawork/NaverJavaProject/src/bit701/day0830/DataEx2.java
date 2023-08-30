package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		
		
		System.out.println("내 이름은 " + args[0] + "입니다.");
		System.out.println("우리집은 " + args[1] + "입니다.");
		System.out.println("혈액형은 " + args[2] + "형입니다.");
		System.out.println();
		
		
		System.out.println("실수형 데이터 타입");
		float fl = 1234.567891234f; // 4byte
		double dl = 1234.567891234; // 8byte
		
		System.out.println(fl); // float 8자리까지 정확하게 출력
		System.out.println(dl); // double 15자리까지 정확하게 출력
		
		
		// char 타입은 2byte 한글 한 글자도 저장 가능
		char ch1 = 'A';
		char ch2 = '가';
		System.out.println(ch1);
		System.out.println(ch2);
		
	
	}

}
