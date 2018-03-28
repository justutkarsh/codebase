package companies.paytm;/*
  @author utkarsh 
*/

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

  List<Integer> array = Arrays.asList(1, 3, 2, 4, 7, 4, 9, 12, 11, 10, 56, 32, 24);
  Stack<Integer> stack = new Stack<>();

  //   1 3 2 4 7 4 9  12 11 10  56 32 24
  //   3 4 4 7 9 9 12 56 56 56 -1  -1 -1
/*
       .56              . 50
     .   .            .   .  40
   .       . 32      .     .  30
  .          .     .       .
 .              . .
.               24
.10
----------------------------------  0

*/

  public static void main(String[] args) {
    NextGreaterElement nge = new NextGreaterElement();
    nge.array.stream().forEach(s -> {
      System.out.print(s + ",");
    });

    System.out.println();

    nge.nextGreaterElement().stream().forEach(s -> {
      System.out.print(s + ",");
    });

    nge.stack.clear();
    System.out.println();

    nge.array.stream().forEach(s -> {
      System.out.print(s + ",");
    });

    System.out.println();

    nge.backNextGreaterElement().stream().forEach(s -> {
      System.out.print(s + ",");
    });
  }

  //processing from front side
  List<Integer> nextGreaterElement() {

    List<Integer> solution = Arrays.asList(new Integer[array.size()]);
    //pushing the index of array
    stack.push(0);
    for (int i = 1; i < array.size(); i++) {
      Integer current = array.get(i);
      while (!stack.isEmpty() && current > array.get(stack.peek())) {
        solution.set(stack.peek(), current);
        stack.pop();
      }
      stack.push(i);

    }
    return solution;

  }

  /*
       .56              . 50
     .   .            .   .  40
   .       . 32      .     .  30
  .          .     .       .
 .              . .
.               24
.10
----------------------------------  0

  //   1 3 2 4 7 4 9  12 11 10  56 32 24
  //   3 4 4 7 9 9 12 56 56 56 -1  -1 -1
*/
  //processing from rear side
  List<Integer> backNextGreaterElement() {

    List<Integer> solution = Arrays.asList(new Integer[array.size()]);
    //pushing the index of array
    stack.push(array.size() - 1);

    for (int i = array.size() - 2; i >= 0; i--) {
      Integer current = array.get(i);
      while (!stack.isEmpty() && current > array.get(stack.peek())) {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        }
      }

      while (!stack.isEmpty() && current < array.get(stack.peek())) {
        solution.set(i, array.get(stack.peek()));
        stack.push(i);
      }


    }
    return solution;
  }


}
