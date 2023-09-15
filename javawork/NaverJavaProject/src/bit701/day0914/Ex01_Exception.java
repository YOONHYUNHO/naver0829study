package bit701.day0914;

public class Ex01_Exception {

	public static void main(String[] args) {

		int[] arr = {10, 20, 30};
		for(int i = 0; i <= arr.length; i++)
		{
			try {
			System.out.println(arr[i]);
		
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 번지를 벗어남" + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("정상 종료");
	}

}
