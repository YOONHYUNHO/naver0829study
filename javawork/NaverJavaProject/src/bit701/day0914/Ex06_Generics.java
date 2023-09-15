package bit701.day0914;

class Box<T>
{
	private T content;
	
	public void setContent(T content) {
		this.content = content;
	}
	
	public T getContent() {
		return content;
	}
}

public class Ex06_Generics {

	public static void main(String[] args) {
		
		
		Box<String> box1 = new Box();
		box1.setContent("hello");
		System.out.println(box1.getContent());
		System.out.println();
		
		Box<Double> box2 = new Box();
		box2.setContent(23.8);
		System.out.println(box2.getContent());

	}

}
