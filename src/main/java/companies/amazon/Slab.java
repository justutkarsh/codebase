package companies.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Stack;

class Slab implements Comparable<Slab> {
	int length;
	int breadth;

	public Slab(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public int compareTo(Slab o) {
		if (length < o.length)
			return -1;
		else if (length > o.length)
			return 1;
		else {
			if (breadth < o.breadth)
				return -1;
			else if (breadth > o.breadth)
				return 1;
			else
				return 0;
		}
	}
	
public String toString(){
	return length+"-"+breadth;
}
	public static void main(String[] args) {

		Random random = new Random();
		List<Slab> list = new ArrayList<Slab>();
		for (int i = 0; i < 20; i++) {
			int len = random.nextInt(20) + 1;
			int brea = random.nextInt(20) + 1;
			list.add(new Slab(len, brea));
			list.add(new Slab(brea,len));

		}
		Collections.sort(list);
		System.out.println(list.size());
		System.out.println(Arrays.deepToString(list.toArray()));
	 
		Slab minSlab = new Slab(Integer.MIN_VALUE,Integer.MIN_VALUE);
		List<Stack<Slab>> stackList = new ArrayList<Stack<Slab>>();
		while(!list.isEmpty()){
			Stack<Slab> stack = new Stack<Slab>();
			stack.add(minSlab);
			ListIterator<Slab> i = list.listIterator();
			while(i.hasNext()){
				Slab top = stack.peek();
				Slab s = i.next();
				if(s.length>top.length&&s.breadth>top.breadth)
				{
					stack.add(s);
					i.remove();
				}
			}
			stackList.add(stack);
			
		}
		int count=1;
		for(Stack<Slab> s : stackList){
			System.out.println("Stack no. --->"+ count+"Stack Size --->"+ s.size());
			while(!s.isEmpty()){
				System.out.println(s.pop().toString());
			}
			count++;
		}
	
	}
}


