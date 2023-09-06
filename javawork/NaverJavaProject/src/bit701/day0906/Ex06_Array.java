package bit701.day0906;

import java.util.Scanner;

public class Ex06_Array {

	public static void main(String args[]) {
		
		// 입력한 숫자만큼 String 배열을 할당하고 이름 입력 받아서 출력
		Scanner sc = new Scanner(System.in);
		String[] names;
		int count;
		
		System.out.println("할당할 갯수를 입력하세요");
		count = Integer.parseInt(sc.nextLine());
		
		// names 배열을 count 갯수만큼 할당
		names = new String[count];
		
		// 할당한 갯수만큼 이름 입력
		for(int i = 0; i < names.length; i++) 
		{
			System.out.println(i + "번 이름은 ? ");
			names[i] = sc.nextLine();
		}
		
		// 출력
		System.out.println("번호 \t:이름");
		
		for(int i = 0; i < names.length; i++)
		{
			System.out.println(i + 1 + "\t" + names[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
