package bit701.day0911;

public class Ex12_StudentCallBy {

	
	// 주소를 전달 받아 여기서 준 초기 값은 main의 stu로 전달된다.
	public static void dataInput(Student[] stu)
	{
		stu[0] = new Student("김씨");
		stu[1] = new Student("이씨", 2000, 90);
		stu[2] = new Student("박씨", 1989, 89);
	}
	
	public static void dataWrite(Student[] stu)
	{
		for(Student s:stu)
		{
			s.studentInfo();
		}
	}
	
	
	public static int changeInt(int a)
	{
		a = 200;
		return a;
	}
	public static void main(String[] args) {
		
		
		Student[] stu = new Student[3];

		dataInput(stu);
		dataWrite(stu);
		
		int a = 100;
		int b = changeInt(a); // call by value로 값을 변경한 경우 리턴으로 변경된 값을 얻어야만 할 수 있다.
		System.out.println(a + "을 " + b + "로 변경");
	}

}
