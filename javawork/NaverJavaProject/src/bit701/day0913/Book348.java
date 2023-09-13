package bit701.day0913;


interface RemoteControl
{
	
	// 상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	
	// 추상 메서드
	void turnOn();
	void turnOff();
	void setVoluem(int volume);
	
	// jdk8 디폴트 인스턴스 메서드 - 기능 구현
	default void setMute(boolean mute)
	{
		if(mute) 
		{
			System.out.println("무음");
			setVoluem(MIN_VOLUME);
		} else 
		{
			System.out.println("무음 해제");
		}
	}
}

class Television implements RemoteControl
{
	// 초기값
	private int volume;
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("tv를 끕니다.");
		
	}

	@Override
	public void setVoluem(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 볼륨은 " + this.volume + "입니다.");
	}
	
}
public class Book348 {

	public static void main(String[] args) {
		RemoteControl rc = null;
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVoluem(11);
		
		// 디폴트 메서드 호출
		rc.setMute(false);
		rc.setMute(true);
		System.out.println();
//		RemoteControl rc2 = null; // 인터페이스는 new 생성 x
//		rc2.setMute(false); // 반드시 구현하는 클래스가 있어야 호출 가능
	}

}
