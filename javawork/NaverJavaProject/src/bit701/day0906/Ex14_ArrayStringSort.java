package bit701.day0906;

public class Ex14_ArrayStringSort {
	
	public static void main(String[] args) {
		
		String[] names = {"한가인", "강호동", "강호순", "Candy", "손미나"};
		
		// selection sort-문자열
		
		for(int i = 0; i < names.length-1; i++)
		{
			for(int j = i+1; j < names.length; j++)
			{
				if(names[i].compareTo(names[j])>0) // 오름차순 정렬, 0 보다 작으면 내림차순 정렬
				{
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		
		for(String s:names)
			System.out.println(s);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
