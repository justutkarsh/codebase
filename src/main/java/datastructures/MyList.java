package datastructures;

import java.util.Arrays;

public class MyList<E> {

	private Object [] elements;
    int DEFAULT_CAPACITY=10;
	int size;
	
	
	MyList(){
		size=0;
		elements = new Object[DEFAULT_CAPACITY];
		
	}
	
	
	public void add(E e){
		if(size>elements.length){
			elements=Arrays.copyOf(elements,2*size);
			
			
		}
		
		elements[size++]=e;
		
	}
	
	public E get(int index)
	{
		return (E) elements[index];
	}

public static void main(String[] args) {
	MyList<String> list = new MyList<String>();
	list.add("anil");
	list.add("suressh");
	list.add("dinest");
	
	System.out.println(list.get(1));
	System.out.println(list.get(2));
}
}


