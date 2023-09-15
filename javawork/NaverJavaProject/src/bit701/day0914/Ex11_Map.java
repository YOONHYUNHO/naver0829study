package bit701.day0914;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex11_Map {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "권은비");
		map.put("score", "90");
		map.put("blood", "AB");
		map.put("ipsaday", "1996-02-25");
		map.put("hp", "010-2222-2222");
		
		// key 값들을 얻은 후 key에 해당하는 value를 찾음
		Set<String> keys = map.keySet();
		for(String key:keys)
		{
			String v = map.get(key);
			System.out.println(key + " : " + v);
		}
	}

}
