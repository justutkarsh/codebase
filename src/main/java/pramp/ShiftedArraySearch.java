package pramp;

/**
 * Created by utkarsh on 25-08-2016.
 */

public class ShiftedArraySearch {
    /*
    1. Find a given number num in a sorted array arr:
    arr = [2, 4, 5, 9, 12, 17]

    2. If the sorted array arr is shifted left by an unknown offset and you don't have a pre-shifted copy of it, how would you modify your method to find a number in the shifted array?
    shiftArr = [9, 12, 17, 2, 4, 5]

    Explain and code an efficient solution and analyze its runtime complexity
    if num doesn't exist in the array, return -1
         */
    public static void main(String[] args) {
//        int arr[] = {1, 4, 7, 10, 13, 17, 19, 111, 123, 145, 155, 190};
//        System.out.println(binarySearch(arr, 190));
//        System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 190));
//        System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 1));
//        System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 4));
//
//        System.out.println(binarySearchShifted(arr, 0, arr.length - 1, 190));


        int shiftedArr[] = {7, 10, 13, 17, 19, 111, 123, 145, 155, 190, 1, 2, 3, 4};
        System.out.println(binarySearchShifted(shiftedArr, 0, shiftedArr.length - 1, 13));
    }

    public static int binarySearch(int arr[], int num) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            System.out.println(start + "," + end);
            int mid = (start + end) / 2;
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int arr[], int left, int right, int value) {
        System.out.println("binarySearch(" + left + "," + right + ")");
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (value < arr[mid]) {
            return binarySearchRecursive(arr, left, mid - 1, value);
        } else {
            return binarySearchRecursive(arr, mid + 1, right, value);
        }


    }


    public static int binarySearchShifted(int arr[], int left, int right, int value) {

        int pivotIndex = findPivot(arr, left, right);

        System.out.println("pivot:" + pivotIndex);
        int element = arr[0];
        if (value <element) {
            return binarySearchRecursive(arr, pivotIndex + 1, right, value);
        } else return binarySearchRecursive(arr, 0, pivotIndex - 1, value);
    }


    public static int findPivot(int arr[], int left, int right) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(left + "," + mid + "," + right);
            if (arr[mid] < arr[mid - 1]) return mid;
            if (arr[mid] < arr[left]) {
                right = mid - 1;
            } else left = mid + 1;

        }
        return -1;
    }

}
