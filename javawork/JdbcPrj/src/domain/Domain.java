package domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Domain {

  private int[] refreeNum = generateRandomNumber();
  private int[] userNum = null;
  private int tryNum = 0;
  private boolean continueGame = false;

  public boolean isContinueGame() {
    return continueGame;
  }
  public void setContinueGame(boolean continueGame) {
    this.continueGame = continueGame;
  }
  public int[] getRefreeNum() {
    return refreeNum;
  }
  public void setRefreeNum(int[] refreeNum) {
    this.refreeNum = refreeNum;
  }
  public int[] getUserNum() {
    return userNum;
  }
  public void setUserNum(int[] userNum) {
    this.userNum = userNum;
  }
  public int getTryNum() {
    return tryNum;
  }
  public void setTryNum(int tryNum) {
    this.tryNum = tryNum;
  }

  public static int[] generateRandomNumber() {
    Random random = new Random();
    int[] numbers = new int[3];
    int idx = 0;
    Set<Integer> uniqueNumbers = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      int num;
      do {
        num = random.nextInt(9) + 1;
      } while (uniqueNumbers.contains(num));

      uniqueNumbers.add(num);
    }
    for (int num : uniqueNumbers) {
      numbers[idx] = num;
      idx++;
    }

    return numbers;

  }
}
