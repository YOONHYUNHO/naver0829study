package bit701.day0906;

public class Ex01_Array {

	public static void main(String[] args) {
		
		/* 배열 : 연속된 형태로 데이터가 저장
		 *        같은 타입의 데이터만 저장 가능, 
		 *        일괄적으로 처리하기 위해서 배열을 사용
		 *        배열 -> 객체로 인식
		*/
		
		// 배열 선언 방법 : 1
		int [] arr1 = new int[5]; // 5개의 정수타입을 저장할 공간 확보, 0으로 자동 초기화(int)
		System.out.println("arr1의 할당 갯수 : " + arr1.length);
		
		
		// 배열에 값 입력 방법
		arr1[1] = 10;
		arr1[4] = 50;
		
		// 출력 1
		for(int i = 0; i < arr1.length; i++)
		{
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		// 출력 2
		for(int n:arr1) // arr1의 갯수만큼 자동으로 반복, 값을 n으로 보냄
		{
			 System.out.print(n + " ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
