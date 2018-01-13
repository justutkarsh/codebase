package pramp;

/**
 * Created by utkarsh on 18-09-2016.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class QuadCombination {


  static class Solution {


    static class Pair {

      int i;
      int j;

      public Pair(int i, int j) {
        this.i = i;
        this.j = j;
      }

      @Override
      public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
          return false;
        } else {
          Pair p = (Pair) obj;
          if (Math.min(p.i, p.j) == Math.min(this.i, this.j) &&
              Math.max(p.i, p.j) == Math.max(this.i, this.j)) {
            return true;
          } else {
            return false;
          }
        }
      }

      @Override
      public int hashCode() {
        return i * i + j * j;
      }
    }

    static int[] findArrayQuadruplet(int[] arr, int s) {
      // your code goes here

      Map<Integer, Pair> tupleMap = new HashMap<>();
      for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
          tupleMap.put(arr[i] + arr[j], new Pair(i, j));

        }
      }

      for(Entry e: tupleMap.entrySet()){

        if(tupleMap.containsKey(s - (Integer)e.getKey())){
          if (e.getValue() == tupleMap.get(s - (Integer)e.getKey())){
//             int [] output = {e.getValue()}
          }
        }


      }
     return null;
    }

    public static void main(String[] args) {

      int[] input = {2, 7, 4, 0, 9, 5, 1, 3};
      System.out.println(Arrays.toString(findArrayQuadruplet(input, 20)));
    }

  }

}
