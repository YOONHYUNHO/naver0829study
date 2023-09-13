package bit701.day0913;

abstract class Tire
{
	// 추상 메서드 생성
	abstract public void roll();
}

class HankookTire extends Tire
{
	@Override
	public void roll() {
		System.out.println("한국 타이어 회전");
	}
}

class KumhoTire extends Tire
{
	@Override
	public void roll() {
		System.out.println("금호 타이어 회전");
	}
}

class Car {
	public Tire tire; // 초기값이 null
	
	public void run()
	{
		tire.roll(); // tire에 new로 생성 안한 상태에서 호출 시 NullPointerException 발생
	}
}

public class Book314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.tire = new HankookTire();
		car.run();
		
		car.tire = new KumhoTire();
		car.run();
	}

}
