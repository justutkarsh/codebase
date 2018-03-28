package datastructures.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {

	public static void removeWithBuffer(SingleLinkedList sl){

		HashSet<Integer> hs =  new HashSet<Integer>();
		Node<Integer> n = sl.root;

		if(n==null)return;
		else
			hs.add(n.data);
		while(n.next!=null){
			if(!hs.add(n.next.data)){
				n.next=n.next.next;
			}else
				n=n.next;
		}






	}

	public static void removeWithBuffer1(SingleLinkedList sl){

		HashSet<Integer> hs =  new HashSet<Integer>();
		Node<Integer> n = sl.root;
		Node<Integer> prev = null;

		while(n!=null){
			if(!hs.add(n.data)){
				prev.next=n.next;
			}else{
				prev=n;
			}
			
			n=n.next;
		}






	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> sl = new SingleLinkedList<Integer>();
		sl.add(1);
		sl.add(2);
		sl.add(3);
		sl.add(2);
		sl.add(3);
		sl.add(1);
		sl.print();

		removeWithBuffer1(sl);

		sl.print();
	}
}
