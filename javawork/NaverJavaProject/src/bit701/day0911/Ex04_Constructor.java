package bit701.day0911;


/* 생성자의 규칙
 * 1. 반드시 클래스명과 같은 메서드명
 * 2. 리턴타입이 없다.
 * 3. 오버로딩 가능
 * 4. 주로 멤버변수의 초기화를 담당
*/
class Car {
	private String carName;
	private	int carPrice;
	
	// 디폴트 생성자
	Car()
	{
		System.out.println("디폴트 생성자 호출");
		carName = "그랜저";
		carPrice = 3500;
	}
	
	// 생성자를 통해서 외부에서 값을 받아서 초기화
	Car(String carName, int carPrice) 
	{
		System.out.println("생성자 2 호출");
		this.carName = carName;
		this.carPrice = carPrice;
	}
	
	public void carShow()
	{
		System.out.println("자동차명 : " + carName + ", 단가 : " + carPrice );
	}
}

public class Ex04_Constructor {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.carShow();
		
		Car c2 = new Car("지바겐", 25000);
		c2.carShow();
	}

}
