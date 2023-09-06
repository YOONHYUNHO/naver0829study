package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex04_Oper {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/* 점수를 입력 받아 90이상은 "A" 80이상은 "B" 70이상은 "C" 60이상은 "D" 그외 "E"
		 * 99 입력시 "99점은 A 학점입니다."
		 * if || 조건연산자
		 */
		System.out.println("점수를 입력 하세요 : ");
		int score = sc.nextInt();
		if(score < 1 || score > 100) {
			System.out.println("점수를 다시 입력해주세요 - 종료");
			// return은 원래 해당 메서드만 종료하는 명령어인데 main 메서드 종료는 곧 프로그램 종료를 의미
			return;
		}
		System.out.printf("점수 : %d\n", score);
		String grade = "";
		
		// if문
		if(score >= 90) 
			grade = "A";
		else if(score >= 80)
			grade = "B";
		else if(score >= 70)
			grade = "C";
		else if(score >= 60)
			grade = "D";
		else
			grade = "E";
		System.out.println(score +"점은 " + grade +"학점입니다.");
		
		// 3항연산자
		grade = score >=90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : score >= 60 ? "D" : "E";
		System.out.printf("%d점은 %d학점입니다.", score, grade );
		
	}

}
