package bit701.day0911;

public class Ex07_Constructor {
	
	
	public static void main(String[] args) 
	{

		// 방법 1
//		Student[] stu = new Student[3]; // 5개로 배열 할당, 초기값 null
//		stu[0] = new Student();
//		stu[1] = new Student("이효리");
//		stu[2] = new Student("이효리", 1999, 90);
		
//		for(int i = 0; i < stu.length; i++)
//		{
//			stu[i].studentInfo();
//		}
		
		
		// 방법 2
		Student[] stu = {
				new Student(),
				new Student("유재석"),
				new Student("이강인", 2000, 89),
				new Student("손흥민", 1992, 99)
				
		};
		
		for(Student s:stu)
			s.studentInfo();
	}
}
