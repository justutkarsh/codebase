package treesngraphs;

import java.util.ArrayList;
import java.util.Collections;

public class TestArrayLIst {
	public static void main(String argv[])
	{
		ArrayList<Integer> list = new ArrayList<Integer>(10);
//		Collections.fill(list, 9);
//		for(int i = 0 ; i < 10 ; i++ )
//			list.add(i);
		
		System.out.println("lits before : " + list);
		Collections.fill(list,new Integer(1));
		System.out.println("list = " + list);
		list.add(1,13333);
		System.out.println("list after = " + list);
	}
}
