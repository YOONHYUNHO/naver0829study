package bit701.day0911;


// 데이터 갯수를 모를때 사용하는 메서드 Variable ...args

public class Ex03_VarAge {
	public static int sum(int...n) 
	{
		System.out.println("총 " + n.length + "개");
		int s = 0;
		for(int i = 0; i < n.length; i++)
		{
			System.out.println(i + ":" + n[i]);
			s+=n[i];
		}
		return s;
	}
	
	public static void stringWrite(String ...str)
	{
		System.out.println("총 " + str.length + "개의 문자열");
		for(String s:str)
			System.out.println(s);
		System.out.println("=".repeat(30));
	}
	
	public static void main(String[] args) {
		
		// static mathod는 메서드명. 으로 작성 but 같은 클래스내에서는 생략 ㄴ가능
		int s1 = sum(4,6,8);
		
		System.out.println("총 합 = " + s1);
		
		int s2 = sum(10, 20 , 30, 40, 50);

		stringWrite("빨강", "노랑", "초록");
		stringWrite("소나타");
	}
}
