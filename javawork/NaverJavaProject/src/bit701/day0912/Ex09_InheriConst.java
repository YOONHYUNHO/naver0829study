package bit701.day0912;


class SuperD 
{
	private String carName;
	private String carColor;
	
	SuperD()
	{
		System.out.println("부모 디폴트 생성자 호출");
		carName = "소나타";
		carColor = "노랑";
	}
	
	SuperD(String carName, String carColor)
	{
		System.out.println("부모 두 번째 생성자 호출");
		this.carName = carName;
		this.carColor = carColor;
	}
	
	public void carInfo() 
	{
		System.out.println("자동차명 " + carName);
		System.out.println("색상 :" + carColor);
	}
}


class SubD extends SuperD
{
	private int carPrice;
	
	SubD()
	{
		System.out.println("자식 디폴트 생성자");
		this.carPrice=3500;		
	}
	
	SubD(String carName, String carColor, int carPrice)
	{
		super(carName, carColor);
		System.out.println("자식 두 번째 생성자 호출");
		this.carPrice = carPrice;
	}
	@Override
	public void carInfo() 
	{
		super.carInfo(); // 부모의 멤버변수가 private라서 부모가 출력후 메서드로 호출
		System.out.println("차량 가격 : " + this.carPrice);
		System.out.println("-".repeat(30));
	}
}













public class Ex09_InheriConst {

	public static void main(String[] args) {
		
		SubD sub1 = new SubD();
		sub1.carInfo();
		
		SubD sub2 = new SubD("벤츠", "검정", 6700);
		sub2.carInfo();

	}

}
