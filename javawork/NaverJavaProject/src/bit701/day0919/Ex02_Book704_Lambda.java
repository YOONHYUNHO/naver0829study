package bit701.day0919;
// 리턴 타입이 있는 람다식

// 3. 함수형 인터페이스 표시
@FunctionalInterface
// 1. 인터페이스 생성
interface CalcInter{
  // 2. 추상메서드 생성
  double calc(double x, double y);
}

// 4. Person 클래스 생성
class Person {
  // 5. action 메서드 생성
  public void action(CalcInter cal) {
    double result = cal.calc(10, 4);
    System.out.println("결과 = " + result);
  }
}
public class Ex02_Book704_Lambda {

  public static void main(String[] args) {
    // 6. Person 생성
    Person person = new Person();
    // 7. 호출, 람다 표현식 전달
    person.action((x,y) -> {
      double result = x + y;
      return result;
    });

    // 위 호출과 같은 로직 - return 한 줄인 경우 생략 가능
    person.action((x, y) ->(x + y));
  }

}
