package companies.hortonworks;

import interviewbit.LargestNumber;

import java.util.ArrayList;

/**
 * Created by utkarsh on 06-10-2016.
 */
public class InfinitedSortedSearch {

    public static void main(String[] args) {
        Solution s = new Solution();

        ArrayList<Integer> nonDuplicateList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            nonDuplicateList.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(0);

        }
        for (int i = 0; i < 100; i++) {
            list.add(1);

        }

        ArrayList<Integer> finitelist = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            finitelist.add(i);
        }

        System.out.println(s.search(nonDuplicateList, 99));
        System.out.println(s.firstOccurrenceOfOne(list, 0));
        System.out.println(s.firstOccurrenceOfOneWithFiniteLength(list));
        System.out.println(s.findLengthOfArray(finitelist, 0));

    }

    static class Solution {
        int firstOccurrenceOfOne(ArrayList<Integer> list, int offset) {
            int l = offset, h = l + 1, f = 1;
            if (list.get(l) == 1) return l;
            else if (list.get(h) == 1) return h;
            {
                while (list.get(h) < 1) {
                    l = h;
                    f = 2 * f;
                    h = offset + f;
                }
                return firstOccurrenceOfOne(list, l);
            }
        }

        // cannot use size function
        int firstOccurrenceOfOneWithFiniteLength(ArrayList<Integer> list) {
            if (list.isEmpty()) return -1;
            if (list.get(0) == 1) return 1;
            int length = findLengthOfArray(list, 0), l = 0, h = length - 1;

            //now simple binary search
            while (h >= l) {
                int m = l + (h - l) / 2;

                if (list.get(m) == 1) {
                    if (list.get(m - 1) == 0) return m;
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return -1;
        }

        // you cannot use size function
        //0,1,2,3,4,5,6--,7,8,9,10,11,12
        int findLengthOfArray(ArrayList<Integer> list, int offset) {
            int low = offset, f = 1, high = low + f;
            try {
                while (true) {
                    list.get(high);
                    low = high;
                    f = f * 2;
                    high = offset + f;
                }
            } catch (Exception e) {
                if (high - low == 1) return low + 1;
                else
                    return findLengthOfArray(list, low);

            }

        }


        int binarySearch(ArrayList<Integer> list, int element, int l, int h) {

            if (l <= h) {
                int mid = l + (h - l) / 2;

                if (list.get(mid) == element) return mid;
                else {

                    if (element > list.get(mid)) return binarySearch(list, element, mid + 1, h);
                    else return binarySearch(list, element, l, mid - 1);
                }
            }
            return -1;
        }

        int search(ArrayList<Integer> list, int element) {
            int l = 0, h = 1;
            while (element > list.get(h)) {
                l = h;
                h = 2 * h;
            }
            return binarySearch(list, element, l, h);
        }

    }

}

