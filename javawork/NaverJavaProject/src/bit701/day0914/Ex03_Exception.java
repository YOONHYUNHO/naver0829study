package bit701.day0914;

import java.util.Date;
import java.util.Scanner;

public class Ex03_Exception {
	
	
	// 호출하는 곳으로 예외를 던진다
	public static void dataInput() throws NumberFormatException, NullPointerException
	{
		Scanner sc = new Scanner(System.in);
		Date date = new Date();
		System.out.println("년도" + (date.getYear()+1900));
		System.out.println("두 개의 숫자를 입력");
		int su1 = Integer.parseInt(sc.nextLine());
		int su2 = Integer.parseInt(sc.nextLine());
		System.out.printf("%d + %d = %d\n" , su1, su2, su1+su2);
	}

	public static void main(String[] args) {
		
		// 호출- 1. 예외 던지기 2. try-catch
//		try {
//			dataInput();
//		} catch (NumberFormatException e) {
//			System.out.println("숫자를 입력하세요 "+ e.getMessage());
//		} catch (NullPointerException e) {
//			System.out.println("날짜 생성하세요" + e.getMessage());
//		}
		try {
			dataInput();
		} catch (NumberFormatException|NullPointerException e) {
			System.out.println("날짜생성 or 숫자 입력" + e.getMessage());
		}
		System.out.println("정상 종료");

	}

}
