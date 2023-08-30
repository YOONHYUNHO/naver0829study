package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		System.out.print("apple\t");
		System.out.print("banana\t");
		System.out.println("orange\t");
		
		
		// printf : 변환기호에 의한 출력
		// 정수 : %d
		// 실수 : %f ex) %5.1f 전체자리수 : 5 , 소수점자리수 : 1
		// 문자 : %c
		// 문자열 : %s
		// \n : 줄넘김
		// \t : 다음 탭 위치로 이동
		int age = 23;
		double weight = 56.7;
		char blood = 'A';
		String name = "캐서린";
		
		System.out.printf("이름 : %s\n", name);
		System.out.printf("나이 : %d\n", age);
		System.out.printf("몸무게 : %3.1f\n", weight);
		System.out.printf("혈액형 : %c\n", blood);
		System.out.println("===================");
		System.out.printf("이름 : %s\n나이 : %d세\n몸무게 : %3.1fkg\n혈액형 : %c형\n ", name, age, weight, blood);
	}

}
