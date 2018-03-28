package datastructures.linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {
     SingleLinkedList<Integer> sl;
	
    @Before
	public void createList(){
		sl=new SingleLinkedList<Integer>();
	}
	
	@Test
	public void testAdd() {
		sl.add(1);
		sl.add(2);
		sl.add(3);
	
	assertTrue(sl.size()==3);
	sl.remove(2);
	assertTrue(sl.size()==2);
	}

	

}
