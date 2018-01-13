package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 18-09-2016.
 */
public class Permutation {
    static class Solution {
        public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            Solution s = new Solution();
            System.out.println(s.permute(list));
        }

        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
            //System.out.println(a);
            if (a.size() == 1) {
                ArrayList<ArrayList<Integer>> result = new ArrayList<>();
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a.get(0));
                result.add(temp);
                return result;
            }

            Integer prefix = a.remove(0);

            ArrayList<ArrayList<Integer>> result = permute(a);
            ArrayList<ArrayList<Integer>> newResult = new ArrayList<>();

            for (ArrayList<Integer> number : result) {
                ArrayList buffer = new ArrayList(number);

                for (int i = 0; i <= number.size(); i++) {
                    buffer.add(i, prefix);
                    newResult.add(buffer);
                    buffer= new ArrayList(number);
                }
            }

            return newResult;

        }
    }
}
