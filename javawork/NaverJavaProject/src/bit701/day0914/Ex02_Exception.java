package bit701.day0914;

import java.util.Scanner;

public class Ex02_Exception {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
		
			try {
				System.out.println("숫자 1 입력");
				int su1 = Integer.parseInt(sc.nextLine());
				if(su1 == 0)
					break;
				System.out.println("숫자 2 입력");
				int su2 = Integer.parseInt(sc.nextLine());
				
				int div = su1/su2;
				// TODO Auto-generated catch block
			System.out.printf("%d 나누기 %d는 %d입니다.", su1, su2, div);
			System.out.println();
			} catch (NumberFormatException e) {
				System.out.println("문자 입력" + e.getMessage());
			} catch (ArithmeticException e) {
				System.out.println(" 0 입력" + e.getMessage());
			} finally {
				// 예외 여부 상관없이 무조건 실행 되는 영역
				System.out.println("무조건 실행");
			}
		}
		
		System.out.println("정상 종료");

	}

}
