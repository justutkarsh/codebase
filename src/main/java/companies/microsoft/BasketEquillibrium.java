package companies.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by utkarsh on 10/03/18.
 */

//1,2,3,4

public class BasketEquillibrium {

  Set<List<Integer>> visitedset = new HashSet<>();
  Queue<List<Integer>> queue = new LinkedList();


  Boolean isStable(List<Integer> state) {

    Collections.sort(state);
    queue.add(state);

    while (!queue.isEmpty()) {

      List<Integer> currentState =  queue.poll();
      if (visitedset.contains(currentState)) {
        continue;
      }

      List<Integer> copy = new ArrayList(currentState);

      for (int i = 0; i < currentState.size() - 1; i++) {
        for (int j = i + 1; j < currentState.size(); j++) {

          Integer ithValue = currentState.get(i);
          currentState.set(i, 2 * ithValue);
          currentState.set(j, currentState.get(j) - ithValue);

          if (Objects.equals(currentState.get(0), currentState.get(1)) && Objects
              .equals(currentState.get(0), currentState
                  .get(2))) {
            return true;
          } else {

            boolean b = currentState.stream().anyMatch(Predicate.isEqual(0));
            if (!b) {
              Collections.sort(currentState);
              queue.add(currentState);
            }
          }
        }
      }
      visitedset.add(copy);
    }

    return false;
  }

  public static void main(String[] args) {
    BasketEquillibrium basketEquillibrium = new BasketEquillibrium();
    System.out.println(basketEquillibrium.isStable(Arrays.asList(2, 1, 3)));
    System.out.println(basketEquillibrium.isStable(Arrays.asList(6, 10, 1)));
  }

  public static void main2(String[] args) {
    Integer i1 = 1;
    Integer i2 = 1;

    System.out.println(i2 == i1);
  }
}
