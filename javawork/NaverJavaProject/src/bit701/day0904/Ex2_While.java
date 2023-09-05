package bit701.day0904;

import java.util.Scanner;

public class Ex2_While {
	public static void main(String[] args) {
		
		// 점수를 입력받아 총점과 평균을 구하는 프로그램(0 이 입력되면 점수 입력을 종료)
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		int sum = 0, count = 0; // 증감 연산자나 ++ , -- 사용 시 무조건 초기화
		double avg = 0;
		
		while(true)
		{
			System.out.println("점수를 입력하세요(종료 : 0)");
			score = sc.nextInt();
			if(score == 0) 
			{
				break; // 0 입력시 while문을 빠져 나간다.
			}
			if(score < 1 || score > 100)
			{
				System.out.println("\t 1-100사이의 점수만 입력해주세요");
				continue; // 하던 작업을 중단하고 다시 처음으로 돌아간다.
			}
			count++;
			sum += score;
		}
		// 0 입력 시 평균 구하기
		avg = (double)sum/count;
		System.out.println("입력 수 : " + count);
		System.out.println("총 합계 : " + sum);
		System.out.println("총 평균 : " + avg);
	}
}
