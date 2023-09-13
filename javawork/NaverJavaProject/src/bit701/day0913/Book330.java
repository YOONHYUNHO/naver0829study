package bit701.day0913;

// 봉인된(sealed) 클래스 지정 - jdk15

sealed class Person permits Employee, Manager // 두 개의 자식 클래스만 허용
{
	public String name;
	
	public void work()
	{
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
}

// Employee 클래스는 더 이상 상속x(final)
final class Employee extends Person
{
	@Override
	public void work() {
		System.out.println("제품 생산");
	}
}

// 상속이 가능한 클래스(non-sealed)
non-sealed class Manager extends Person
{
	@Override
	public void work() {
		System.out.println("생산 관리");
	}
}

public class Book330 {

	public static void main(String[] args) {
		Person p = new Person();
		p.work();
		System.out.println("= = = = =");
		Employee e = new Employee();
		e.work();
		System.out.println("= = = = =");
		Manager m = new Manager();
		m.work();
		System.out.println("= = = = =");
		Person p2 = new Manager();
		p2.work();
	
	}

}
