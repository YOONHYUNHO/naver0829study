package bit701.day0907;

import java.util.Scanner;

public class Ex1_Array {
	public static void main(String[] args) {
		
	
		/*
		 *  처음에 인원수(count)를 입력 후 그 인원수만큼
		 *  names, kor, eng를 배열 할당한 후
		 *  인원수만큼 이름, 국어, 영어 점수를 입력하면
		 *  아래와 같이 출력
		 *  번호 이름 국어 영어 총점 평균
		 *  -----------------------------
		 *  1    김	   89	90  179	  89
		 *  2 ...........................
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// 선언
		int count;
		String[] name;
		int[] kor;
		int[] eng;
		int[] tot;
		double[] avg;
		
		// 입력
		System.out.println("인원을 입력하세요");
		count = Integer.parseInt(sc.nextLine());
			
		
		// 배열 할당
		name = new String[count];
		kor = new int[count];
		eng = new int[count];
		tot = new int[count];
		avg = new double[count];
		
		// 데이터 입력
		for(int i = 0; i < count; i++)
		{
			System.out.println(i + "번 이름");
			name[i] = sc.nextLine();
			
			System.out.println(i + "번 국어, 영어점수");
			kor[i] = Integer.parseInt(sc.nextLine());
			eng[i] = Integer.parseInt(sc.nextLine());
		
			// 총점 , 평균 계산
			tot[i] = kor[i] + eng[i];
			avg[i] = tot[i]/2.0;
			System.out.println();
		}
		
		// 출력
		System.out.println("번호\t이름\t국어\t영어\t총점\t평균");
		System.out.println("=".repeat(50));
		for(int i = 0; i < count; i++)
		{
			System.out.println(i + 1 + "\t" + name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + tot[i] + "\t" + avg[i]);
		}
		
		
		
		
		
		
		
	}
}
