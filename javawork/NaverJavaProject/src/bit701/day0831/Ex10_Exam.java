package bit701.day0831;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {

		
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
		
		
		// 선언 
		Scanner sc = new Scanner(System.in);
		NumberFormat numFormat = NumberFormat.getInstance();
		
		String sangpum = "";
		int su = 0, dan = 0, total = 0;
		
		// 입력
		System.out.println("상품명");
		sangpum = sc.nextLine();
		System.out.println("수량");
		su = sc.nextInt();
		System.out.println("단가");
		dan = sc.nextInt();
		
		// 계산
		// 총금액
		total = su * dan;
		
		// 출력
		
		System.out.println("총금액 = " + numFormat.format(total) + "원");
		
		// 5개 이상 할인 받는 조건
		if(su >= 5) {
			total = (int)(total*0.9);
			System.out.printf("5개 이상 10프로 할인 금액 : %d원 \n", total);
			System.out.printf("5개 이상 10%% 할인 금액 : %s원 \n", numFormat.format(total)); // 문자열
			System.out.printf("5개 이상 10%% 할인 금액 : %s원 \n", NumberFormat.getCurrencyInstance().format(total));
		}
		
		
		
		/* 
		System.out.println("상품 : ");
		String fr = sc.nextLine();
		
		System.out.println("수량 : ");
		int cn = sc.nextInt();
		
		System.out.println("단가 : ");
		int pr = sc.nextInt();
		
		int rs = (cn * pr);
		
		System.out.println("총금액 : " + rs);
		
		
		NumberFormat nf = NumberFormat.getInstance();
		String total = nf.format((rs-(rs/10)));
		
		
		
		if(cn >= 5)
			System.out.println("할인 금액 : " + (total));
		else
			System.out.println();
			
		*/
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
