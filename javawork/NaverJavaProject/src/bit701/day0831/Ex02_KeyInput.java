package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex02_KeyInput {

	public static void main(String[] args) {
		
		/* Date 클래스를 이용해서 현재 년도 구현(jdk1.1 에서 deprecate 되었지만 여전히 많이 사용)
		 * 권장 : Calendar
		 */
		Date date = new Date();
		
		// getYear는 1900 마이너스 한 값이 반환
		int curYear = date.getYear()+1900;
		System.out.println("현재 년도 : " + curYear);

		
		Scanner sc = new Scanner(System.in);
		System.out.println("출생 연도 : " );
		int birthYear = Integer.parseInt(sc.nextLine());
		
		System.out.println("현재 거주지 : ");
		String address = sc.nextLine();
		
		
		// 나이 구하기
		int age = curYear-birthYear;
		System.out.println("저는 " + address +"에 사는 " + birthYear +"년생("+age+"세) 학생입니다.");
		System.out.printf("저는 %s에 사는 %d년생(%d세) 학생입니다.\n", address, birthYear, age);

		
		/* 20세 이상이면 "성인", 미만이면 "미성년자"라는 글자를 출력
		 * if문 or 삼항연산자
		 */
		
		String msg = age >= 20 ? "성인" : "미성년자";
		System.out.println("당신은 " + msg);
		
		
		// if
		// 지역변수(lv)는 자동 초기화 X, 초기화를 진행, 구역을 벗어나면 자동소멸, 사용불가
		String msg1 = ""; 
		if(age >= 20)
			msg1 = "성인";
		else
			msg1 = "미성년자";
		System.out.println(msg1);
	}

}
