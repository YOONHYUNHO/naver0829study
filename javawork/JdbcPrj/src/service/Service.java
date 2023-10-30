package service;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import domain.Domain;

public class Service {
  Domain dto = new Domain();



  public void playGame() {
    int tryNum = 0;

    while (true) {
      tryNum++;
      try {
        int[] userNum = getUserInput();
        int[] result = checkNumbers(dto.getRefreeNum(), userNum);
        int strike = result[0];
        int ball = result[1];
        System.out.println("결과 : " + strike + " 스트라이크, " + ball + " 볼");
        if (strike == 0 && ball == 0) {
          System.out.println("낫싱");
        }
        if (strike == 3 ) {
          System.out.println("삼진 아웃 ! " + tryNum + " 번");
          break;
        }
      } catch (IllegalArgumentException  e) {
        System.out.println("게임을 다시 시작합니다.");
      }
    }
  }


  private int[] getUserInput() {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[3];
    System.out.println("숫자 3개를 입력하세요");
    String checkNum = scanner.next();

    if (checkNum.length() != 3) {
      System.out.println("3자리 숫자를 입력하세요");
      throw new IllegalArgumentException();
    }

    Set<Character> usedNum = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      char num = checkNum.charAt(i);
      if (num < '1' || num > '9' || usedNum.contains(num)) {
        System.out.println("1부터 9까지의 서로 다른 숫자를 입력하시오");
        throw new IllegalArgumentException();
      }
      usedNum.add(num);
      numbers[i] = num - '0';
    }
    return numbers;
  }

  private int[] checkNumbers(int[] refreeNum, int[] userNum) {
    int strike = 0;
    int ball = 0;
    for (int i = 0; i < refreeNum.length; i++) {
      for (int j = 0; j < userNum.length; j++) {
        if (refreeNum[i] == userNum[j]) {
          if (i == j) {
            strike++;
          } else {
            ball++;
          }
        }
      }
    }
    return new int[]{strike, ball};
  }

}