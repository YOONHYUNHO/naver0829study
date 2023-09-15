package bit701.day0915;


/* Thread를 상속 받아서 구현하는 방법
 * 자바는 다중상속 지원 x , 이미 상속 받은 클래스가 있는 경우 인터페이스를
 * 이용해서 스레드를 구현해야한다.
 */
public class Ex01_ThreadTest extends Thread {

	String name;
	int count;
	
	public Ex01_ThreadTest(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= count; i++) {
			System.out.println(name + " : " + i);
		}

	}
	
	public static void main(String[] args) {
		Ex01_ThreadTest th1 = new Ex01_ThreadTest("one_thread", 300);
		Ex01_ThreadTest th2 = new Ex01_ThreadTest("two_thread", 300);
		Ex01_ThreadTest th3 = new Ex01_ThreadTest("three_thread", 300);

		// thread 에서 run 메서드 호출 start, 스레드가 아니라면 th1이 1부터 300까지 다음 th2 ...
		th1.start();
		th2.start();
		th3.start();
	}

}



















