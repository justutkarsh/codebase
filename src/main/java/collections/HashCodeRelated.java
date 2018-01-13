package collections;

import java.util.HashMap;
import java.util.Map;

public class HashCodeRelated {
	
	
	static class MapEQ {

		  public static void main(String[] args) {
		   Map<ToDos, String> m = new HashMap<ToDos, String>();
		   ToDos t1 = new ToDos("Monday");
		   ToDos t2 = new ToDos("Monday");
		   ToDos t3 = new ToDos("Tuesday");
		   m.put(t1, "doLaundry");
		   m.put(t2, "payBills");
		   m.put(t3, "cleanAttic");
		   System.out.println(m.size());
		} }

		static class ToDos{

		  String day;

		  ToDos(String d) { day = d; }

		  public boolean equals(Object o) {
		      return ((ToDos)o).day == this.day;
		 }

		 public int hashCode() { return 9; }
		}
	
	public static void main(String[] args) {
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

		hm.put(1, 2);
		System.out.println(hm.hashCode());
		hm.put(3, 4);
		System.out.println(hm.hashCode());
		hm.put(5,6);
		System.out.println(hm.hashCode());
	
	MapEQ.main(args);
	}
}




