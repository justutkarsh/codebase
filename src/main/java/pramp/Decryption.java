package pramp;

/**
 * Created by utkarsh on 12/01/18.
 */

public class Decryption {

  static class Solution {

    public String decrypt(String word) {
      if (null == word || word.isEmpty()) {
        return word;
      }
      char[] result = word.toCharArray();

      StringBuilder output = new StringBuilder(word.length());
      int first = result[0] - 1;

      output.append((char)first);

      int prev = first+1;
      for (int i = 1; i < result.length; i++) {
        int j = 0;
        int next = (int) result[i] + 26 * j - prev;

        while (next < 97 || next > 122) {
          next += 26;
          j++;
        }
        prev = next + prev;

        output.append((char)next);
      }

      return output.toString();
    }
/*
Decrypted message:	c	r	i	m	e
Step 1:	99	114	105	109	101

         99  x1  y1  z1  w1
Step 2:	100
Step 3:	100	110	111	116	113
Encrypted message:	d	n	o	t	q
 */
    public static void main(String[] args) {
      Solution solution = new Solution();

      System.out.println(solution.decrypt("dnotq"));

    }
  }


}
