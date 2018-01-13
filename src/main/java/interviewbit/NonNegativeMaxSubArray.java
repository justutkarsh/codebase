package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 18-09-2016.
 */
public class NonNegativeMaxSubArray {
    static public class Solution {
        public ArrayList<Integer> maxset(ArrayList<Integer> a) {
            ArrayList<Integer> result = new ArrayList<>();
            int currstart = 0, currend = 0, maxstart = 0, maxend = 0;
            long currsum = 0, maxsum = Integer.MIN_VALUE, seg = 0, maxseg = 0;
            for (int i = 0; i < a.size(); i++) {
                int element = a.get(i);
                if (element < 0 && i < a.size() - 1) {
                    currstart = currend = i + 1;
                    seg = 0;
                    currsum = 0;
                } else {
                    seg++;
                    currsum += element;
                    if (currsum > maxsum) {
                        currend = maxend = i;
                        maxstart = currstart;
                        maxsum = currsum;
                        maxseg = seg;
                    } else if (currsum == maxsum) {
                        if (seg > maxseg) {
                            currend = maxend = i;
                            maxstart = currstart;
                            maxsum = currsum;
                            maxseg = seg;
                        }
                    }

                    if (i == a.size() - 1) {
                        if (maxsum < 0) return new ArrayList<>();
                        for (i = maxstart; i <= maxend; i++)
                            result.add(a.get(i));
                        return result;
                    }
                }
            }
            return result;
        }


        public static void main(String[] args) {

            ArrayList<Integer> buffer = new ArrayList<>
                    (Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
            Solution s = new Solution();
            System.out.println(s.maxset(buffer));
        }
    }


}
