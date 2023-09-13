package bit701.day0912;


	class SuperA 
	{
		public void processA() {
			System.out.println("부모가 가진 메서드 A");
		}
		protected void processB() {
			System.out.println("부모가 가진 메서드 B");
		}
		private void processC() {
			System.out.println("부모가 가진 메서드 C");
		}
	}
	
	class SubA extends SuperA
	{
		public void show()
		{
			
			// this는 자기 자신의 주소를 가진 인스턴스 변수
			// this로 processA() 호출 시 현재 클래스에 없으면 부모로부터 찾아서 가져온다.
			this.processA();
			this.processB();
			
			// 부모의 주소 값을 가진 인스턴스 변수 super
			// 부모의 메서드를 자식이 오버라이딩한 경우vbn 
			super.processA(); // 부모의 메서드이므로 super로도 가져올 수 있다.
			super.processB();
		}
	}

	
public class Ex06_Inheri {
	
	public static void main(String[] args) {
		
		SubA sub1 = new SubA();
		sub1.processA();
		sub1.processB();
		// 상속 불가 (private는 패키지 상관 없이 호출 x)
//		sub1.processC(); 
		System.out.println("------------");
		sub1.show();
	}

}
