package bit701.day0908;

public class Ex04Object {
	// 인스턴스 멤버 변수
	private int score;
	// 클래스 멤버 변수
	static public String message;
	// 인스턴스 멤버 메서드, score에 값을 넣는 메서드(setter method)
	public void setScore(int score)
	{
		// 멤버변수 score에 인자로 받은 score를 전달
		// 매개변수명이 멤버변수명이랑 같을경우 멤버변수 앞에 this를 붙인다.
		this.score = score; 
	}
	
	// static 메서드는 static 멤버변수만 접근 가능
	public static void setMessage(String message)
	{
		// 클래스명.변수 = 인자로 받을 변수(지역변수)
		Ex04Object.message = message;
	}
	// 점수를 반환하는 getter method, private 멤버 변수인 경우 getter, setter를 사용해서 값을 전달
	public int getScore()
	{
		return score; // this.score에서 this(같은 이름이 있을 경우 사용)가 생략 가능
	}
	
	public static void main(String[] args) {
		// static이 붙은 메서드는 this가 없음 -> 호출 불가능, new로 생성해서 가능
		// main 메서드는 static이므로 new로 생성을 해야 멤버 접근이 가능하다.
		// 단 static은 호출 가능(클래스명)
		
		Ex04Object.setMessage("Hello World"); // public이므로 바로 출력 가능
		System.out.println(Ex04Object.message);
		
		Ex04Object ex4 = new Ex04Object();
		ex4.setScore(89);
		System.out.println("점수 : " + ex4.getScore());
	}
}
