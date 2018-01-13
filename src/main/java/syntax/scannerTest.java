package syntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class scannerTest {
	static List<Integer>intList;
	
	public static void setup(){
		
		Scanner in = new Scanner(System.in).useDelimiter(",");
		intList = new ArrayList<Integer>();
		while(in.hasNext()){
			System.out.println(in.nextInt());
			//intList.add(in.nextInt());			
		}
		
		
	}

public static void main(String[] args) {
	setup();
}
}
