package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex08_Set {

	public static void main(String[] args) {
		
//		Set<String> set = new HashSet<String>();
		Set<String> set = new TreeSet<String>();
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("green");
		set.add("green");
		set.add("blue");
		set.add("red");
		set.add("yellow");
		System.out.println(set.size());
		for(String s:set)
			System.out.println(s);
		
	}

}
