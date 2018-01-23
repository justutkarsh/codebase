package pramp;

/**
 * Created by utkarsh on 23/01/18.
 */

public class RootNumber {

  static class Solution {
    static double root(double x, int n) {
      double high = x,low =0,mid=0;

      while(Math.abs(high - low) >= 0.001d && high > low) {
        mid = (high + low) / 2;
        double temp = Math.pow(mid, n);
        System.out.println(high+","+low);
        if(temp==x) return mid;
        else if (temp > x)
          high = mid;
        else low=mid;

      }

      double scale = Math.pow(10, 3);
      return Math.round(mid * scale) / scale;

    }
    public static void main(String[] args) {
      System.out.println(Solution.root(4,2));
      System.out.println(Solution.root(4,3));

    }

  }

}
