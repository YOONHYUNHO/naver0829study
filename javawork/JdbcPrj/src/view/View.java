package view;

import java.util.Scanner;
import domain.Domain;
import service.Service;
public class View {
  Domain domain = new Domain();
  Service service = new Service();


  public void startGame() {
    System.out.println("게임을 시작합니다.");
    while (!domain.isContinueGame()) { // 게임을 계속할 동안 반복
      service.playGame();
      System.out.println("1. 게임 재시작 , 2. 종료");
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();
      if(choice == 2) {
        domain.setContinueGame(true);
        System.out.println("종료합니다.");
      }
    }
  }
}
