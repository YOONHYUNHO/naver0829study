package bit701.day0831;

import java.util.Scanner;

public class Ex9_SwitchWeek {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		/* 연도와 월을 입력하면 몇일까지 있는지 출력
		 * 해당 연도가 윤년인지 아닌지 판단
		 */
		
		System.out.println("연도 4자리 숫자 입력");
		int year = sc.nextInt();
		System.out.println("월(1~12) 입력");
		int month = sc.nextInt();
		
		// 입력을 잘못한 경우 종료
		if(month < 1 || month > 12) {
			System.out.println("확인해주세요");
			return;
		}
		
		System.out.printf("입력한 연도와 월 : %d년 %d월 \n\n", year, month);
		
		int days = 0;
		boolean b = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		
		/* if(b == true)
		 * System.out.println("윤 년")
		 */
		if(b) // (b == false)일 경우 (!b)로 많이 쓰임
			System.out.println("윤 년");
		else
			System.out.println("평 년");
		System.out.println();
		
		switch(month) {
		case 2:
			days = b?29:28; // b가 true면 윤년이므로 29, 아닐경우 평년이므로 28을 days에 저장
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
		}
		
		System.out.printf("%d년 %d월은 %d일까지 있습니다.", year, month, days);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
