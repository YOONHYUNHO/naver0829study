package bit701.day0911;

public class Ex10_CallBy {
	
	
	// Call by value : 값만 전달된다.(주소 전달 X)
	// 모든 기본형과 String 타입은 값만 전달된다.
	public static void changeInt(int a)
	{
		System.out.println("전달 받은 a 값 : " + a);
		
		// a값 변경
		a = 20;
		System.out.println("변경 후 a 값 : " + a);
	}
	
	
	// Call by Reference
	// 모든 배열은 주소를 전달(배열은 무조건 객체 타입으로 인식)
	public static void changeArray(int[] arr)
	{
		System.out.println("전달받은 배열 값 확인");
		for(int a:arr)
			System.out.print(a + "\t");
		System.out.println("\n1번지 값 변경");
		arr[1] = 100;
	}
	
	public static void main(String[] args) {
		
		int a = 10;
		changeInt(a);
		System.out.println("main a = " + a);
	
		int[] arr = {3,4,5};
		changeArray(arr);
		for(int n:arr)
			System.out.print(n + "\t");
		System.out.println();
	}
}
