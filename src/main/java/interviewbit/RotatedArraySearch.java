package interviewbit;

import java.util.Arrays;
import java.util.List;

/**
 * Created by utkarsh on 14/03/17.
 */
public class RotatedArraySearch {


  static class BestSolution {

    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
      return search(a, 0, a.size() - 1, b);
    }


    public static int search(List<Integer> arr, int l, int r, int value) {

      if (l > r) {
        return -1;
      }

      int mid = (l + r) / 2;
      if (arr.get(mid) == value) {
        return mid;
      }

      if (arr.get(mid) >= arr.get(l)) {
        if (value <= arr.get(mid) && value >= arr.get(l)) {
          return search(arr, l, mid - 1, value);
        }

        return search(arr, mid + 1, r, value);

      } else {
        if (value <= arr.get(r) && value >= arr.get(mid)) {
          return search(arr, mid + 1, r, value);
        }

        return search(arr, l, mid - 1, value);
      }


    }
  }


  static class Solution {


    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
      return binarySearchShifted(a, 0, a.size() - 1, b);
    }

    public static int binarySearchRecursive(List<Integer> arr, int left, int right, int value) {
      System.out.println("binarySearch(" + left + "," + right + ")");
      if (left > right) {
        return -1;
      }
      int mid = (left + right) / 2;
      if (arr.get(mid) == value) {
        return mid;
      } else if (value < arr.get(mid)) {
        return binarySearchRecursive(arr, left, mid - 1, value);
      } else {
        return binarySearchRecursive(arr, mid + 1, right, value);
      }


    }

    public static int binarySearchShifted(List<Integer> arr, int left, int right, int value) {

      int pivotIndex = findPivot(arr, left, right);
      if (arr.get(pivotIndex) == value) {
        return pivotIndex;
      }
      System.out.println("pivot:" + pivotIndex);
      int element = arr.get(0);
      if (value < element) {
        return binarySearchRecursive(arr, pivotIndex + 1, right, value);
      } else {
        return binarySearchRecursive(arr, 0, pivotIndex - 1, value);
      }
    }

    //56234
    public static int findPivot(List<Integer> arr, int left, int right) {

      while (left <= right) {
        if (arr.get(right) > arr.get(left)) {
          return left;
        }
        int mid = left + (right - left) / 2;
        System.out.println(left + "," + mid + "," + right);
        if (arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1)) {
          return mid;
        }
        if (arr.get(mid) < arr.get(left)) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }

      }
      return -1;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> integerList = Arrays.asList(1, 7, 67, 133, 178);
    System.out.println(s.search(integerList, 1));
  }


}
