package bit701.day0908;

public class Ex05SawonCall {

	public static void main(String[] args) {
		
		Sawon sa1 = new Sawon();
		sa1.setSawonNo("bit1234");
		sa1.setName("홍길동");
		sa1.setAge(23);
		
		System.out.println("* 신 입 사 원 #1 정보 *");
		
		Ex05SawonCall.printSawon(sa1); // 같은 클래스내의 메서드는 클래스명 생략 가능
		
		
		Sawon sa2 = new Sawon();
		sa2.setSawonNo("bit9999");
		sa2.setName("강호동");
		sa2.setAge(35);

		
		System.out.println("* 신 입 사 원 #2 정보 *");
		
		Ex05SawonCall.printSawon(sa2); // 같은 클래스내의 메서드는 클래스명 생략 가능
		
	}
	
	public static void printSawon(Sawon s) {
		System.out.println("사원번호 : " + s.getSawonNo());
		System.out.println("사원명 : " + s.getName());
		System.out.println("나이 : " + s.getAge());
		System.out.println();
	}

}
