package bit701.day0911;

import java.util.Date;

class Sawon
{
	private String name;
	private int gibon;
	private int sudang;
	private int familysu;
	
		//멤버변수의 4개를 인자로 받아서 전달할 생성자
		public Sawon(String name, int gibon, int sudang, int familysu) 
		{
			this.name = name;
			this.gibon = gibon;
			this.sudang = sudang;
			this.familysu = familysu;
		}

		//멤버변수 4개의 getter method
	
		public String getName()
		{
			return name;
		}
		public int getGibon()
		{
			return gibon;
		}
		public int getSudang()
		{
			return sudang;
		}
		public int getFamilysu()
		{
			return familysu;
		}

		//가족수에 따른 수당 반환하는 메서드
		//3인이상이면 10000, 나머지는 50000
		//   getFamilySudang()
		public int getFamilySudang()
		{
			if(familysu >= 3)
				return 10000;
			else
				return 50000;
		}

		//세금반환하는 메서드
		//기본급의 5프로 반환
		//  getTax()
		public int getTax()
		{
			return gibon*5/100;
		}
		
		//실제 받을 실수령액을 리턴하는 메서드
		//기본급+수당+가족수당-세금
		//   getNetPay()
		
		public double getNetPay()
		{
			return gibon + sudang + getFamilySudang() - getTax();
		}
}


