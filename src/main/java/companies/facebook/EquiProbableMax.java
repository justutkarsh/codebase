package companies.facebook;/*
  @author utkarsh 
*/

import java.util.Arrays;
import java.util.List;

public class EquiProbableMax {

  List<Integer> array = Arrays.asList(1, 4, 5, 6, 6, 9, 10, 11, 10, 11, 0, 1, 11, 11);

  public static void main(String[] args) {
    EquiProbableMax epm = new EquiProbableMax();
    for (int i = 0; i < 10000; i++) {
      System.out.println("Maximum Index:" + epm.maxIndex());
    }
  }

  //maximum number with equal probability
  Integer maxIndex() {
    Integer currMax = Integer.MIN_VALUE, maxIndex = 0;
    Double maxCount = 0d;
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) > currMax) {
        currMax = array.get(i);
        maxCount = 0d;
      }

      if (array.get(i) == currMax) {
        maxCount++;
        if (Math.random() < 1d / maxCount) {
          maxIndex = i;
          // System.out.println(maxIndex);
        }
      }

    }
    return maxIndex;
  }
}
