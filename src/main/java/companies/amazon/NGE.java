package companies.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NGE {
	static Stack<Integer> stack = new Stack<Integer>();
	static List<Integer> arr = Arrays.asList(1, 2, 4, 3, 9,6,7,8,9, 8, 19, 21,10, 20, 7,10);

	public static void main(String[] args) {
		//System.out.println(coinSum(12));
		//recompose();
		System.out.println(nge());
	}
	
	static int max= Integer.MIN_VALUE;
	private static int coinSum(int n){
		if(n<5) return 0;
		int diff =  (n/2+n/3+n/4)-n;
		diff+=coinSum(n/2)+coinSum(n/3)+coinSum(n/4);
		return diff;
		
		
		

	}
	/*
	 *  1,2,4,3,9,5,10,6,8,7
	    0,0,0,1,0,1,0 ,2,2,3
	//array recomposition
   /*
    * 1   == 0
    * 1,2 ==0	
    * 1,2,4 ==0
    * 1,2,3,4 == 1
    * 1,2,3,4,9 ==0
    * 1,2,3,4,5,9 == 1
    * 1,2,3,4,5,9,10 == 0
    * 1,2,3,4,5,6,9,10 == 2 
    * 1,2,3,4,5,6,8,9,10 == 2
    * 1,2,3,4,5,6,7,8,9,10 ==3   
	/*
	 * 
5,9,3,6,10,7,1,8,4,2
0,0,2,1, 0,2,6,2,6,8
[1-10]
5  => 0
5,9,  => 0
3, 5, 9 => 2
3,5,6,9 => 1,
3,5,6,9,10 => 0,
3,5,6,7,9,10 => 2
1,3,5,6,7,9,10 => 6       10-6 =4 
1,3,5,6,7,8,9,10 => 2     10-2 =8 > 4,2 = 8
1,3,4,5,6,7,8,9,10 => 6   10-6 = 4;4>2 ==4
1,2,3,4,5,6,7,8,9,10 =>8   2

                 *
1,3,4,5,6,7,8,9,10,2
              *
1,3,5,6,7,8,9,10,4,2
             * 
1,3,5,6,7,9,10,8,4,2
           *
3,5,6,7,9,10,1,8,4,2

0,0,2,1, 0,2,6,2,6,8

*/
static int [] original={5,9,3,6,10,7,1,8,4,2};
static int [] sorted = {1,2,3,4,5,6,7,8,9,10};
static int [] shifted= {0,0,2,1,0,2,6,2,6,8};
private static void recompose(){
	int end = 9;
	while(end>0){
		int start=end-shifted[end];
		int temp = sorted[start];
		for(int i=start;i<end;i++){
			sorted[i]=sorted[i+1];
		}
		sorted[end] = temp;
		end--;
	}
	System.out.println(Arrays.toString(sorted));
	
	
}
	//(1, 2, 4, 3, 9, 4, 19, 21, 3, 7);
	// 1,2,4,3,9,4,19,21,3,7
	 static ArrayList<Integer> nge() {
		ArrayList<Integer> result = new ArrayList<Integer>(Collections.nCopies(arr.size(), 0));
		int i = 0;
		while (i<arr.size()-1) {
			stack.push(i);
			Integer next = arr.get(++i);
			System.out.println(arr.get(i-1)+"-"+next);
				while(!stack.empty() && next > arr.get(stack.peek()))
					result.set(stack.pop(), next);
			}
        return result;
		}

	}

