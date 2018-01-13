package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by utkarsh on 18-09-2016.
 */
public class WaveSort {
    static class Solution {
        public ArrayList<Integer> wave(ArrayList<Integer> a) {
            ArrayList<Integer> result = new ArrayList<>(a);
            Collections.sort(result);

            if(result.size()<=1) return  result;
            else if(result.size()==2) {
                swap(result,0,1);
               return result;
            }
            else{
                int k=0;
                while(k<result.size()-1){
                    swap(result,k,k+1);
                    k+=2;
                }

                return result;

            }


        }

        private void swap(ArrayList<Integer> result,int i,int j) {
            int temp = result.get(i);
            result.set(i,result.get(j));
            result.set(j,temp);
        }

        public static void main(String[] args) {
            Solution s = new Solution();

            ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5,1,3,2,4));
            System.out.println(s.wave(arrayList));
        }
    }
}
