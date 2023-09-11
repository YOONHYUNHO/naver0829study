package bit701.day0911;


class CallBy
{
	String name;
	String addr;
	String hp;
	
	// 생성자
	CallBy(String name, String addr, String hp) 
	{
		this.name = name;
		this.addr = addr;
		this.hp = hp;
	}
}
public class Ex11_CallBy {
	
	
	// Call By Reference : 주소 전달
	// 멤버 값 변경 시 main의 by 변수의 멤버 값도 변경된다.
	public static void changeCallBy(CallBy by)
	{
		by.addr= "서초구";
	}
	
	public static void writeData(CallBy by)
	{
		System.out.println("이름 : " + by.name);
		System.out.println("주소 : " + by.addr);
		System.out.println("핸드폰 : " + by.hp);
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		CallBy by = new CallBy("김이사", "강남구", "010-222-3333");
		System.out.println("** 초 기 값 출 력 **");
		writeData(by);
		System.out.println("** 값 변 경 후 출 력 **");
		changeCallBy(by);
		writeData(by);
	}

}
