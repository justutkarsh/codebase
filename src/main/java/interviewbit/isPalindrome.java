package interviewbit;

/**
 * Created by utkarsh on 07-09-2016.
 */
public class isPalindrome {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
     //  input=",.";
        System.out.println(isPalindrome(input));
    }

    public static int isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j ) {
            while ( i<s.length() && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))) {
                i++;
            }
            while (j>0 && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j)))) {
                j--;
            }

            if(i<s.length()&&j>=0)
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return 0;
            i++;j--;
        }
        return 1;
    }
}
