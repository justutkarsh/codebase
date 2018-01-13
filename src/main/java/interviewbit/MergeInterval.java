package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by utkarsh on 18-09-2016.
 */
public class MergeInterval {


    // * Definition for an interval.
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

   static  class Solution {

        private Boolean intersect(Interval a, Interval b)
        {
            if(b.start < a.end && b.end > a.start) return true;
            else return false;
        }


        private Interval merge(Interval a, Interval b){

            int start = Math.min(a.start,b.start);
            int end = Math.max(a.end,b.end);
            return new Interval(start,end);

        }
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            ArrayList<Interval> buffer = new ArrayList<>();
            Interval merge = newInterval;

            if(merge.start>merge.end){
                merge = new Interval(merge.end,merge.start);
            }

            if(intervals.isEmpty()){
                buffer.add(merge);
                return buffer;
            }

            Interval first = intervals.get(0);
            Interval last = intervals.get(intervals.size() - 1);
            boolean done = true;
            if(merge.end< first.start){
                buffer.add(merge);
                buffer.addAll(intervals);
                return buffer;
            } else {
                if(merge.start> last.end){
                    buffer.addAll(intervals);
                    buffer.add(merge);
                    return buffer;
                }else if(merge.start<= first.start && merge.end>= last.end)
                {
                    buffer.add(merge);
                    return buffer;
                }
                else{
                    for(Interval i: intervals)
                    {
                        if(intersect(i,merge)){
                            merge = merge(i,merge);
                            if(i==last){
                                buffer.add(merge);
                            }

                        }else if(merge.end<i.start && done )
                        {
                            buffer.add(merge);
                            buffer.add(i);
                            done=false;
                        }

                    }
                }
            }
            return buffer;

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> buffer = new ArrayList<>(Arrays.asList(6037774, 6198243, 6726550, 7004541, 8842554, 10866536, 11027721, 11341296, 11972532,
                14746848, 16374805, 16706396, 17557262, 20518214, 22139780, 22379559, 27212352, 28404611, 28921768,
                29621583, 29823256, 32060921, 33950165, 36418956, 37225039, 37785557, 40087908, 41184444, 41922814,
                45297414, 48142402, 48244133, 48622983, 50443163, 50898369, 55612831, 57030757, 58120901, 59772759,
                59943999, 61141939, 64859907, 65277782, 65296274, 67497842, 68386607, 70414085, 73339545, 73896106,
                75605861, 79672668, 84539434, 84821550, 86558001, 91116470, 92198054, 96147808, 98979097));

        Solution solution = new Solution();

       // System.out.println(solution.insert(buffer, new Interval(36210193, 61984219)));

    }



}
