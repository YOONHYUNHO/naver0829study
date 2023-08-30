package bit701.day0830;

public class OperEx5 {

	public static void main(String[] args) {
		
		/* 증감 연산자 : ++ , --		
		 * 변수 앞에(전치) 1 순위
		 * 변수 뒤에(후치) 마지막 순위
		*/
		
		int a = 5;
		int b = 5;
		++a;
		System.out.println(a);
		b++;
		System.out.println(b);
		System.out.println(++a);
		System.out.println(b++); // 출력 후 증가
		System.out.println("a = " + a + " , b = " + b);
		
		a=b=5;
		int m = ++a;
		int n = b++;
		System.out.printf("a = %d, b = %d, m = %d, n = %d", a, b, m, n);
		

	}

}
