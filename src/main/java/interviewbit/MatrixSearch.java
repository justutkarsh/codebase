package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 16-10-2016.
 */
public class MatrixSearch {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList(Arrays.asList(1,3,5,7)));
        matrix.add(new ArrayList(Arrays.asList(10,11,16,20)));
        matrix.add(new ArrayList(Arrays.asList(23,30,34,50)));


//        matrix.add(new ArrayList(Arrays.asList(1)));
//        matrix.add(new ArrayList(Arrays.asList(10)));
//        matrix.add(new ArrayList(Arrays.asList(23)));


        Solution s = new Solution();
        System.out.println(s.searchMatrix(matrix,10));


    }
    static class Solution {
        public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
            int rows = a.size(), cols = a.get(0).size();
            int low =0, high= rows*cols-1;

            while (high >= low){
                int mid = (low+high)/2;

                int row  = mid/cols;
                int col = mid % cols;
                int element = a.get(row).get(col);
              if(element == b)return 1;
                else if(b < element) high = mid-1;
                else low = mid+1;

            }

            return 0;





        }
    }

}
