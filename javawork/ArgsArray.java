public class ArgsArray {
	public static void main(String[] args) {
		// args로 두 개의 숫자를 읽어서 출력
		String str1 = args[0];
		String str2 = args[1];
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("두 수의 합 = " + (str1 + str2));

		// String을 기본형 int로 변환
		// Integer라는 Wrapper class를 이용해서 변환
		int su1 = Integer.parseInt(str1);
		int su2 = Integer.parseInt(str2);
		System.out.println("두 수의 합 = " + (su1 + su2));
		 
	}	
}