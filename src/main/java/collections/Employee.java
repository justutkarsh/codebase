package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Employee {
	String name;
	Employee(String name){
		this.name=name;
	}

	@Override
	public int hashCode() {
		final int seed = 37;
		int result = 1;
		result = seed * (result + name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object o){

		if (o instanceof Employee) {
			Employee e = (Employee)o;
			if (this == e)
				return true;
			else if (this.name.equals(e.name));
			return true;

		}
		return false;

	}
	
	public static void print(List<String> empList){
		for (String o :empList){
			System.out.print(o+"|");
		}
	 System.out.println("\n");
	}

	public static void main(String[] args) {
		Employee e = new Employee("anil");
		Employee e1 = new Employee("anil");

		List<String> list = new ArrayList<String>( Arrays.asList(args));
		print(list);
		
		for(ListIterator<String> i = list.listIterator();i.hasNext();){
			String str=i.next();
			String trimmedStr=str.trim();
			
			
			i.remove();
			i.add(trimmedStr);
		
			
		}
		
		print(list);
		//		System.out.println(e.equals(e1));
//
//		Set<Employee> s = new HashSet<Employee>();
//		s.add(e1);
//		s.add(e);
//		System.out.println(s.size());
		
//		HashMap<Employee,String> hm = new HashMap<Employee,String>();
//		hm.put(e,"this should be the outupt");
//		
//		Employee e3 = new Employee("anil");
//		System.out.println(hm.get(e3));



//       List<Integer> l= new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
//       
//       System.out.println(l);
//       List<Integer> sl = l.subList(2, 4);
//       
//       System.out.println(sl);
//            
//       l.set(2,0);
//       
//       System.out.println(sl);
//     
//    
      




	}	
//	public int indexOf(E e) {
//	    for (ListIterator<E> it = 
//	         listIterator(); it.hasNext(); )
//	        if (e == null ? it.next() == 
//	            null : e.equals(it.next()))
//	            return it.previousIndex();
//	    // Element not found
//	    return -1;
//	}
}