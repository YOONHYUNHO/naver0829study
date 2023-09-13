package bit701.day0912;
	
class SuperB 
{
	public void processA()
	{
		System.out.println("부모가 가진 메서드A");
	}
}

class SubB extends SuperB
{
	@Override // 어노테이션
	public void processA() {
		super.processA();
		System.out.println("자식이 가진 오버라이드메서트 A"); // 나머지는 자식 클래스에서 작업을 완성
	}
	
	public void processB()
	{
		System.out.println("자식만 갖고 있는 메서드 B");
	}
}


public class Ex06_InheriOverride {
	
	public static void main(String[] args) {
		
		SubB sub1 = new SubB();
		sub1.processA();
		sub1.processB();

		// 다형성의 기본 원리
		// 선언 - 부모클래스, 생성 - 자식클래스
		// processB는 호출 x , 자식이 가진것중 오버라이드된거만 호출이 가능하다.
		SuperB sub2 = new SubB();
		sub2.processA();  // 오버라이드된 자식이 가진 메서드가 호출
		
		
	}

}
