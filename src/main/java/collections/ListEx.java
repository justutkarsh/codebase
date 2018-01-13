package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
 class Car implements Comparable{
	public Car(int year) {
		super();
		this.year = year;
	}
	int year;
	int model;
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Car c = (Car)o;
		if(c.year<this.year) return -1;
		else 
			if(c.year>this.year) return 1;
			else
		return 0;
	}
	
	public String toString(){
		return ""+year;
	}
}
 

public class ListEx {
public static void main(String[] args) {
	final List<String>list= new ArrayList<String>();
	
	list.add("one");
	list.add("two");
	System.out.println(list);
	
	changeData(list);
	
	List<Car> carList = new ArrayList<Car>();
	Random random = new Random();
	for(int i=0;i<10;i++){
		
		carList.add(new Car(random.nextInt()));
		
	}

  System.out.println(Arrays.deepToString(carList.toArray()));
  Collections.sort(carList);
  System.out.println(Arrays.deepToString(carList.toArray()));
  
}

private static void changeData(List<String> list) {
	// TODO Auto-generated method stub
	list.add("three");
	System.out.println(list);
	
	list = new ArrayList<String>();
	list.add("four");
	System.out.println(list);
}
}
