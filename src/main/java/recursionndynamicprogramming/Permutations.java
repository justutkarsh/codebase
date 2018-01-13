package recursionndynamicprogramming;

import java.util.*;

public class Permutations {

	static ArrayList<String> perm(String input) {
		ListWithName<String> permutations = new ListWithName<String>("name-"+new Random().nextInt());
		if(input==null) return null;
		else
		if (input.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char ch = input.charAt(0);
		ArrayList<String> remPerms = perm(input.substring(1));

		for (String w : remPerms) {

			for (int i = 0; i < w.length(); i++) {
				String left = w.substring(0, i);
				String right = w.substring(i);
				String comb = left + ch + right;
				permutations.add(comb);
			}

		}

		return permutations;
	}

	public static ArrayList<String> getPerms(String s) {
		//this was just to check that a new List is created with each call
		ListWithName<String> permutations = new ListWithName<String>("name-"+new Random().nextInt());
		if (s == null) { // error case
			return null;
		} else if (s.length() == 0) { // base case
		
			permutations.add("");
			return permutations;
		}
		char first = s.charAt(0); // get the first character
		String remainder = s.substring(1); // remove the first character
		ArrayList<String> words = getPerms(remainder);
			for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String st=insertCharAt(word,first,j);
				System.out.println(st+"->"+permutations.name);
				permutations.add(st);
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0){
			System.out.println(prefix);
		}
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}

	}

	public static void main(String[] args) {
				ArrayList<String> p = getPerms("monkey");
		
			System.out.println(Arrays.toString(p.toArray()))	;
			
			String a="c";
			

		//permutation("monkey");
			
			//Test Cases
			String s="y";
			System.out.println(s.substring(1));
			ArrayList<String> list = new ArrayList<String>();
			list.add(s.substring(1));
			System.out.println(list.size());
			String blank="";
			list.add(blank);
			System.out.println(list.size());
			System.out.println(list.toArray());
			
			list.add(null);
			
			System.out.println(list);
			
			System.out.println(blank.substring(0,0)+"-"+blank.substring(0));
			System.out.println(blank.length());
            
			Collection<String>c = new LinkedHashSet<String>();
			c.add("");
			c.add("");
			c.add(null);
			
			System.out.println(Arrays.toString(c.toArray()));
			
			

	}

}
