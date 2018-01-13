package interviewcake;

/**
 * Created by utkarsh on 23-08-2016.
 */
public class LargestThreeIntegerProduct {

    //1,2,3,-16,-500,8,10,11
    //-6,-7,-8,10,11,3,4

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 0, 8, 10, 11};
        System.out.println(greatMultiplyAll(arr));
        System.out.println(greatMultiply3Product(arr));
    }



    public static int greatMultiplyAll(int[] arr) {

        int currLargestPos = 1, currLargestNeg = 1;
        int globalLargestPos = Integer.MIN_VALUE, globalLargestNegative = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                currLargestPos = 1;
                currLargestNeg = 1;

            } else if (arr[i] > 0) {

                currLargestPos *= arr[i];

                if(currLargestNeg!=1)
                currLargestNeg *= arr[i];


            } else {
                int tempLargestNeg = currLargestNeg;
                currLargestNeg = currLargestPos * arr[i];
                currLargestPos = tempLargestNeg * arr[i];
            }

            if (currLargestPos < 1) currLargestPos = 1;

            globalLargestPos = Math.max(currLargestPos, globalLargestPos);
            globalLargestNegative = Math.min(currLargestNeg, globalLargestNegative);


        }

        return globalLargestPos;
    }

    //interviewcake int[] arr = {1, 2, 3, -16, -500, 8, 10, 11};
    public static int greatMultiply3Product(int [] arr){
        int highestproductof3,
              highestproductof2,
              lowestproductof2,
              highest,
              lowest;

        highest = Math.max(arr[0],arr[1]);
        lowest = Math.min(arr[0],arr[1]);

        highestproductof3 = highestproductof2 = lowestproductof2 = arr[0]*arr[1];

        for (int i = 2; i < arr.length; i ++) {
            int element = arr[i];
            highestproductof3 =
                    Math.max(highestproductof3,
                            Math.max(lowestproductof2*element,highestproductof2*element));

            highestproductof2 = Math.max(Math.max(highestproductof2,highest*element),lowest*element);

            lowestproductof2 = Math.min(Math.min(lowestproductof2,lowest*element),highest*element);

            if(element < lowest)
                lowest = element;
            if(element > highest)
                highest = element;

        }

        return highestproductof3;
    }



   //unverified approach
     public static int greatMultiply3(int[] arr){
         //find top 3 maximum and bottom two minimum in linear scan. return greater of two

         int max=Integer.MIN_VALUE, secondmax=Integer.MIN_VALUE,
                 thirdmax=Integer.MIN_VALUE,
                 min = Integer.MAX_VALUE, secondmin = Integer.MAX_VALUE;

         //assuming at least three elements in array

         for(int i = 0;i < arr.length;i++) {
             int element = arr[i];
             if(element>max) {
                 max = element;
                 secondmax =max;
                 thirdmax =secondmax;
             } else if (element > secondmax && element <= max) {
                 secondmax = element;
                 thirdmax = secondmax;
             } else if(element > thirdmax && element <= secondmax){
                 thirdmax = element;
             } else if (element < min) {
                 min = element;
                 secondmin = min;
             } else {
                 if(element < secondmin && element >=min){
                     secondmin = element;
                 }
             }

         }

         return  Math.max(max*secondmax*thirdmax,max*min*secondmin);
     }

}
