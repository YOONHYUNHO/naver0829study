package bit701.day0907;

import java.util.Scanner;

public class Ex3_ArrayBinggo {
	public static void main(String[] args) {
		
		/* 3행 3열의 배열 선언 후 1~3 사이의 난수 발생
		 * 가로 세로 대각선으로 비교하여 같은 숫자가 나온 갯수를 구한다.
		*/
		
		Scanner sc = new Scanner(System.in);
		int[][] data = new int[3][3];
		int binggo;
		
		while(true)
		{
			binggo = 0;
			
			// 3행 3열에 1 ~ 3 숫자 임의로 넣기
			for(int i = 0; i < data.length; i++)
			{
				for(int j = 0; j < data[i].length; j++)
				{
					data[i][j] = (int)(Math.random()*3)+1;
				}
			}
			//출력
			for(int i = 0; i < data.length; i++)
			{
				for(int j = 0; j < data[i].length; j++)
				{
					System.out.printf("%3d", data[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			// 빙고 계산 (0이면 꽝, 빙고 : n개..)
			for(int i = 0; i < 3; i++)
			{
				// 가로선
				if(data[i][0]==data[i][1] && data[i][1]==data[i][2])
					binggo++;
				// 세로선
				if(data[0][i]==data[1][i] && data[1][i]==data[2][i])
					binggo++;
			}
			
			// 대각선
			if(data[0][0]==data[1][1] && data[1][1]==data[2][2])
				binggo++;
			// 대각선
			if(data[0][2]==data[1][1] && data[1][1]==data[2][0])
				binggo++;
			if(binggo==0)
				System.out.println("꽝 !");
			else
				System.out.println("빙고 : " + binggo +"개");
			
			
			System.out.println("종료:>q");
			String ans = sc.nextLine();
			if(ans.equalsIgnoreCase("q"))
				break;
			System.out.println("-".repeat(10));
		}
		
		
		System.out.println(" **빙고 게임 끝**");
		
	}
}
