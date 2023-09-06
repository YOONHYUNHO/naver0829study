package bit701.day0906;

public class Ex05_Array {

	public static void main(String args[]) {
		
		// 최대, 최소 값 구하기
		int[] data;
		data = new int[] {5, -100, 67, 89, 45, -9, 123, 58, 110, 200, 345};
		int max, min;
		
		// 최대 값
		max = data[0];	// 첫 번째 데이터를 최대값에 저장
		min = data[0];
		for(int i = 0; i < data.length; i++)
		{
			if(max < data[i]) 
			{
				max = data[i];
			}
			if(min > data[i])
			{
				min = data[i];
			}
		}
		System.out.println("최대값 max = " + max);
		System.out.println("최소값 min = " + min);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
