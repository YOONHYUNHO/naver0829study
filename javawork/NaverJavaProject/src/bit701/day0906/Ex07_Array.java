package bit701.day0906;

import java.util.Scanner;

public class Ex07_Array {

	public static void main(String args[]) {
		
		/*
		 * score에 5개의 배열 할당 후 키보드로 직접 점수를 입력하여 배열에 저장 후
		 * 총점 + 평균
		*/
		
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언
		int[] score = new int[5];
		int sum = 0;
		double avg = 0;
		
		// 입력
		for(int i = 0; i < score.length; i++) 
		{	

			System.out.print("["+i+"]번 점수를 입력 : ");
			score[i] = sc.nextInt();
			// 0보다 작거나 100보다 크면 다시 입력, continue
			if(score[i] < 0 || score[i] > 100)
			{	
				System.out.println("0 ~ 100 사이의 점수를 다시 입력하세요");
				i--;
				continue;
			}
			sum += score[i];
		}
		// 평균 계산
		avg = (double)sum/score.length;
		
		//출력
		System.out.println("입력한 점수 : ");
		for(int n:score)
			System.out.printf("%5d", n);
		System.out.println("\n총점 : " + sum);
		System.out.println("평균 : " + avg);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
