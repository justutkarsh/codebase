package datastructures.stacksnqueues;

import java.util.ArrayList;

public class Queue<E> extends ArrayList<E> {

   public static void main(String[] args) {
	Queue<Integer> q = new Queue<Integer>();
	q.add(1);
	q.add(2);
	q.add(3);
	q.add(4);

	q.deque();
	System.out.println(q.deque());
	System.out.println(q.deque());
	System.out.println(q.deque());
}

  public void queue(E e) {
    add(e);
  }

  public E deque() {
    E e = get(0);
    remove(0);
    return e;
  }
}
