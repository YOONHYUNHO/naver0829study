package bit701.day0908;

public class Ex03Object {

  public static void main(String[] args) {

    // 객체 배열을 이용해서 데이터를 출력해보자
    Bitcamp[] bit = new Bitcamp[3]; // 3개의 데이터가 들어갈 변수로 할당, 객체 생성은 아니며, 초기값은 null

    // 배열수만큼 Bitcamp 객체를 생성
    for(int i = 0; i < bit.length; i++)
    {
      bit[i] = new Bitcamp();
    }



    // 0번
    bit[0].name = "캔디";
    bit[0].address = "대구";

    // 1번
    bit[1].name = "차차";
    bit[1].address = "마법의성";

    // 2번
    bit[2].name = "통키";
    bit[2].address = "배구섬";


    // 출력 #1
    //		for(int i = 0; i < bit.length; i++)
    //		{
    //			System.out.println(" * * 학 생 정 보 " + (i+1) + " * * " );
    //			System.out.println("이름 : " + bit[i].name);
    //			System.out.println("주소 : " + bit[i].address);
    //			System.out.println("이름 : " + Bitcamp.STUDYNAME);
    //			System.out.println("=".repeat(50));
    //		}

    // 출력 #2
    for(Bitcamp b : bit)
    {
      System.out.println(" * * 학 생 정 보 * * " );
      System.out.println("이름 : " + b.name);
      System.out.println("주소 : " + b.address);
      System.out.println("이름 : " + Bitcamp.STUDYNAME);
      System.out.println("=".repeat(50));
    }
  }
}
