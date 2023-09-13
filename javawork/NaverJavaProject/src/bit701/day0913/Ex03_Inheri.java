package bit701.day0913;

// 다형성 처리 시 부모가 하는 일이 없을 경우
// 오버라이딩을 위해서 메서드 생성


/* 추상 클래스 특징
 *	1. 일반 메서드와 미완성의 abstract 메서드 둘 다 구현 가능
 *	2. abstract(추상) 클래스는 new로 객체 생성 x
 *	3. 추상 클래스를 상속 받는 클래스는 반드시 추상 메서드를 오버라이딩 해서 기능을 구현해야만한다.
 *	4. 추상 메서드를 오버라이드 안할 경우 서브클래스도 역시 추상화시켜야만한다.
 */

abstract class SuperColor 
{
//	public void draw()
//	{
//		// 부모클래스가 하는 일이 없으므로 안에 내용도 없음
//	} ---->
	// 오버라이드를 위해서 {}를 제거
	// abstract : 추상화 - 미완성적인 메서드
	// 클래스의 멤버 메서드중 한 개 이상의 추상 메서드가 있는경우
	// 반드시 클래스도 추상화시켜야 한다. 즉 class 앞에 abstract를 붙인다
	abstract public void draw();
	
	// 오버라이드 안할 경우 호출 가능
	// 서브클래스에만 있는 메서드는 호출 불가능(부모로 선언 시)
	public void parentJob()
	{
		System.out.println("부모는 오늘도 돈을 벌어온다.");
	}
}

class SubRed extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("청소");
	}
}

class SubGreen extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("식사");
	}
}

class SubBlue extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("설거지");
	}
}


public class Ex03_Inheri {
	
	public static void draw(SuperColor s)
	{
		s.parentJob(); // 부모가 갖고있는 메서드 호출(오버라이드 x)
		s.draw();
	}
	
	public static void main(String[] args) {

		
		draw(new SubBlue());
		draw(new SubRed());
		draw(new SubGreen());
	}

}
