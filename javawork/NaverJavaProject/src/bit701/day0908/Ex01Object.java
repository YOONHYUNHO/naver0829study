package bit701.day0908;

import bit701.day0908.hello.*;

public class Ex01Object {

	public static void main(String[] args) {
		
		MyHello my = new MyHello();
		my.hello();
	
		// 같은 패키지에 있는 클래스 선언
		
		/* 다른 클래스라도 같은 패키지일 경우 private 제외하고 모두 접근가능, 
		 * 패키지가 다를 경우는 상속관계가 아닐 경우 public만 유일하게 접근 가능
		*/
		
		Test t = new Test();
		
		System.out.println("public 멤버 변수 출력 " + t.str1);
		System.out.println("protected 멤버 변수 출력 " + t.str2);
		System.out.println("default 멤버 변수 출력 " + t.str3);
		System.out.println("private 멤버 변수 출력 " + t.str4);
	}

}
