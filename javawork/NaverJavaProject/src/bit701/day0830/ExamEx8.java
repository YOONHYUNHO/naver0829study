package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
	
		/* money 변수에 args[0] 값을 대입 후 (급여 백만 단위 : 5674321)	
		 * 
		 * 출력 
		 * money = 5674321 원
		 * 만원 : 567장
		 * 천원 : 4장
		 * 백원 : 3개
		 * 십원 : 2개
		 * 일원 : 1개
		 * : 산술연산자를 사용해서 출력
		*/
		
		//파라미터에서 월급여를 읽어서(문자열) 정수타입으로 변환
		int money = Integer.parseInt(args[0]);
		System.out.println("money = " + money + "원");
		System.out.println("만원 = " + money/10000 + "장");
		System.out.println("천원 = " + (money%10000)/1000 + "장");
		System.out.println("백원 = " + (money%1000)/100 + "개");
		System.out.println("십원 = " + (money%100)/10 + "개");
		System.out.println("일원 = " + (money%10) + "개");
		
	}

}
