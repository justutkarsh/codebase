package interviewbit;

/**
 * Created by utkarsh on 16-10-2016.
 */
public class PallindromicInteger {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(2147447412);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(s.isPalindrome(2147447412));

    }

    static class Solution {
        //12121
        public boolean isPalindrome(int a) {
           if(a<0) return false;

            int pow10 = 1, n = a;
            while (n / 10 > 0) {
                n = n / 10;
                pow10 *= 10;
            }

            if(pow10 == 1) return true;

            while (pow10 > 1){
                int first = a / pow10, last = a % 10;
                if (first != last) return false;

                a= (a-first*pow10)/10;
                pow10=pow10/100;
            }
           return  true;
        }
        //String s = String.valueOf(a);
    }

}
