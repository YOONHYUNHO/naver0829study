package bit701.day0913;

// 익명 내부 클래스 (Anonymous Inner Class)
abstract class AnonySuper
{
	abstract public void show();
	abstract public void play();
}

interface BitInter
{
	public void study();
	public void draw();
}


// 익명 내부 클래스 형태
class AnonyClass
{
	AnonySuper anony = new AnonySuper() {
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("오늘");
		}
		
		@Override
		public void play() {
			// TODO Auto-generated method stub
			System.out.println("홀리");
		}
	};


// interface BitInter를 익명 내부 클래스 형태로 구현

	BitInter bit = new BitInter() {
		
		@Override
		public void study() {
			System.out.println("공부");
		}
		
		@Override
		public void draw() {
			System.out.println("그림");
			
		}
	};
}

public class Ex09_AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonyClass a = new AnonyClass();
		a.anony.show();
		a.anony.play();
		
		a.bit.study();
		a.bit.draw();
		
		
		
	}

}










