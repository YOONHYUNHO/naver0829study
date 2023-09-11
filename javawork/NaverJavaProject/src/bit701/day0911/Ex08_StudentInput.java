package bit701.day0911;

import java.util.Scanner;

public class Ex08_StudentInput {
	
	
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		int inwon;
		MyStudent[] stu;
		
		// 입력 할 인원 수를 입력한 후 배열 할당
		System.out.println("정보를 입력할 인원수는?");
		inwon = Integer.parseInt(sc.nextLine());
		stu = new MyStudent[inwon];
		
		// 할당한 갯수만큼 데이터 입력
		for(int i = 0; i < inwon; i++)
		{
			System.out.println(i + "번의 이름은?");
			String name = sc.nextLine();
			
			System.out.println(i + "번의 국어점수는?");
			int kor = Integer.parseInt(sc.nextLine());
			
			System.out.println(i + "번의 영어점수는?");
			int eng = Integer.parseInt(sc.nextLine());
			
			// MyStudent 해당 배열 번지를 생성
			stu[i] = new MyStudent(name, kor, eng);
		}
		
		// 출력
		System.out.println("이름\t국어\t총점\t평균\t등급");
		System.out.println("=".repeat(50));
		for(MyStudent my:stu)
		{
			System.out.println(my.getName() + "\t" + my.getKor() + "\t" + my.getEng() + "\t" + my.getTotal() + "\t" +
		my.getAverage() + "\t" + my.getGrade() );
			
		}
	}

}