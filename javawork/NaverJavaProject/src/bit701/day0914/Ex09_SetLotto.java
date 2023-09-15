package bit701.day0914;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex09_SetLotto {

	public static void main(String[] args) {
		
		// 금액 입력하면 그 금액만큼 로또번호 생성, 출력
		
		Scanner sc = new Scanner(System.in);
		int money;
		System.out.println("로또 구입 금액 : ");
		try {
			money = Integer.parseInt(sc.nextLine());
			
			if(money < 1000) {
				System.out.println("금액 부족");
				return;
			}
			
			for(int i = 1; i <= money/1000; i++)
			{
				Set<Integer> setLotto = new TreeSet<Integer>();
				// 6개의 난수( 1 ~ 45 )
				while(true)
				{
					int n = (int)(Math.random()*45)+1;
					setLotto.add(n);
					
					if(setLotto.size() == 6)
						break;
				}
				
				System.out.printf("%2d회 : ", + i);
				for(Integer n:setLotto)
				{
					System.out.printf("%3d, " , n);
				}
				System.out.println();
			
				
				
			}
		} catch (NumberFormatException e) {
			System.out.println("금액은 숫자로만 입력 " + e.getMessage());
		}

	}

}
