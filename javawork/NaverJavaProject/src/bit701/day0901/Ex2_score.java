package bit701.day0901;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex2_score {
	
	public static void main(String[] args) {
		
		/* 이름 , 3과목의 점수 (kor, eng, mat)를 입력 받은후 총점과 평균 (소숫점 1차리 출력 - NumberFormat)
		 * + 등급 출력 (grade >= 90 "Exellent" , >= 80 Good, 나머지 Try
		 */
	
		
		/*
		// 선언
		Scanner sc = new Scanner(System.in);
		NumberFormat nmfm = NumberFormat.getInstance();
		nmfm.setMaximumFractionDigits(1);
		
		// 입력
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("국어 : ");
		int kor = sc.nextInt();
		System.out.println("영어 : ");
		int eng = sc.nextInt();
		System.out.println("수학 : ");
		int mat = sc.nextInt();
		
		// 계산
		int total = kor + eng + mat;
		double avg = total/3.0;
		
		
		// 출력
		if(avg >= 90) {
			System.out.println("점수 = " + total + " 등급 : Exellent");
		} else if(avg >= 80) {
			System.out.println("점수 = " + total + " 등급 : Good");
		} else
			System.out.println("점수 = " + total + " 등급 : Try");
	
		*/
		
		// 선언
		Scanner sc = new Scanner(System.in);
		NumberFormat nmfm = NumberFormat.getInstance();
		nmfm.setMaximumFractionDigits(1);
		String name = "";
		int kor = 0, eng = 0, mat = 0, total = 0;
		double avg = 0;
		String grade = "";
		
		// 입력
		System.out.println("이름 : ");
		name = sc.nextLine();
		System.out.println("국어 : ");
		kor = sc.nextInt();
		System.out.println("영어 : ");
		eng = sc.nextInt();
		System.out.println("수학 : ");
		mat = sc.nextInt();
		
		// 계산
		total = kor + eng + mat;
		avg = total / 3.0;

		if(avg >= 90) grade = "Exellent";
		else if(avg >= 80) grade = "Good";
		else grade = "Try";
		
		// 출력
		
		System.out.println("이름" + name);
		System.out.println("국어 " + kor);
		System.out.println("영어 " + eng);
		System.out.println("수학 " + mat);
		System.out.println("총점 " + total);
		System.out.println("평균 : " + nmfm.format(avg));
		System.out.println("평가 : " + grade);
	}
}
