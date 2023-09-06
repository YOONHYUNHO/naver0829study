package bit701.day0906;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Ex12_ArraySearchName {

	public static void main(String args[]) {
		
		String[] names = {"강호동", "유재석", "한채영", "이효리", "이승기",
				"김남길",	"이민정", "이서진", "손미나", "유미리"};
		/*
		 *  검색할 성은? 이
		 *  			4:이효리
		 *  			5:이승기
		 *  			.
		 *  			.
		 *  			8:이서진
		 *  			총: 4명
		 *  
		 *  검색할 성은? 박
		 *  			 '박'씨 성을 가진 멤버는 없습니다.
		 *  검색할 성은? 끝
		 *  			 종료합니다.
		 *  
		 *  변수 : String searchSung
		 *  	   int count;
		 *  	   boolean bFind;
		 *  
		 *  startsWith()
		*/
	
		Scanner sc = new Scanner(System.in);
		
		// 선언
		String searchSung;
		int count = 0;
		boolean bFind;
		
		
		
		// 입력
		while(true)
		{
			count = 0;
			bFind=false;
			
			System.out.println("검색할 성은?");
			searchSung = sc.nextLine();
			
			// 종료
			if(searchSung.equals("끝"))
			{
				System.out.println("종료합니다.");
				break;
			}
			
			for(int i = 0; i < names.length; i++)
			{
				if(names[i].startsWith(searchSung))
				{
					bFind = true;
					count++;
					System.out.println(i+1 + ":" + names[i]);
				}
			}
			if(bFind) 
				System.out.println("** 총 " + count + "명 **");
			else
				System.out.printf("\"%s\" 씨 성을 가진 멤버는 없습니다.\n",searchSung);
		}
		
		
		
		
		
		
		
		
		
	}
}
