package bit701.day0914;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex14_List {
	public static void main(String[] args) {
		
		
		// List는 데이터를 순차적으로 저장o, 중복o(<-> Set)
		List<String> list = new Vector<String>();
		list.add("장미");
		list.add("안개꽃");
		list.add("장미");
		list.add("할미꽃");
		list.add("국화");
		
		// 1. 출력 방법
		for(int i = 0; i < list.size(); i++)
		{
			String s = list.get(i);
			System.out.print(s + " ");
		}
		System.out.println("\n--------------------");
		
		// 2. 출력 방법
		for(String s:list)
			System.out.print(s + " ");
		System.out.println("\n--------------------");
		
		// 3. 출력 방법
		Iterator<String> iter = list.iterator();
			while(iter.hasNext())
				System.out.print(iter.next() + " ");
			System.out.println("\n----------------------");
		// 4. 출력 방법
			Object[] data = list.toArray();
			for(Object ob : data)
				System.out.print((String)ob + " ");
	}
}

