package bit701.day0914;

import java.util.HashMap;
import java.util.Map;

public class Ex10_Map {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("이름", "김태희");
		map.put("age", "30세");
		map.put("addr", "강남구");
		// 같은 key 값이 존재할 경우 덮어쓴다.
		map.put("이름", "송혜교");
		
		System.out.println("갯수 : " + map.size());
		// Key 값을 알아야 value 값을 얻을 수 있다.
		System.out.println("이름 " + map.get("name"));
		System.out.println("나이 " + map.get("age"));
		System.out.println("주소 " + map.get("addr"));
		System.out.println("혈액형 " + map.get("blood")); // 해당 key 값이 없을 경우 null 반환
	
		// 제거 - null 값 반환
		map.remove("addr");
		System.out.println("주소 " + map.get("addr"));

	}

}
