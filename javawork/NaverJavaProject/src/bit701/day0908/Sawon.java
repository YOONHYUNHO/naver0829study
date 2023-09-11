package bit701.day0908;

public class Sawon {
	
	
	private String sawonNo;
	private String name;
	private int age;
	
	
	@Override
	public String toString() {
		return "Sawon [sawonNo=" + sawonNo + ", name=" + name + ", age=" + age + "]";
	}
	public void setSawonNo(String sawonNo) {
		this.sawonNo = sawonNo;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSawonNo() {
		return sawonNo;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
