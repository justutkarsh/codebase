package interviewbit;


import java.util.*;

/**
 * Created by utkarsh on 15-10-2016.
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        Solution s = new Solution();



        System.out.println(s.isPower(7988));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1024000000);
        System.out.println(s.gcd(4,3));
        System.out.println(s.gcd(6,2));
        System.out.println(s.gcd(16,12));



    }

    static class Solution {

        public boolean isPowerOptimal(int A) {
            double x=2;
            double i;
            if(A==1) return true;
            for(i=2;(i<33)&&(x<=(double)(Math.pow(2,16)));i++)
            {
                if(Math.pow(x,i)==(double)A) return true;
                if(Math.pow(x,i) >= (Math.pow(2,32))) {i=1;x++;}
            }
            return false;
        }
        private boolean isPower(int n) {

            if (n == 0 || n == 1) return true;
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();

            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {

                    if (frequencyMap.get(i) == null)
                        frequencyMap.put(i, 1);
                    else
                        frequencyMap.put(i, frequencyMap.get(i) + 1);
                    n = n / i;
                }
            }

            List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
            Collections.sort(frequencies);

            if (frequencies.isEmpty() || frequencies.get(0) == 1) return false;
            else {
                int result = frequencies.get(0);
                for (int i = 1; i < frequencies.size(); i++) {
                    result = gcd(result, frequencies.get(i));
                }
                if (result > 1) return true;
                else return false;
            }
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;

            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            return gcd(b, a % b);
        }

    }

    public ArrayList<Integer> allFactors(int a) {

        int upperlimit = (int) (Math.sqrt(a));
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i <= upperlimit; i += 1) {
            if (a % i == 0) {
                factors.add(i);
                if (i != a / i) {
                    factors.add(a / i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }
}

