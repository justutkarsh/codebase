package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//Find total number of pairs with difference
public class Solution {
	public static int N = 0;
	public static int k = 0;
	public static int[] arr;

	// 1,3,4,7,-1,4,5
	public static int solve() {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] + k))
				count++;
			if (map.containsKey(arr[i] - k))
				count++;

			map.put(arr[i], 1);
		}
		return count;
	}

	private static void readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = reader.readLine();
		line = line.trim();
		String[] tmp = line.split("\\s+");
		int[] result = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			result[i] = Integer.parseInt(tmp[i]);
		}
		N = result[0];
		k = result[1];
		String line1 = reader.readLine();
		line1 = line1.trim();
		String[] tmp1 = line1.split("\\s+");
		int[] result1 = new int[tmp1.length];
		for (int i = 0; i < tmp1.length; i++) {
			result1[i] = Integer.parseInt(tmp1[i]);
		}
		arr = result1;

	}

	private static int readInput1() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = reader.readLine();
		line = line.trim();

		return Integer.parseInt(line);

	}
	
	private static void FizzBuzz(int count){
		for(int i=1;i<=count;i++){
			if(i%3==0&&i%5==0) System.out.println("FizzBuzz");
			else if(i%3==0) System.out.println("Fizz");
			else if(i%5==0) System.out.println("Buzz");
		}
	}
	int getIntegerComplement(int n) {

	    int temp=n;
	    int bitmask=0;
	    while(temp>0){
	        temp>>=1;
	        bitmask=bitmask<<1|1;
	    }
	    n^=0xFFFFFFFF;
	    n=n&bitmask;
	    return n;
	}
	public static void main(String[] args) throws IOException {
		readInput();
		System.out.println(solve());
	}
}
