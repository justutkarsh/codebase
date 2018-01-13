package interviewbit;

/**
 * Created by utkarsh on 17-10-2016.
 */
public class PowerFunction {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pow(3, 3, 4));
        System.out.println(s.pow(2, 3, 3));
        System.out.println(s.powfixed(3, 3, 4));
        System.out.println(s.powfixed(2, 3, 3));
    }

    //x^y  --> (x x )^y/2
    static class Solution {

        public int pow(int x, int n, int d) {
            if (x == 0) return x;
            if (n == 0) return 1;
            int ans = 1;
            if (n % 2 != 0) {
                ans *= x;
                n--;
            }
            while (n > 0) {
                n = n >> 1; //y=y/2;
                ans *= ((x % d) * (x % d)) % d;
            }
            return ans;

        }

        public int powfixed(int x, int n, int d) {
            if (x == 0) return x;
            if (n == 0) return 1;
            int ans = 1;
            if (n % 2 != 0) {
                ans = (ans%d) * (x%d) %d;
                n--;
            }
            while (n > 0) {
                n = n >> 1; //y=y/2;
                ans*= ((x % d) * (x % d)) % d;
            }

            if(ans<0) return ans+d;
            return ans;

        }
    }


}

