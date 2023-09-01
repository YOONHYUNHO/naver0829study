package bit701.day0901;

import java.util.Scanner;

public class Ex6_forExam {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		/*
		 * 구구단을 출력할 시작단 입력
		 * 
		 * 구구단을 출력할 끝단 입력
		 * 
		 * 
		 *      4단     5단    6단
		 *	   4x1=4  5x1=5   6x1=6
		 */
		System.out.println("시작 : ");
		int start = sc.nextInt();
		System.out.println("종료 : ");
		int end = sc.nextInt();
		
		// start가 end보다 클 경우 두 변수의 값을 변환
		if(start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		
		// 제목 출력
		for(int dan = start; dan <= end; dan++)
		{
			System.out.printf("%7d단 ", dan);
		}
		System.out.println("\n");
		
		for(int i = 1; i <= 9; i++) {
			for(int dan = start; dan <= end; dan++) {
				System.out.printf("%5dx%d=%2d", dan, i, dan*i);
			}
			System.out.println();
		}
	

	
	
	
	
	
	
	}
}
