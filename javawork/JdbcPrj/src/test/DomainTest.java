package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import domain.Domain;

class DomainTest {

  @Test
  void testGenerateRandomNumber() {
    Domain domain = new Domain();
    int[] refreeNum = domain.getRefreeNum();

    // refreeNum 배열은 3개의 요소로 이루어져야 함
    assertEquals(3, refreeNum.length);

    // refreeNum 배열의 값들은 1에서 9 사이의 숫자여야 함
    for (int num : refreeNum) {
      assertTrue(num >= 1 && num <= 9);
    }

    // refreeNum 배열의 값들은 중복되지 않아야 함
    for (int i = 0; i < refreeNum.length; i++) {
      for (int j = i + 1; j < refreeNum.length; j++) {
        assertNotEquals(refreeNum[i], refreeNum[j]);
      }
    }
  }

  @Test
  void testIsContinueGame() {
    Domain domain = new Domain();

    // 초기 상태에서 continueGame은 true여야 함
    assertTrue(domain.isContinueGame());

    // continueGame 값을 변경하고 확인
    domain.setContinueGame(false);
    assertFalse(domain.isContinueGame());

    // 다시 true로 변경하고 확인
    domain.setContinueGame(true);
    assertTrue(domain.isContinueGame());
  }
}