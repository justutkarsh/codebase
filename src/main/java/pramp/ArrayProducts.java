package pramp;

import java.util.Arrays;

/**
 * Created by utkarsh on 21-08-2016.
 */
public class ArrayProducts {

    /*
    replace array with product of all other elments at other index

    1 2 3 4 5   -->  2*3*4*5 1*3*4*5 1*2*4*5 1*2*3*5  1*2*3*4
     */

    public static int[] optimizedMultiplyArray(int [] arr){
        int [] output = new int[arr.length];
        int productSoFar=1;
        for(int i = 0; i<arr.length; i++){
            output[i] = productSoFar;
            productSoFar *= arr[i];
        }
        productSoFar =1;
        for(int j = arr.length-1; j>=0;j--){
            output[j] *= productSoFar;
            productSoFar *= arr[j];
        }
        return output;
    }

    public static int[] multiplyArray(int [] arr){
        int []outputPrefix = new int[arr.length];
        int []outputSuffix = new int[arr.length];

        int []output = new int[arr.length];

        outputPrefix[0] = 1;
        for(int i = 1;i< arr.length; i++){
            outputPrefix[i]=outputPrefix[i-1]*arr[i-1];
        }

        Arrays.stream(outputPrefix).forEach(System.out::println);

        outputSuffix[arr.length - 1] = 1;
        for(int j=arr.length-2;j>=0;j--){
            outputSuffix[j]=outputSuffix[j+1]*arr[j+1];
        }

        Arrays.stream(outputSuffix).forEach(System.out::println);

        for(int i = 0; i<arr.length; i++){
            output[i] = outputPrefix[i]*outputSuffix[i];
        }
        return  output;
    }

    public static void main(String[] args) {

    int[] arr = {1,2,3,4,5};

        Arrays.stream(optimizedMultiplyArray(arr)).forEach(System.out::println);

    }




}
