package pramp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by utkarsh on 28-08-2016.
 */
public class KMessedArraySort {

    public static void main(String[] args) {
        int arr[] = {7, 12, 4, 0, 9, 2, 14, 16, 19};
        kmessedsort(arr, 3);
      //  System.out.println(Arrays.toString(arr));
         int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int arr1[] = {90, 767, 90, 777, 463, 196, 984, 277, 451, 643, 403, 316, 451, 967, 683, 786, 167, 372, 758, 402, 325,
//                431, 351, 351, 158, 663, 244, 559, 345, 759, 924, 585, 509, 397, 540, 869, 997, 670, 375, 180,
//                48, 936, 203, 8, 598, 703, 733, 333, 414, 377, 496, 351, 910, 685, 612, 773, 571, 24, 679, 174,
//                644, 639, 544, 1, 884, 982, 447, 670, 251, 868, 815, 467, 386, 932, 178, 295, 957, 757, 124, 932,
//                342, 301, 406, 259, 943, 79, 313, 218};
//        //int[] arr1 = {1};
        System.out.println(Arrays.toString(arr1));
        List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
//        System.out.println("original list : " + list);
//        slidingMaximum(list, 2).stream().forEach(System.out::print);

        slidingMaximumDqueue(list, 2).stream().forEach(System.out::print);
    }

    public static void kmessedsort(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //we need a window size of k+1   because element can be at most k places away
        //suppose a elments original position is 0 but it was at kth index but has to comeout first.
        //hence k+1

        for (int i = 0; i < k + 1; i++) {
            minHeap.offer(arr[i]);
        }

        int count = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[count++] = minHeap.poll();
            minHeap.offer(i);
        }
        while (!minHeap.isEmpty()) {
            arr[count++] = minHeap.poll();
        }

    }


    //int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(b, (x, y) -> y - x);

        for (int i = 0; i < b; i++)
            queue.offer(a.get(i));
        if (a.size() <= b) {
            result.add(queue.poll());
            return result;
        }

        for (int i = b; i < a.size(); i++) {
            System.out.println("queue : " + queue);
            result.add(queue.peek());
            queue.remove(a.get(i - b));
            System.out.println("result : " + result);
            queue.offer(a.get(i));
        }
        result.add(queue.poll());
        return result;


    }

    public static ArrayList<Integer> slidingMaximumDqueue(final List<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < b; i++) {
            while (!deque.isEmpty() && a.get(deque.getLast()) <= a.get(i)) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        if (a.size() <= b) {
            result.add(a.get(deque.getFirst()));
            return result;
        }
        System.out.println("queue : " + deque);
        System.out.println("result : " + result);
        for (int i = b; i < a.size(); i++) {

            System.out.println("queue : " + deque);
            System.out.println("result : " + result);

            result.add(a.get(deque.getFirst()));
            while (!deque.isEmpty() && deque.getFirst() <= i - b) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && a.get(i) >= a.get(deque.getLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result.add(a.get(deque.getFirst()));
        return result;
    }
}
