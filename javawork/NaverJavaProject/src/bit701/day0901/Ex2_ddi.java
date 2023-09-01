package bit701.day0901;

import java.util.Scanner;

public class Ex2_ddi {
	
	public static void main(String[] args) {
		// 태어난 연도를 입력받아 띠를 구해보세요
		// 닭(1) 개 돼지 쥐 소 호랑이 토끼 용 뱀 말 양 원숭이(0)
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" 태어난 해 : ");
		int year = sc.nextInt();
		// 12로 나눈 나머지를 구한다.
		int m = year % 12;
		// 서기 1년은 닭띠 .. 12년 원숭이
		String ddi = m == 0? "원숭이" : m == 1? "닭" : m == 2? "개": m == 3? "돼지": m == 4? "쥐": m == 5? "소"
				: m == 6? "호랑이": m == 7? "토끼": m == 8? "용": m == 9? "뱀": m == 10? "말": "양";
		System.out.println(year + "년생은" + ddi + "띠입니다.");
	}
}
