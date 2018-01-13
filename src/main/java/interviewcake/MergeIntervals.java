package interviewcake;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by utkarsh on 25-08-2016.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();

        input.add(new Interval(0,1));
        input.add(new Interval(1,10));
        input.add(new Interval(2,6));
        input.add(new Interval(3,5));
        input.add(new Interval(7,9));

        System.out.println("--Original--");

        input.stream().forEach(System.out::println);
        List<Interval> list = merge(input);

        System.out.println("--Merged--");
        list.stream().forEach(System.out::println);

    }

    private static List<Interval> merge(List<Interval> input) {

        List<Interval> sorted = input.stream().sorted((s,e)->s.start-e.start).
                collect(Collectors.toList());

        System.out.println("--Sorted--");
        sorted.stream().forEach(System.out::println);

        List<Interval> result = new ArrayList<>();
        int start = sorted.get(0).start;
        int end = sorted.get(0).end;

        for (int i=1;i<sorted.size();i++) {
            Interval current = sorted.get(i);
            if(current.start > end){
                result.add(new Interval(start,end));
                start = current.start;
            }
            end = Math.max(end,current.end);
        }
        result.add(new Interval(start,end));
        return result;

    }

    static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return
                    "{" + start +
                    "," + end +
                    '}';
        }





    }



}
