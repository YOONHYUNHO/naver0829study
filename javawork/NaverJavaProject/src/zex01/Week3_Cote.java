package zex01;

public class Week3_Cote {


  class Solution {
    public static int solution(int n) {
      int answer = 0;

      for(int i = 0; i < n; i++) {
        answer++;
        while(answer % 3 == 0 || String.valueOf(answer).contains("3")) {
          answer++;
        }
      }
      return answer;

    }
  }

  public static void main(String[] args) {

    System.out.println(Solution.solution(30));

  }

}