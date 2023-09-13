package bit701.day0913;

class Parent
{
	public void method1()
	{
		System.out.println("parent - method1()");
	}
	public void method2()
	{
		System.out.println("parent - method2()");
	}
}

// 상속 받는 클래스 구현
class Child extends Parent
{
	@Override
	public void method2() {
		System.out.println("Child - method2()");
	}
		
	public void method3() {
		System.out.println("Child - method3()");
	}
	
	
}

public class Book309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child a = new Child();
		a.method1();
		a.method2();
		a.method3();
		System.out.println("-".repeat(20));
		
		Parent b = new Child();
		b.method1();
		b.method2();
		((Child)b).method3(); // 강제 형변환 후 호출 가능
	}

}
