package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 14-10-2016.
 * Given [1,2,0] return 3,
 * <p>
 * [3,4,-1,1] return 2,
 * <p>
 * [-8, -7, -6] returns 1
 * <p>
 * Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {

        Solution s = new Solution();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 4, -1, 1));
        System.out.println(s.firstMissingPositive(list));

    }

    static class Solution {
        public int firstMissingPositive(ArrayList<Integer> A) {
                int n=A.size();
                for(int i=0;i<n;i++){
                    if(A.get(i)>0&&A.get(i)<=n){
                        if(A.get(i)-1!=i&&A.get(A.get(i)-1)!=A.get(i)){
                            int temp=A.get(A.get(i)-1);
                            A.set(A.get(i)-1,A.get(i));
                            A.set(i,temp);
                            i--;
                        }
                    }
                }
                for(int i=0;i<n;i++)
                    if(A.get(i)!=i+1)
                        return i+1;
                return n+1;
        }



        public int firstMissing(ArrayList<Integer> a)
        {
            int n = a.size();
            for (int i = 0; i < n; i++) {

                if(a.get(i)>0 && a.get(i) <=n)
                {
                    if(a.get(i)-1 == i) continue;

                    int temp = a.get(a.get(i) -1);

                    a.set(a.get(i)-1,a.get(i));
                    a.set(i,temp);


                }

            }
            for (int i = 0; i < n ; i++) {
                if(a.get(i) != i+1)
                    return i+1;


            }
            return n+1;
        }
    }


}
