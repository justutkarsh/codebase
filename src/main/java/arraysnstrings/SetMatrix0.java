package arraysnstrings;

import interviewbit.LargestNumber;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 03-10-2016.
 */
public class SetMatrix0 {
   static class Solution {
        public void setZeroes(ArrayList<ArrayList<Integer>> a) {

            int C = a.get(0).size(), R =a.size();
            int [] rowsTo0 = new int[R];
            int [] colsTo0 = new int[C];

            for(int i=0;i<C;i++)
                for(int j=0;j<R;j++)
                {
                    if(a.get(i).get(j)==0){
                        colsTo0[i]=1;
                        rowsTo0[j]=1;
                    }
                }

            for(int i=0;i<C;i++)
                if(colsTo0[i]==1)
                setCol0(a,i,R);

            for(int i=0;i<R;i++)
                 if(rowsTo0[i]==1)
                 setRow0(a,i,C);
        }



        private void setRow0(ArrayList<ArrayList<Integer>> a,int r,int cols){
            for(int i=0;i<cols;i++)
                a.get(r).set(i,0);
        }

        private void setCol0(ArrayList<ArrayList<Integer>> a,int c,int rows){
            for(int i=0;i<rows;i++)
                a.get(i).set(c,0);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ArrayList<ArrayList<Integer>> buffer = new ArrayList<>();
        buffer.add(new ArrayList<Integer>(Arrays.asList(1,1,0)));
        buffer.add(new ArrayList<Integer>(Arrays.asList(1,1,1)));
        buffer.add(new ArrayList<Integer>(Arrays.asList(0,1,0)));


        solution.setZeroes(buffer);

        System.out.println(Arrays.deepToString(buffer.toArray()));
    }


}
