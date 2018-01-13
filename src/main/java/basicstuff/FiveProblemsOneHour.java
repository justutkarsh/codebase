package basicstuff;

import java.util.Arrays;

/**
 * Created by utkarsh on 13-08-2016.
 */
public class FiveProblemsOneHour {
    //int [] arr = new int();
    /*
    Problem 1
    Write three functions that compute the sum of the numbers in a given list using a for-loop, a while-loop, and recursion.
    */

    public int computeSumForLoop(int[] list) {
        return Arrays.stream(list).sum();
    }

    public int computeSumWhileLoop(int[] list) {
        int start = 0, sum = 0;
        while (start < list.length) {
            sum += list[start];
            start++;
        }
        return sum;
    }

    public int computeSumRecursion(int[] list, int start, int end) {
        //if(start>end) return -1;
        if (start == end) return list[start];

        else return list[start] + computeSumRecursion(list, start++, end);

    }

    /*
    Write a function that combines two lists by alternatingly taking elements. For example: given the two lists [a, b, c] and [1, 2, 3], the function should return [a, 1, b, 2, c, 3].
     */
    public int[] combinealternate(int[] list1, int[] list2) {
        int i = 0, j = 0, k = 0;
        int[] list = new int[list1.length + list2.length];
        while (i < list1.length && j < list2.length) {
            list[k++] = list1[i++];
            list[k++] = list2[j++];

        }
        return list;


    }

    public int fibonacci(int x) {
        if (x < 1) return 0;
        if (x == 1) return 1;

        int last = fibonacci(x - 1);
        System.out.println(last);

        int secondlast = fibonacci(x - 2);
        System.out.println(secondlast);

        return last + secondlast;


    }

    /*
    For example, given [50, 2, 1, 9], the largest formed number is 95021.
     */
    public void largest() {

    }

/*
put + or - or nothing between the numbers 1, 2, ..., 9 (in this order) such that the result
 is always 100. For example: 1 + 2 + 34 – 5 + 67 – 8 + 9 = 100.
 */

    public void possiblecombinations() {

    }
}
