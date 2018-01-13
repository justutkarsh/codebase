package companies.hortonworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by utkarsh on 19/10/16.
 */

public class BalancedParenthesis {
    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        Solution s = new Solution();
        s.balancedParenthesis(3, 3, "", result);
        //s.balancedParenthesis1(0, 0, "", result, 3);

        result.forEach(System.out::println);


    }

    static class Solution {

        void balancedParenthesis(int open, int close, String buffer, List<String> result) {

            if (open > close) return;
            if (open < 0 || close < 0) return;
            if (open == 0 && close == 0) {
                result.add(buffer);
                return;
            }
            balancedParenthesis(open - 1, close, buffer + "(", result);
            balancedParenthesis(open, close - 1, buffer + ")", result);
        }


        void balancedParenthesis1(int open, int close, String buffer, List<String> result, int n) {
            System.out.println("open = " + open + ", close = " + close + " buffer : " + buffer + " n = " + n);
            if (close > open) return;
            if (open > n || close > n) return;
            if (open == n && close == n) {
                result.add(buffer);
                return;
            }

            balancedParenthesis1(open + 1, close, buffer + "(", result, n);
            balancedParenthesis1(open, close + 1, buffer + ")", result, n);
        }


    }
}