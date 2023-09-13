package bit701.day0913;

abstract class Animal
{
	public void breathe()
	{
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound();
}

// 추상 클래스 상속
class Dog extends Animal
{
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal
{
	@Override
	public void sound() {
		System.out.println("야옹");	
	}
}


public class Book328 {


	public static void animalSound(Animal animal)
	{
		animal.sound();
	}
	
	public static void main(String[] args) {
		
		Cat cat = new Cat();
		animalSound(cat);
		
		Dog dog = new Dog();
		animalSound(dog);
		
		
	}

}
