package bit701.day0918;
/* 자바에서의 함수형 프로그램인 람다 표현식은 인터페이스를 
 * 사용하는 익명 내부 클래스의 또 다른 표현식이다.
 * 단, 인터페이스는 단 하나의 추상 메서드만 가지고 있어야 한다.
 */

@FunctionalInterface // 메서드가 하나인지 아닌지 검증하는 역할, 오류 발생 시킴
interface Orange 
{
  public void write();
}


@FunctionalInterface // 메서드가 하나인지 아닌지 검증하는 역할, 오류 발생 시킴
interface DataAdd
{
  public void add(int x , int y);
}

public class Ex04_Lamda {

  // 우리가 알고 있는 익명 내부클래스 형태로 객체를 생성
  public void abstMethod1() {
    Orange or = new Orange() {

      @Override
      public void write() {
        System.out.println("안녕하세요");

      }
    };

    or.write();
  }

  // 람다식으로 오버라이드
  public void abstMethod2() {
    Orange or = () -> System.out.println("반가워요");
    or.write();

    // 오버라이드 메서드의 코드가 2줄 이상일경우 {} 안에서 작성
    Orange or2 = () -> { 
      System.out.println("람다");
      System.out.println("2 줄");
    };
    or2.write();
  }

  // 람다식으로 오버라이드
  public void abstMethod3() {
    DataAdd da = (int x, int y) -> System.out.println(x + "+" + y +" = "  + (x + y));

    da.add(100, 200);
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Ex04_Lamda ex = new Ex04_Lamda();
    ex.abstMethod1();
    ex.abstMethod2();
    ex.abstMethod3();
  }

}
