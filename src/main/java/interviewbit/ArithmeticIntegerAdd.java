package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 23-09-2016.
 */
public class ArithmeticIntegerAdd {

    public static class Solution {

        public static void main(String[] args) {
            Solution s = new Solution();
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,0,0,0,1));
            System.out.println(s.plusOne(list));
        }
        public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

            Integer digit=0,carry=0;
            int one=1;

            for(int i = a.size()-1;i>=0;i--)
            {

                digit = carry + a.get(i)+one;

                carry = digit/10;
                digit = digit%10;
                one =0;
                a.set(i,digit);


                if(i==0 && carry==1)
                a.add(0,carry);


            }

            return clean(a);
        }

        private ArrayList<Integer> clean(ArrayList<Integer> a) {
            while(a.get(0)==0)
            {
                a.remove(0);
            }
            return a;
        }
    }
}
