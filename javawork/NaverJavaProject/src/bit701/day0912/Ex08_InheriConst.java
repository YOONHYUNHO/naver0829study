package bit701.day0912;

class SuperC
{
	protected String name;
	protected int age;
	
	public SuperC()
	{
		System.out.println("부모의 디폴트 생성자 호출");
		name = "홍길동";
		age = 10;
	}
	
	SuperC(String name, int age)
	{
		System.out.println("부모의 두번째 생성자 호출");
		this.name = name;
		this.age = age;
	}
}


class SubC extends SuperC
{
	String hp;
	
	SubC()
	{
		super(); // 디폴트, 내부적으로 호출
		System.out.println("자식 클래스의 디폴트 생성자 호출");
		hp = "010-111-222";
	}
	
	SubC(String hp)
	{
		// 부모클래스가 무조건 먼저 호출
		System.out.println("자식 클래스의 두 번째 생성자 호출");
		this.hp = hp;
	}
	
	// 부모 protected 변수
//	SubC(String name, int age, String hp)
//	{
//		System.out.println("자식 클래스의 세 번째 생성자 호출");
//		this.name = name;
//		this.age = age;
//		this.hp = hp;
//	}
	
	// private 변수
	SubC(String name, int age, String hp)
	{
		super(name, age);
		System.out.println("sub의 세번째 생성자 호출");
		this.hp = hp;
	}
	
	
	
	
	public void dataShow()
	{
		// 부모클래스의 멤버변수가 protected이므로 패키지 상관 없이 접근 가능
//		System.out.println("이름 : " + this.name);
//		System.out.println("나이 : " + this.age);
		System.out.println("이름 : " + super.name); // 부모가 가진 변수는 this, super 모두 가능
		System.out.println("나이 : " + this.age);
		System.out.println("번호 : " + this.hp);
		System.out.println("-".repeat(30));
	}
}

public class Ex08_InheriConst {	
	
	public static void main(String[] args) {
		
		
		
		SubC sub1 = new SubC();
		sub1.dataShow();
		
		SubC sub2 = new SubC("010-9999-0000");
		sub2.dataShow();
		
		SubC sub3 = new SubC("캔디", 12, "02-455-788");
		sub3.dataShow();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
