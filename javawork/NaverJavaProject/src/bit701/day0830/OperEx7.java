package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
	
		// 비교연산자, 논리연산자 결과 값은 true, false
		int kor = 100, eng = 90, mat = 100;
		System.out.println(kor >= 80); // true
		System.out.println(kor >= 80 || kor != mat); // true
		System.out.println(kor < 80 || kor != mat); // false
		System.out.println(kor >= 80 && kor != mat); // false
		System.out.println(!(kor==mat)); // false
		System.out.println(kor >= 95 && eng >= 95 && mat >= 95); // false
		System.out.println(kor >= 95 && eng >= 95 || mat >= 95); // true
		System.out.println(kor >= 95 || eng >= 95 && mat >= 95); // true
		
		
		
		int year = 2023;
		// 위의 년도가 윤년인지 아닌지
		System.out.println(year%4 == 0 && year%100 != 0 || year%400 == 0);
	}

}
