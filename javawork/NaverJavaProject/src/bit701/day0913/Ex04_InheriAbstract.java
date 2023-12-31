package bit701.day0913;


abstract class AbstEx1 {
	int a = 100;
	final String str = "abstract test"; // 상수
	public String getStr()
	{
		return str;
	}
	
	// 추상 메서드 추가(미완성 메서드)
	abstract public int getA();
}


abstract class AbstEx2 extends AbstEx1
{
	@Override
	public int getA() {
		return a;
	}
	
	// 새로운 추상 메서드를 추가
	abstract public void show();
}


class AbstEx3 extends AbstEx2
{
	@Override
	public void show() {
		System.out.println("마지막 기능구현 클래스");
	}
}
public class Ex04_InheriAbstract {

	public static void main(String[] args) {
//		AbstEx1 ex1 = new AbstEx1(); // 오류 발생 - abstract 클래스는 객체 생성x

//		AbstEx1 ex1 = new AbstEx2(); // show 메서드를 추가한 후 오류 발생
//		System.out.println("a = " + ex1.getA());
//		System.out.println("str = " + ex1.getStr());
	
		AbstEx3 ex3 = new AbstEx3();
		System.out.println("a = " + ex3.getA());
		System.out.println("str = " + ex3.getStr());
		ex3.show();
		
		System.out.println("-----");
		
		AbstEx1 ex4 = new AbstEx3();
		System.out.println("a = " + ex4.getA());
		System.out.println("str = " + ex4.getStr());
		// ex4.show(); // 오류 발생 show()는 AbstEx2에서 선언
		
		
	}

}
