package bit701.day0915;


/* Thread를 상속 받아서 구현하는 방법
 * 자바는 다중상속 지원 x , 이미 상속 받은 클래스가 있는 경우 인터페이스를
 * 이용해서 스레드를 구현해야한다.
 */


public class Ex02_RunnableTest implements Runnable{
	
	String name;
	int count;
	
	
	
	
	public Ex02_RunnableTest(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}


	@Override
	public void run() {
		for(int i = 1; i <= count; i++) {
			System.out.println(name + " : " + i );
		}
	}
	
	
	public static void main(String[] args) {
		
		Ex02_RunnableTest ex1 = new Ex02_RunnableTest("one", 300);
		Ex02_RunnableTest ex2 = new Ex02_RunnableTest("two", 300);
		Ex02_RunnableTest ex3 = new Ex02_RunnableTest("three", 300);
		
		// Thread 생성자에 Runnable 타입의 현재 클래스 인스턴스를 보내서 생성
		Thread th1 = new Thread(ex1);
		Thread th2 = new Thread(ex2);
		Thread th3 = new Thread(ex3);
		
		th1.start();
		th2.start();
		th3.start();
		
		
		
		
		

	}
}



















