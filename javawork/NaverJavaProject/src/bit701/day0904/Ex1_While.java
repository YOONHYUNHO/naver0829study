package bit701.day0904;

public class Ex1_While {
	public static void main(String[] args) {
		
		/* 
		 * 반목분에는 for , while , do-while
		 * for문은 주로 반복횟수가 정해져 있는경우
		 * while 이나 do-while은 반복횟수가 정해져있지 않은 경우
		 * while 과 do-while 차이점은 조건을 먼저 주느냐, 나중에 주느냐(선조건 , 후조건) 차이
		*/
		
		int a = 65; // 대문자 A의 아스키 코드 값
		while (a <= 90) // 조건이 참인동안 실행 : 91에서 빠져 나감 
		{
//			System.out.println((char)a);
//			a++;
			System.out.print((char)a++);
		}
		System.out.println();
		System.out.println("빠져나온 후에 a값 " + a);
		
		a = 65;
		
		while (true)
		{			
			System.out.print((char)a++);
			if(a > 90)
			{
				break;
			}
		}
		System.out.println();
		
		a = 65;
		
		do 
		{
			System.out.print((char)a++);
		}
		while (a <= 90); // 조건 뒤에 반드시 ; 추가
		
		int n = 10;
//		while (n<10); // 조건이 거짓이면 실행 x
//		{
//			
//		}
		
		// do while은 무조건 한 번은 실행
		do 
		{
			System.out.println(n--);
			if(n == 0)
				break;
		}
		while (n < 10);
		
	}
}
