package collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {

public static void main(String[] args) {
	HashSet set = new HashSet();
	set.add("utkarsh");
	set.add("utkarsh");
	set.add("nitiraj");
 System.out.println(set.size());
 
 Class<?> clazz = set.getClass();
 
 System.out.println(clazz.getCanonicalName());
 try {
	Set<String>ns =(Set<String>) clazz.newInstance();
	ns.add("babu");
	System.out.println(ns.size());
} catch (InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
