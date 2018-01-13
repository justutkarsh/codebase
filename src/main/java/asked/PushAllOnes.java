package asked;

import java.util.Arrays;

public class PushAllOnes {

    public static void main(String[] args) {
        Integer[] arr = {1,5,1,6,1,7,1,8,9};
        pushAllOnes(arr);

    }
//5,4,3,1,1,5,1,2
    private static void pushAllOnes(Integer[] arr) {
        int arrLength= arr.length;
        int index =0;
        for (int i=0; i < arrLength-1; i++){

            System.out.println(Arrays.deepToString(arr));
            if(arr[index]!= arr[i+1] && arr[index]==1){
                swap(index, i+1, arr);
                index++;
            }else if(arr[index]!=1){
                index++;
            }
        }
        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }

    private static void swap(int index, int i, Integer[] arr) {
        int temp = arr[index];
        arr[index]= arr[i];
        arr[i] =temp; 
        
    }

    

}
