package recursionndynamicprogramming;

import java.util.*;

//L[A[i] = 1 + {max LA[j]} i>j a[i]>a[j]  L(x) = length of longest increasing subsequence ending at element x in array including x
//Two solutions are there O(N^2) and O(nlogn)
public class LIS {
static int arr[] = {2,6,4,5,1,3}; //l1=1 l2=2 l3 =2 l4=3 l5=1 l6=2
static int sizes[] = new int[arr.length];
static String paths[] = new String[arr.length];
//O(n^2) solution
static void printLIS(){
	for(int i = 0; i<arr.length;i++){
		paths[i]=arr[i]+"";
		sizes[i]=1;
		
	}
	
	for(int i=1;i<arr.length;i++)
	{
		for(int j=0;j<i;j++)
		{
			if(arr[j]<arr[i]&&sizes[j]+1>sizes[i]){
				paths[i]=paths[j]+arr[i];
				sizes[i]=sizes[j]+1;
			}
		
		}
	}
	System.out.println(Arrays.toString(paths));
}

//O(nlogn) solution
/*
2

2
2,6

2
2,4

2
2,4,5

1
2,4,5

1
1,3
2,4,5

1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.

2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].

3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. Clone and extend this list by A[i].
 We will discard all other lists of same length as that of this modified list.

*/
static void printLISTOpt(){
	HashMap<Integer,List<Integer>> map = new HashMap();
	
	List<Integer> endElements = new ArrayList<Integer>() {
	    public boolean add(Integer mt) {
	        int index = Collections.binarySearch(this, mt);
	        if (index < 0) index = ~index;
	        super.add(index, mt);
	        return true;
	    }
	};
	
	
	endElements.add(arr[0]);
	for(int i=1;i<arr.length;i++){
		if(arr[i]<endElements.get(0))
		{   
			List<Integer> list = new ArrayList<Integer>();
			list.add(arr[i]);
			map.put(arr[i],list);
			endElements.add(arr[i]);
		}else
			if(arr[i]>endElements.get(endElements.size()-1)){
				List list = map.get(endElements.get(endElements.size()-1));
				list.add(arr[i]);
//				List newList = new ArrayList<Integer>(list);
//				newList.add(arr[i]);
//				map.put(arr[i],newList);
			}
			else{
				
			}
		
		
	}
	
}

public static void main(String[] args) {
	//printLIS();
	List<Integer> list = new ArrayList<Integer>() {
	    public boolean add(Integer mt) {
	        int index = Collections.binarySearch(this, mt);
	        if (index < 0) index = ~index;
	        super.add(index, mt);
	        return true;
	    }
	};
	Random rand = new Random();
	for(int i=0;i<10;i++){
		list.add(rand.nextInt(30));
	}
	System.out.println(Arrays.toString(list.toArray()));
}
}
