package geeksforgeeks;


import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * Created by utkarsh on 11-08-2016.
 * Example Input and Output for Your Program:

 Input:
 2
 4
 1 2 3 4
 3
 5
 10 90 20 30 40
 40
 Output:
 2
 4
 Explanation:

 There are 2 test cases (Note 2 at the beginning of input)
 Test Case 1: Input: arr[] = {1, 2, 3, 4},
 Element to be searched = 3.
 Output:  2
 Explanation: 3 is present at index 2.

 Test Case 2: Input: arr[] = {10, 90, 20, 30, 40},
 Element to be searched = 40.
 Output:  4
 Explanation: 40 is present at index 4.
 */
public class ReadInput {

    public static int search(int[] arr, int size, int element) {
        OptionalInt present = Arrays.stream(arr).filter(x -> x == element).findFirst();
        if (present.isPresent()) {
            return present.getAsInt();
        }else {
            return Integer.parseInt(null);
        }


    }

    public static void main(String[] args) {
        // Note that size of arr[] is considered 100 according to
        // the constraints mentioned in problem statement.
        int[] arr = new int[100];

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t > 0) {
            // Input the size of the array
            int n = sc.nextInt();

            // Input the array
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            // Input the element to be searched
            int x = sc.nextInt();

            // Compute and print result
                   System.out.println(search(arr, n, x));

            t--;


        }
    }
}
