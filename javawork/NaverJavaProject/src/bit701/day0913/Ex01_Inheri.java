package bit701.day0913;

class SuperA
{
	public void process()
	{
		System.out.println("부모가 처리하는 process ");
	}
}


class  SubA extends SuperA
{
	@Override
	public void process() {
		
		super.process();
		System.out.println("그림");
	}
}

class SubB extends SuperA
{
	@Override
	public void process() {
		super.process();
		System.out.println("야구");
	}
}

class SubC extends SuperA
{
	@Override
	public void process() {
		super.process();
		System.out.println("테니스");
	}
	
}


public class Ex01_Inheri {

	public static void main(String[] args) {
		
		
		// 서브 클래스로 선언 시 3개의 일을 처리하려면 3번 선언해야만 한다.
		SubA sub1 = new SubA();
		sub1.process();
		
		SubB sub2 = new SubB();
		sub2.process();

		SubC sub3 = new SubC();
		sub3.process();
		System.out.println("-".repeat(10));
		
		// 선언은 한 번, 3가지 일을 하려면 -> 부모로 선언
		// 부모로 선언 시 그 변수에 누가 생성되어있느냐에 따라서 똑같은 메서드를 호출하더라도 하는 일이 달라짐
		SuperA sub4 = null;
		sub4 = new SubA();
		sub4.process();
		
		sub4 = new SubB();
		sub4.process();
		
		sub4 = new SubC();
		sub4.process();
		
	}

}
