package algoritms;

import java.util.HashMap;

public class PairSum {
	
	static int [] arr = {1,4,6,8,-1,10,2,4,5,9};
	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	static void findPairs(int []arr, int sum){
		
		for(int i=0;i<arr.length;i++){
			
		if(map.containsKey(sum-arr[i])){
			System.out.println(arr[i]+"-"+(sum-arr[i]));
		}
		else map.put(arr[i],1);
		}
	}
	public static void main(String[] args) {
		findPairs(arr,14);
	}

}
