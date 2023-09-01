package bit701.day0901;

import java.util.Scanner;

public class Ex5_forExam {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// 1. 숫자 n을 입력 받은 후 1부터 n까지의 총 합계를 출력
		
		
		int n;
		int sum = 0; // 확인
		System.out.println("합계를 구할 숫자 입력 : ");
		n = sc.nextInt();
		
		// 1부터 n 까지의 총 합 구하기
		for(int i = 1; i <= n; i++) 
			sum += i;
			System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
		
	
		/* 2. 구구단 숫자 2-9 사이의 숫자를 입력 받은 후 범위를 벗어날 경우 종료
		 * 제대로 입력 시 해당 구구단 출력
		 * 
		 *  ** 5단 **
		 *  5 x 1 = 5
		 *  5 x 2 = 10
		 */
		
		int dan;
		System.out.println("구구단 : ");
		dan = sc.nextInt();
		if(dan < 2 || dan >9) {
			System.out.println("잘못된 숫자입니다.");
			return;
		}
		
		System.out.println("\t** " + dan + "단 ** \n");
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%6d X %d = %2d\n", dan, i, dan*i);
		}
		
				
		
	
	
	

	
	
	
	
	
	
	}
}
