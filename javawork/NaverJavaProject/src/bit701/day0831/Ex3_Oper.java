package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex3_Oper {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/* 점수를 받아서 1 ~ 100 점이 아닐 경우 프로그램 종료
		 * 90 이상은 합격, 80 이상은 재시험, 그 외 불합격
		 */
		System.out.println("점수를 입력 하세요 : ");
		int score = sc.nextInt();
		if(score < 1 || score > 100) {
			System.out.println("점수를 다시 입력해주세요 - 종료");
			// return은 원래 해당 메서드만 종료하는 명령어인데 main 메서드 종료는 곧 프로그램 종료를 의미
			return;
		}
		System.out.printf("점수 : %d\n", score);
		
		// if문
		String msg = "";
		if(score >= 90)
			msg = "합격";
		else if(score >= 80)
			msg = "재시험";
		else
			msg = "불합격";
		System.out.println("결과 : " + msg);
		
		// 3항연산자
		msg = score >= 90 ? "합격" : score >= 80 ? "재시험" : "불합격";
		System.out.println("결과 : " + msg);
	}

}
