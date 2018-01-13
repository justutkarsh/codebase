package recursionndynamicprogramming;

import java.util.Scanner;

/**
 * Created by utkarsh on 20-08-2016.
 */
public class Combination {


    public static long combination(int n, int r){
        if(r==0 || n == r) return 1;
        if(n<r) return 0;
        else
            return combination(n-1,r)+combination(n-1,r-1);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int R = scanner.nextInt();


       long sum =0;int i=0;
       while(i<=R){
           sum+=combination(N,i);
           i+=2;
       }

    }


}
