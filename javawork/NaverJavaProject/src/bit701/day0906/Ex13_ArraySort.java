package bit701.day0906;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Ex13_ArraySort {

	public static void main(String args[]) {
		
		int[] data = {5, 3, 2, 4, 1};
		// selection sort
		// 오름차순 정렬 : 기준(i)이 비교되는 값(j)보다 클 경우 바꾼다.
		for(int i = 0; i < data.length-1; i++)
		{
			for(int j = i+1; j < data.length; j++ )
			{
				//if(data[i] > data[j]) // 오름차순
				if(data[i] < data[j]) // 내림차순
				{
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
		for(int n:data)
			System.out.print(n);
		
	}
}
