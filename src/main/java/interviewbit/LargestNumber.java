package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by utkarsh on 23-09-2016.
 */
public class LargestNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        System.out.println(s.largestNumber(list));
    }

    public static class Solution {
        // DO NOT MODIFY THE LIST
        public String largestNumber(final List<Integer> a) {

            List<Integer> b = a.stream().sorted((x, y) -> {

                String first = String.valueOf(x);
                String second = String.valueOf(y);

               return -1*(first+second).compareTo(second+first);

            }).collect(Collectors.toList());

            StringBuffer sb = new StringBuffer();
            for (Integer i : b) {
                sb.append(i);
            }

            int k=0;
            while(k<sb.length()-1&&sb.charAt(k)=='0')
                k++;
            return sb.substring(k);
        }
    }
}
