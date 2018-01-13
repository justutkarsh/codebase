package companies.flipkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	static String[] review1;
	static String[] review2;
	//[loved, the, display, its, bright, and, clear, battery, life, is, not, good]
	//[battery, lif, no, good, display, is, nice, very, bright, love, it]
private static double bruteMatch(){
	int matched=0;
	for(String s2:review2)
		for(String s1:review1)
		{
			if(s1.startsWith(s2)||s2.startsWith(s1))
				matched++;
		
	}
	System.out.println(review2.length);
	double result = (double)matched/review2.length;
	result = Double.parseDouble(new DecimalFormat("##.###").format(result));
	return result;
	
}
/*
#1
create a Map<Key,Count> map of review1;
count occurences for every word in review2 and prefix/suffix string word from map
return count 

#2
sort both the reviews and maintain pointers1 and pointer2 in review1 & review2 break and compare

#3 sort the review1
for each key in review2 perform a search in review1 match and compare.
*/

private static double  optimizedMatch(){
	HashMap<String,Integer> map = new HashMap();
	ArrayList<String> review2List = new ArrayList<String>();
	
	for(String s:review1)
		map.put(s, 0);
	return 0.0;
	
}
private static void readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = reader.readLine();
		line = line.trim();
		String[] tmp = line.split("\\s+");
		String[] result = new String[tmp.length];
		
		for (int i = 0; i < tmp.length; i++) {
			result[i] = tmp[i].replaceAll("[.,]","").toLowerCase();
		}
		review1=result;
		
		String line2 = reader.readLine();
		line2 = line2.trim();
		String[] tmp2 = line2.split("\\s+");
		String[] result2 = new String[tmp2.length];
		
		for (int i = 0; i < tmp2.length; i++) {
			result2[i] = tmp2[i].replaceAll("[.,]","").toLowerCase();
		}
		
		review2=result2;

	}

public static void main(String[] args) throws IOException {
	readInput();
	System.out.println(bruteMatch());


}

}
