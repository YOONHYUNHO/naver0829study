package zex01;

public class Week3_Cote2 {

  class Solution {
    public static int solution(int[] common) {
      int answer = 0;

      if ((common[1] - common[0]) == (common[2] - common[1])) {
        answer = common[common.length - 1] + (common[1] - common[0]);
      } else {
        answer = common[common.length - 1] * (common[1] / common[0]);
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    int[] common = {2, 4, 8, 16, 32};
    System.out.println(Solution.solution(common));
  }

}
