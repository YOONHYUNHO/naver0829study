package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex07_Set {

	public static void main(String[] args) {
		
		
		// Set 인터페이스의 특징 1. 정렬x 2. 중복x
//		Set<Integer> set = new HashSet<Integer>(); // 비순차적
		Set<Integer> set = new TreeSet<Integer>(); // 오름차순
		// (컬렉션)size는 데이터의 수(배열은 length)
		System.out.println(set.size()); // 0
		set.add(30);
		set.add(1);
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);
		System.out.println(set.size()); // 3 (중복은 덮어씀)
		System.out.println("-".repeat(20));
		// 1. 컬렉션 출력
		for(Integer n:set) // set에 있는 데이터가 n으로
			System.out.println(n);
		System.out.println("-".repeat(20));
		// 2. 컬렉션 출력
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println("-------------");
	}

}
