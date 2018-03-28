package recursionndynamicprogramming;/*
  @author utkarsh 
*/

import java.util.Arrays;
import java.util.List;

public class SubSetsWithSum {

  // List<Integer> set = Arrays.asList(2, 4, 6, 0, 1, 10);
  //6,10
  //2,4,10
  //6,10,0
  //2,4,10,0
  List<Integer> set = Arrays.asList(0, 6);

  public static void main(String[] args) {
    SubSetsWithSum sswm = new SubSetsWithSum();
    System.out.println(new SubSetsWithSum().ways(sswm.set.size() - 1, 6));
  }

  //total no of ways will be equal to no. of ways
  //when last element is included plus when last element is not included.
  int ways(int lastIndex, Integer remainingTotal) {

    int w = 0;

    if (lastIndex == 0) {
      if (remainingTotal == set.get(0)) {
        return 1;
      } else {
        return 0;
      }
    }

    w = set.get(lastIndex).equals(remainingTotal) ? 1 : 0 +
        ways(lastIndex - 1, remainingTotal) + ways(lastIndex - 1,
        remainingTotal - set.get(lastIndex));

    return w;


  }

}
