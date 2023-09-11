package bit701.day0911;

import java.util.Scanner;

public class Book_BankApplication {

	public static void main(String[] args) {

		
		Account[] account = new Account[10];
		Scanner sc = new Scanner(System.in);
		int idx = 0;
		// 배열 10개 초과 시 "더 이상 계좌 생성이 불가합니다." 출력
		while(true)
		{
			System.out.println("1.계좌생성\t2.계좌목록\t3.예금\t4.출금\t5.종료");
			System.out.println("=".repeat(60));
			System.out.print("선택 >");
			int ch = Integer.parseInt(sc.nextLine());
			
			if(ch == 5) 
			{
				System.out.println("프로그램 종료");
				break;
			} 
			
			switch(ch) 
			{
				case 1:
				{
					if(idx >= 10) {
						System.out.println("더 이상 계좌 생성이 불가합니다.");
						break;
					}
					System.out.println("계좌생성");
					System.out.print("계좌번호 입력 : ");
					String accountNo = sc.nextLine();
					System.out.print("계좌주 입력 : ");
					String accountName = sc.nextLine();
					System.out.print("초기 입금액 입력 : ");
					int money = Integer.parseInt(sc.nextLine());
				
					account[idx] = new Account(accountNo, accountName, money);
					System.out.println("계좌 생성 완료");
					idx++;
					break;
				}
				
				case 2:
					System.out.println("계좌목록");
					for(int i = 0; i < idx; i++)
					{
						account[i].accountWrite();
					}
					break;
				case 3:
				{
					System.out.println("예금");
					System.out.print("계좌번호 : ");
					String accountNo = sc.nextLine();
					System.out.print("예금액 : ");
					int money = Integer.parseInt(sc.nextLine());
					
					// 계좌번호를 찾은 후 그 배열번지 money에 추가
					for(int i = 0; i < idx; i++)
					{
						if(account[i].isAccount(accountNo))
						{
							account[i].addMoney(money);
							break;
						}
					}
					System.out.println("결과 : 예금 완료");
					break;
				}
				case 4:
				{
					System.out.println("출금");
					System.out.print("계좌번호 : ");
					String accountNo = sc.nextLine();
					System.out.print("출금액 : ");
					int money = Integer.parseInt(sc.nextLine());
					
					// 계좌번호를 찾은 후 그 배열번지 money에서 빼기
					for(int i = 0; i < idx; i++)
					{
						if(account[i].isAccount(accountNo))
						{
							account[i].subMoney(money);
							break;
						}
					}
					System.out.println("결과 : 출금 완료");
					break;
				}
			} // switch
			System.out.println();
		} // while
	} // main

} // class
