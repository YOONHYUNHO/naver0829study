package bit701.day0831;

import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		/* 상품명과 수량, 단가를 각각 입력받은 후 총금액을 출력
		 * 수량이 5개 이상일 경우 10프로 할인된 최종 금액도 출력
		 * 
		 * (예)
		 * 상품명 : 딸기
		 * 수량 : 6
		 * 단가 : 1000
		 * 
		 * 총금액 : 6000원
		 * 할인 금액 : 5400원
		 */
		
		System.out.println("상품 : ");
		String fr = sc.nextLine();
		
		System.out.println("수량 : ");
		int cn = sc.nextInt();
		
		System.out.println("단가 : ");
		int pr = sc.nextInt();
		
		System.out.println("총금액 : " + cn * pr);
		
		int rs = (cn * pr);
		
		if(cn >= 5)
			System.out.println("할인 금액 : " + (rs-(rs/10)));
		else
			System.out.println();
			
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
