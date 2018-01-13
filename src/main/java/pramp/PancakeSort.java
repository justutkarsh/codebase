package pramp;

public class PancakeSort {

  static class Solution {
    // 0 1 2 3 4
    //1,5,4,3,2

    // 5 1 4 3 2

    //  2 3 4 1 5

    // 2 3 4 1

    //1,5,3,4,2


    static int findMaxIndex(int[] arr, int k) {
      int max = -1000, maxIndex = 0;

      for (int i = 0; i < k; i++) {

        if (arr[i] > max) {
          max = arr[i];
          maxIndex = i;
        }
      }
      return maxIndex;
    }


    static int[] pancakeSort(int[] arr) {
      // your code goes here

      int end = arr.length;
      if (end < 2)
        return arr;

      while (end > 0) {

        int maxIndex = findMaxIndex(arr, end);  //find max Index in end sized array

        flip(arr, maxIndex);
        flip(arr, end - 1);

        end--;
      }
      return arr;
    }


    static int[] flip(int[] arr, int k) {

      int i = 0, j = k;

      while (i < j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }

      return arr;
    }

    public static void main(String[] args) {

    }

  }
}