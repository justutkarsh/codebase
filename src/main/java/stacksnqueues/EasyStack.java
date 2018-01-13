package stacksnqueues;

import java.util.ArrayList;

public class EasyStack<E> extends ArrayList<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void push(E e){
		add(e);
	}
	
	public E pop(){
		E e = get(size()-1);
		remove(size()-1);
	    return e;
	}

}
