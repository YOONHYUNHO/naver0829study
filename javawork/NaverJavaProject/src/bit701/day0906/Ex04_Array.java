package bit701.day0906;

public class Ex04_Array {

	public static void main(String args[]) {
		
		// 배열에 5개의 점수를 저장 후 총점과 평균
		int[] score = {78, 100, 90, 89, 69};
		// 증감연산자 등 초기화 필수
		int sum = 0;
		double avg = 0;
		
//		for(int i = 0; i < score.length; i++)
//		{
//			sum += score[i];
//		}
		
		for(int n:score) 
		{
			sum += n;
		}
		
		
		// sum 계산이 끝난 후 평균
		avg = (double)sum/score.length;
		System.out.println("총 점수 갯수 : " + score.length);
		System.out.println(" 총 점 : " + sum);
		System.out.println(" 평 균 : " + avg);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
