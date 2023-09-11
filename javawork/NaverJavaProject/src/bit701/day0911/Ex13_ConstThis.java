package bit701.day0911;

/* this : 자기 자신을 의미하는 인스턴스 변수(iv)
 * 			인스턴스 멤버 메서드는 this라는 변수를 기본적으로 가지고 이싿.
 * this() : 생성자에서 다른 생성자 호출 시 사용하는 이름이다.
 */


class Kiwi 
{
	String name;
	int age;
	
	
	// 디폴트 생성자
	Kiwi()
	{	// this() :  생성자 호출 , 반드시 첫 줄에 출력 해야한다.
		this("홍길동", 20); // 3번째 생성자가 호출
	}
	
	// 이름만 변경 생성자
	Kiwi(String name) 
	{	// this() :  생성자 호출
		this(name, 30); // 3번째 생성자가 호출
	}
	
	// 이름, 나이 변경 생성자
	Kiwi(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	// 출력
	public void writeData()
	{
		System.out.println("name : " + name + "\tage : " + age);
	}
}

public class Ex13_ConstThis {

	public static void main(String[] args) {
		Kiwi[] karr = {
				new Kiwi(),
				new Kiwi("kim"),
				new Kiwi("lee", 35)
		};
		for(Kiwi k:karr)
			k.writeData();
		
	}

}
