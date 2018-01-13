package geeksforgeeks;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void pushZero(int[] arr,int size){
        int start =0,end = size-1;
        while(start < end){
            while(end>=0 && arr[end]==0) end--;
            while(start < size-1 && arr[start]!=0) start++;
            if(arr[start]==0 && start < end){
                arr[start]=arr[end];
                arr[end]=0;
                start++;
                end--;
            }
        }
        
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
         System.out.println();
    }

    public static void main (String[] args) {
	 // Note that size of arr[] is considered 100 according to
        // the constraints mentioned in problem statement.
        int[] arr;

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t > 0) {
            // Input the size of the array
            int n = sc.nextInt();
            arr = new int[n];

            // Input the array
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            pushZero(arr,n);

            t--;


        }

	}
}