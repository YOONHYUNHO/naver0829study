package bit701.day0901;


public class Ex3_for {
	
	public static void main(String[] args) {
		

		// for문 안에서 선언한 변수는 for문 종료와 동시에 삭제
		for(int i = 0; i < 10; i++) {
			
		}
		System.out.println("=".repeat(30)); // "="을 30번 반복
		
		for(int i = 0; i <= 10; i++)
			System.out.printf("%3d ", i);
		System.out.println();
		System.out.println("=".repeat(30)); // "="을 30번 반복
		

		for(int i = 0; i <= 20; i += 3)
			System.out.printf("%3d ", i);
		System.out.println();
		System.out.println("=".repeat(30)); // "="을 30번 반복

		for(int i = 10; i >= 1; i--)
			System.out.printf("%3d ", i);
		System.out.println();
		System.out.println("=".repeat(30)); // "="을 30번 반복
		
		
		// 다중 for문
		for(int i = 1; i <= 3; i++) {
			System.out.println("i = " + i);
		
			for(int j = 1; j <= 5; j++) {
				System.out.printf("%3d" , j);
			}
			System.out.println();
		} 
		System.out.println("=".repeat(30)); // "="을 30번 반복
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
