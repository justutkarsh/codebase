package algoritms;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MergeSortTimeComplexity {

	static HashMap<Integer,List<String>> levelMap= new HashMap<Integer,List<String>>(); 
	
	public static void midRangesStore(int low, int high, int level) {
        
		String a = new String("("+low+","+high+")");
		if(levelMap.get(level) != null)
			levelMap.get(level).add(a);
		else{
			List<String> l = new ArrayList<String>();
			l.add(a);
			levelMap.put(level,l);
		}
	
		
		
		if (low > high)
			return;

		int mid = (low + high) / 2;
		midRangesStore(low, mid - 1, level+1);
		midRangesStore(mid + 1, high, level+1);

	}

	public static void printRanges(){
	  Set<Integer> keyList = levelMap.keySet();
	  TreeSet<Integer> s = new TreeSet<Integer>(keyList);	 
	  for(int i:s){
		  System.out.println(Arrays.toString(levelMap.get(i).toArray()));
	  }
	}
	
	public static void main(String[] args) {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
				
		Boolean proceed=true;
		
		while (proceed) {
			try {
				
				String s;
				
				
				System.out.print("Enter Low:");
				int low = Integer.parseInt(stdin.readLine());
				System.out.print("Enter High:");
				int high = Integer.parseInt(stdin.readLine());
				System.out.println("low="+low+"high="+high);
				
				midRangesStore(low, high, 0);				
				printRanges();			
				
				System.out.println("Proceed (y/n)");
				s=stdin.readLine();
				
				if(s.toUpperCase().equals("N"))
					proceed=false;
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
