package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.View;

public class ViewTest {


  private PrintStream standardOut;
  private ByteArrayOutputStream outputStream;
  private InputStream standardIn;
  private ByteArrayInputStream inputStream;

  @BeforeEach
  void setUp() {
    standardOut = System.out;
    outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    standardIn = System.in;
  }

  @AfterEach
  void tearDown() {
    System.setOut(standardOut);
    System.setIn(standardIn);
  }

  @Test
  void testStartGame() {
    // 테스트용 입력을 설정
    String input = "2\n"; // "2"를 입력하여 종료하도록 설정
    inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    View view = new View();
    view.startGame();

    String expectedOutput = "게임을 시작합니다.\n1. 게임 재시작 , 2. 종료\n종료합니다.\n";
    String actualOutput = outputStream.toString();

    assertEquals(expectedOutput, actualOutput);
  }
}