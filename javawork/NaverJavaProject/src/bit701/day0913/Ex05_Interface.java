package bit701.day0913;

/* Interface는 기능 구현을 할 메서드들의 목록을 나열
 * 상수와 추상 메서드만 구현 가능
 * 구분할 필요가 없기 때문에 final, abstract 생략 가능
 * Interface도 new로 생성 불가
 */

interface InterA 
{
	int SCORE = 100; // 상수
	public void play(); // 추상 메서드
	public void study(); // 추상 메서드
}

/*
 * 일반 클래스가 interface로 구현 - implements
 * 인터페이스를 구현한 경우 반드시 모든 메서드를 오버라이드해야만 한다.
*/
class My implements InterA 
{
	
	int myscore = SCORE;
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("SCORE = " + SCORE); // 상수 출력
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		// SCORE = 90; // 오류 발생, FINAL 상수
		myscore = 80;
		System.out.println("점수 변경 = " + myscore);
	}
	
	// My 클래스만이 가지고 있는 메서드 생성
	public void processMy()
	{
		System.out.println("My 클래스 단독 처리");
	}
	
}

public class Ex05_Interface {

	public static void main(String[] args) {
		
		InterA a = new My();
		a.play();
		a.study();
//		a.processMy(); // 오류 발생 - 오버라이드 메서드 x , My로 선언 시 호출 가능
		System.out.println("--------------------");
		
		My b = new My();
		b.play();
		b.study();
		b.processMy();
		
		
		
	}

}
