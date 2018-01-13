package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 16-10-2016.
 */
public class RearrangeArray {
    public static void main(String[] args) {

        // 0,1,4,3,5,2  -> 0,1,5,3,2

        //replace arr[i] with

    //  int k =    ( arr[i] + (arr[arr[i]]%n)*n))   now k/n = arr[arr[i]]
                                                        //k%n = arr[i];

        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 0, 1, 3, 2, 2));
        Solution solution = new Solution();
        solution.arrange(list);
        System.out.println(list);
    }

    static class Solution {

        public void arrange(ArrayList<Integer> a) {
            int n = a.size();
            for (int i = 0; i < a.size(); i++) {

                a.set(i, a.get(i) + (a.get(a.get(i))%n)*n);
                }

            for (int i = 0; i <a.size() ; i++) {
                a.set(i,a.get(i)/n);
            }

            }

        }

    }

