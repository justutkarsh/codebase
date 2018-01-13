package arraysnstrings;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateCharacterCheck {
	
	public static void main(String[] args) {
		//withoutDs();
		withDs();
		
	}

	private static void withoutDs() {
		Boolean[] map = new Boolean[256];
		Arrays.fill(map, false);
		
		String input="asdfjkllkjdfg";
		for(char c:input.toCharArray()){
			
			int index=Character.getNumericValue(c);
			if(map[index]==true){
				System.out.println(c+":duplicate found");
			}else{
				map[index]=true;
			}
			
			
		}
	}
	private static void withDs() {
	HashSet<Character> set = new HashSet<Character>();
	String input="akldsjfksjdf";
	for(char c:input.toCharArray()){
		
		if(!set.add(c)){
			System.out.println(c+":duplicate found");
		}
		
		
	}
	
	}

}
