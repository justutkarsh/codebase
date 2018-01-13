package collections;

import java.util.ArrayList;
import java.util.List;

public class expArrList {

public static void main(String[] args) {
	List<Integer> l = new ArrayList<Integer>();
	l.add(1);
	l.add(2);
	List<String> s = new ArrayList<String>();
	s.add("thislkdjf");
	s.add("munna");
	
	for(String st:s){
		System.out.println(st.hashCode());
	}
	
	
	for(Integer i:l){
	System.out.println(i.hashCode());
	

	}
}

}
