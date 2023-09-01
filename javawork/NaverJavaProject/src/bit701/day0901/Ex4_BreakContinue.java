package bit701.day0901;


public class Ex4_BreakContinue {
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++) {
			
			if(i == 5)
				break; 
			System.out.printf("%3d", i);
			
		}
		System.out.println();
		System.out.println("-".repeat(30));

		
		
		for(int i = 1; i <= 10; i++) {
			
			if(i%2 == 0) // 짝수는 출력하지 않고 다음 숫자로 이동
				continue; // i++ 증감식으로 이동 
			System.out.printf("%3d", i);
			
		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		// 다중 for문 한 번에 반복문 탈출(lable)
		Exit:
			for(int i = 1; i <= 3; i++) {
				System.out.println("i = " + i);
				for(int j = 1; j <= 5; j++) {
					System.out.printf("%3d", j);
					if(j == 3)
						break Exit; // j가 3이 되면 두개의 반복문을 모두 빠져나온다.
				}
				System.out.println();
			}
		System.out.println("-".repeat(30));
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
