package bit701.day0919;


// 3. 추상 메서드가 하나인지 아닌지 확인 ( 인터페이스가 함수형으로 구현이 가능한지 검증 )
@FunctionalInterface
// 1. 인터페이스 생성
interface Calculable {
  // 2. 추상메서드 생성
  public void calculate(int x, int y);
}

public class Ex01_Book697_Lambda {

  // 4. 함수 생성
  public static void action(Calculable calculable) {
    int x = 10;
    int y = 4;
    // 데이터 처리
    calculable.calculate(x, y);
  }

  public static void main(String[] args) {

    // 5. action 호출
    action((x,y) -> {
      int result = x + y;
      System.out.println("add result = " + result);
    });

    action((x,y) -> {
      int result = x - y;
      System.out.println("sub result = " + result);
    });
  }
}
