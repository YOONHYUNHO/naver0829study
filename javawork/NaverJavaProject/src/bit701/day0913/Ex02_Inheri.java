package bit701.day0913;
// 1번 예제의 메서드들을 호출


public class Ex02_Inheri {
	
	
	// 인자를 SubA로 하면 SubA만 가능
//	public static void processPlay(SubA sub)
//	{
//		sub.process();
//	}
//	
//	public static void processPlay(SubB sub)
//	{
//		sub.process();
//	}
//	public static void processPlay(SubC sub)
//	{
//		sub.process();
//	}
	
	// 하나로 줄여서 만드려면 인자를 부모클래스로 선언
	public static void processPlay(SuperA sub)
	{
		// 서브클래스의 메서드 중 호출할 수 있는 메서드는 오버라이딩 메서드뿐이다.
		sub.process(); // sub변수에 누가 생성되어있느냐에 따라서 하는 일이 달라진다.
	}
	
	public static void main(String[] args) {
		processPlay(new SubA());
		processPlay(new SubB());
		processPlay(new SubC());
		System.out.println("-".repeat(10));
		
	}
}
