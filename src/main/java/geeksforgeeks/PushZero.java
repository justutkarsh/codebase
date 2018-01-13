package geeksforgeeks;

import java.util.Arrays;

/**
 * Created by utkarsh on 11-08-2016.
 */
public class PushZero {
    public static void main(String[] args) {

        int arr[] = {6,7,3,9,0,-1,5,0,0,3,4,7};
        Arrays.stream(arr).forEach(s-> System.out.print(s+","));
        int start =0,end = arr.length-1;
        while(start<end){
            while(arr[end]==0) end--;
            while(arr[start]!=0) start++;
            if(arr[start]==0){
                arr[start]=arr[end];
                arr[end]=0;
                start++;
                end--;
            }
        }
        System.out.println();
        Arrays.stream(arr).forEach(s-> System.out.print(s+","));


    }
}
