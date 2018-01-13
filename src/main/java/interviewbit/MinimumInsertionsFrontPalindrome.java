package interviewbit;

/**
 * Created by utkarsh on 08/01/18.
 */
public class MinimumInsertionsFrontPalindrome {
static public class Solution {
  public int solve(String A) {
    return minInsertions(A.toCharArray(),0,A.length()-1);


  }

  public int minInsertions(char[] buffer, int l, int h) {
    if (l > h) return Integer.MAX_VALUE;
    if (l == h) return 0;
    if (l + 1 == h) {
      return buffer[l] == buffer[h] ? 0 : 1;
    }
    return (buffer[l] == buffer[h]) ? minInsertions(buffer, l + 1, h - 1) :
        minInsertions(buffer, l, h-1) + 1;

  }
}

  public static void main(String[] args) {

  String input = "hqghumeaylnlfdxfi";

  Solution solution = new Solution();
    System.out.println(solution.minInsertions(input.toCharArray(),0,input.length()-1));




  }
}
