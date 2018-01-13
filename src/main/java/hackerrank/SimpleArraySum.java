package hackerrank;

/**
 * Created by utkarsh on 24-07-2016.
 */

import java.util.Scanner;
import java.util.stream.Stream;

public class SimpleArraySum {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int size = Integer.parseInt(scanner.nextLine());
            String input = scanner.nextLine();
            String[] array = input.split("\\s+");
            int sum = Stream.of(array).mapToInt(Integer::parseInt).sum();
            System.out.println(sum);

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named LinkedListPalindrome. */
    }
}
