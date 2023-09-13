package bit701.day0912;

import java.util.StringTokenizer;

public class Ex04_Split {
	
	public static void main(String[] args) {
		String str1 = "red,blue,green,orange,gray";
		// 문자열을 ,로 분리해서 배열에 저장
		
		String[] strArray = str1.split(",");
		System.out.println("총 " + strArray.length + "개로 분리");
		for(int i = 0; i < strArray.length; i++)
		{
			System.out.println(i + " : " + strArray[i] );
		}
		System.out.println("-".repeat(20));
	
		String str2 = "sea.jpg";
		String[] str2Array  = str2.split("[.]");
		String[] str2Array1  = str2.split("\\.");
		System.out.println(str2Array[0]);
		System.out.println(str2Array[1]);
		System.out.println(str2Array.length);
		
		String str3 = "red|green|yellow";
		String[] str3Array = str3.split("[|]");
		System.out.println(str3Array.length);
		
		for(int i = 0; i < str3Array.length; i++)
		{
			System.out.println(i + " : " + str3Array[i]);
		}
		
		// 자바의 클래스를 이용해서 분리
		StringTokenizer st = new StringTokenizer(str1, ",");
		System.out.println("총 " + st.countTokens() + "개로 분리");
		while(st.hasMoreTokens()) // 다음 분리할 토큰이 있으면 true, 더 이상 없으면 false
		{
			System.out.println(st.nextToken());
		}
		System.out.println("-".repeat(20));

		
		StringTokenizer st2 = new StringTokenizer(str1, ",");
		int count = st2.countTokens();
		for(int i = 0; i < count; i++)
		{
			System.out.println(st2.nextToken());
		}
	}
}
