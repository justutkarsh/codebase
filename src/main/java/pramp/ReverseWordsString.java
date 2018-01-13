package pramp;

/**
 * Created by utkarsh on 01-09-2016.
 */
public class ReverseWordsString {

    public static void main(String[] args) {
        //exepected output perfect makes practice.

        char[] buffer = {'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't'};
        System.out.println(buffer);
        reverseWords(buffer);
        System.out.println(buffer);
    }

    private static void reverse(char[] buffer, int start, int end) {
        while (start < end) {
            char temp = buffer[start];
            buffer[start] = buffer[end];
            buffer[end] = temp;
            start++;
            end--;
        }
    }

    private static void reverseOptimized(char[] buffer) {
        int i=0;
        while (i < buffer.length/2) {
            char temp = buffer[i];
            buffer[i] = buffer[buffer.length-i-1];
            buffer[buffer.length-i-1] = temp;
            i++;
        }
    }


    private static void reverseWords(char[] buffer) {
        reverse(buffer, 0, buffer.length - 1);
        Integer wordstart = null, wordend = 0;
        for (int i = 0; i < buffer.length; i++) {
            if ((buffer[i]) == ' ') {
                if (wordstart != null) {
                    reverse(buffer, wordstart, i - 1);
                    wordstart = null;
                }

            } else if (i == buffer.length - 1) {
                if (wordstart != null)
                    reverse(buffer, wordstart, i);

            } else if (wordstart == null)
                wordstart = i;
        }

    }
}
