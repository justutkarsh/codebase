package datastructures.stacksnqueues;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    
	List<Integer>intList;
	EasyStack<Integer> stack;
	@Before
	public void setup(){
		
		Scanner in = new Scanner(System.in).useDelimiter(",");
		intList = new ArrayList<Integer>();
		stack=new EasyStack<Integer>();
		while(in.hasNext()){
			intList.add(in.nextInt());			
		}
		
		
	}
	
	@Test
	public void testPush() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(4);
		assertTrue(4 == stack.pop());
		assertTrue(3 == stack.pop());
		assertTrue(3 == stack.pop());
		assertTrue(2 == stack.pop());
		assertTrue(1 == stack.pop());
	}

	

}
