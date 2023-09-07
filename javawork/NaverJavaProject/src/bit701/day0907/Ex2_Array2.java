package bit701.day0907;

public class Ex2_Array2 {
	public static void main(String[] args) {
		
		
		
		// 2차원 배열 선언 방법
		
		// 1번째 방법
		int[][] arr = new int[2][3];
		System.out.println("행 : " + arr.length);
		System.out.println("0번 행의 열: " + arr[0].length);
		System.out.println("1번 행의 열: " + arr[1].length);
		
		
		arr[0][1] = 3;
		arr[1][1] = 5;
		
		System.out.println("첫번째 배열 출력");
		arrayWrite(arr);
		
		// 2번째 방법
		int[][] arr2 = {
				{1,2}, {3,4,5}, {10,20,30,40}
		}; // 0번행 열 : 2개 , 1번행 열 : 3개, 2번행 열 : 4개
		System.out.println(" ** 2번째 배열 출력 ** ");
		
		arrayWrite(arr2);
		
		// 3번째 방법
		int[][] arr3;
		arr3 = new int[][ ]{{1,2}, {1,2,3}, {4,5,6,7}};
		System.out.println("** 3번째 배열 출력 **");
		
		arrayWrite(arr3);
		
	}
	
	public static void arrayWrite(int[][] arr)
	{
				// 행
				for(int i = 0; i < arr.length; i++)
				{
					// 열
					for(int j = 0; j < arr[i].length; j++) 
					{
						System.out.printf("[%2d][%2d] = %d\t", i ,j, arr[i][j]);
					}
					System.out.println();
				}
				System.out.println("=".repeat(50));
	}
}
