package bit701.day0911;

import java.util.Scanner;

public class Ex09_SawonInput {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
	
		// 3명의 사원에 대한 정보 입력후 배열 생성하기
		int sawon;
		Sawon[] sw;
		
		System.out.println("사원 수");
		sawon = Integer.parseInt(sc.nextLine());
		sw = new Sawon[sawon];
		
		// 할당한 갯수만큼 데이터 입력
		for(int i = 0; i < sawon; i++)
		{
			System.out.println(i+1 + "번의 이름은?");
			String name = sc.nextLine();
			
			System.out.println(i+1 + "번의 기본급은?");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.println(i+1 + "번의 수당은?");
			int sudang = Integer.parseInt(sc.nextLine());
			System.out.println(i+1 + "번의 가족수는?");
			int familysu = Integer.parseInt(sc.nextLine()); 
			
			// Sawon 해당 배열 번지를 생성
			sw[i] = new Sawon(name, gibon, sudang, familysu);
		}
		
		// 출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
		
		for(Sawon sa:sw)
		{
			System.out.println(sa.getName() + "\t" + sa.getGibon() 
			+ "\t" + sa.getSudang() + "\t" + sa.getFamilysu() + "\t" 
			+ sa.getFamilySudang() + "\t" + sa.getTax() + "\t" + sa.getNetPay() + "\t" );
		}
	}

}
