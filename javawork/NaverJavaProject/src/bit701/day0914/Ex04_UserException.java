package bit701.day0914;

import java.util.Scanner;

class NicknameException extends Exception {
	
	
	// 생성자
	public NicknameException(String msg) {
		super(msg);
	}
}


public class Ex04_UserException {
	// 3. 
	public static void dataInput() throws NicknameException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		String nickName;
		System.out.println("닉네임?");
		nickName = sc.nextLine();
		if(nickName.equals("바보") || nickName.equals("이놈")) {
			// 1. 강제로 예외 발생 - 2. 호출한 곳(dataInput으로 예외 던지기)
			throw new NicknameException("고운말"); 
		}
		Thread.sleep(1000); // 1초 후 출력
		System.out.println("닉네임 : " + nickName);
	}
	
	public static void main(String[] args) throws InterruptedException {
		// 4.
		try {
			dataInput();
		} catch (NicknameException e) {
			System.out.println(e.getMessage());
		}
	}

}
