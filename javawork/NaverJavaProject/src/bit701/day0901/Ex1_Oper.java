package bit701.day0901;

public class Ex1_Oper {
	
	public static void main(String[] args) {
	
		/* 대입연산자 : =, +=, -=, *=, /=, %=
		 * 대입연산자나 증감연사자를 이용 시 해당 변수는 반드시 값이 존재해야한다.
		 */
		
		int a = 5;
		
		// a = a+3;
		a += 3;
		
		System.out.println(a);

		a -= 1; // a--;
		System.out.println(a);
		
		a *= 5;
		System.out.println(a);
		
		a /= 3;
		System.out.println(a);
		
		a %= 4;
		System.out.println(a);
	}
}
