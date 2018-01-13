package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 23-09-2016.
 */
public class SetMatrixZero {
    public static void main(String[] args) {
        Solution s = new Solution();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

//        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));
//        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
//        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));

        matrix.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 1)));


        s.setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix.toArray()));

    }

    static class Solution {
        public void setZeroes(ArrayList<ArrayList<Integer>> a) {
            int C = a.get(0).size(), R = a.size();
            boolean firstRowZero = false, firstColumnZero = false;

            for (int i = 0; i < R; i++)
                if (a.get(i).get(0) == 0) {
                    firstColumnZero = true;
                    break;
                }

            for (int j = 0; j < C; j++)
                if (a.get(0).get(j) == 0) {
                    firstRowZero = true;
                    break;
                }


            for (int i = 1; i < R; i++)
                for (int j = 1; j < C; j++) {

                    if (a.get(i).get(j) == 0) {
                        a.get(0).set(j, 0);
                        a.get(i).set(0, 0);
                    }

                }

            for (int j = 1; j < C; j++)
                if (a.get(0).get(j) == 0)
                    setCol0(a, j, R);

            for (int i = 1; i < R; i++)
                if (a.get(i).get(0) == 0)
                    setRow0(a, i, C);


            if (firstRowZero)
                setRow0(a, 0, C);

            if (firstColumnZero)
                setCol0(a, 0, R);

        }


        private void setRow0(ArrayList<ArrayList<Integer>> a, int r, int cols) {
            for (int i = 0; i < cols; i++)
                a.get(r).set(i, 0);
        }

        private void setCol0(ArrayList<ArrayList<Integer>> a, int c, int rows) {
            for (int i = 0; i < rows; i++)
                a.get(i).set(c, 0);
        }
    }

}
