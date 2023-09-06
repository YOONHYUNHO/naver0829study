package bit701.day0906;

public class Ex02_Array {

	public static void main(String args[]) {
		
		// 배열 선언 시 초기값을 주는 경우
		int[] arr = 
		{
			5,8,10,4,20	
		};  // 5개로 배열이 할당
		
		System.out.println("arr의 할당 갯수 : " + arr.length);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print( arr[i] + " ");
		}
		
		System.out.println();
		
		for(int n:arr)
		{			
			System.out.print( n +" ");
		}
		
		System.out.println("=".repeat(30));
		
		int[] arr2;
		arr2 = new int[] {3, 6, 8, 10, 30}; // 선언 후 나중에 값을 지정
		
		for(int i = 0; i < arr2.length; i++) 
		{
			System.out.printf("[%2d : %2d]", i ,arr2[i]);
		}
		System.out.println();
		
		for(int n:arr2)
		{
			System.out.printf("%3d", n);
		}
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
