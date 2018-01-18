package pramp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by utkarsh on 17/01/18.
 */

public class FindMinimumNonNegativeInteger {

  static class Solution {

    int getDifferentNumber(int[] arr) {
      // your code goes here
      Set<Integer> hashSet = new HashSet<>();
      for (int i = 0; i < arr.length; i++) {
        hashSet.add(arr[i]);
      }
      for (int i = 0; i < arr.length; i++) {

        if (!hashSet.contains(i))

        {
          return i;
        }
      }
      return arr.length;
    }

    public static void main(String[] args) {

      Solution solution = new Solution();
      int[] arr = {0, 1, 2, 3, 4, 6, 7};
      System.out.println(solution.getDifferentNumber(arr));

    }

  }

}
