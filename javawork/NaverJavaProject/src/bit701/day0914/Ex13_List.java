package bit701.day0914;

import java.util.Vector;

// List 인터페이스를 구현한 Vector / ArrayList 연습

public class Ex13_List {
	
	public static void main(String[] args) {
		Vector<String> list1 = new Vector<String>(); // 기본 10개(10개씩 증가)
		System.out.println("list1의 할당 수 :" + list1.capacity());
		
		Vector<String> list2 = new Vector<String>(5); // 기본 5개(5개씩 증가)
		System.out.println("list2의 할당 수 :" + list2.capacity());

		Vector<String> list3 = new Vector<String>(3, 2); // 기본 3개(2개씩 증가)
		System.out.println("list3의 할당 수 :" + list3.capacity());
		
		list3.add("red");
		list3.add("green");
		list3.add("blue");
		list3.add("pink");
		
		System.out.println("list3의 할당 수 : " + list3.capacity());
		System.out.println("list3의 데이터 수 : " + list3.size());
		
	}

}
