package ex01;

import java.util.Scanner;

public class Week2_Cote {

  public static String Swap(String str) {
    char[] cArray = str.toCharArray();

    for(int i = 0; cArray.length >i; i++) {
      char c = cArray[i];
      if(Character.isUpperCase(c)) {
        cArray[i] = Character.toLowerCase(c);
      } else if(Character.isLowerCase(c)) {
        cArray[i] = Character.toUpperCase(c);
      }
    }
    return new String(cArray);

  }
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(Swap(str));

  }
}
