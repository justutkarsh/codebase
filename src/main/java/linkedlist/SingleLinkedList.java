package linkedlist;

public class SingleLinkedList<T> {

	public Node<T> root=null;
	public SingleLinkedList(Node<T> head){
		root=head;
	}
	
	public SingleLinkedList() {
	}

	public Node<T> add(T data){
		if(root==null){
			Node<T> n = new Node<T>(data);
			root=n;
			return n;
		}
		else{
			Node<T> t=root;
			while(t.next!=null){
				t=t.next;
			}
			Node<T> n = new Node<T>(data);
			t.next=n;
		   return n;
		}

	}

	public void remove(T data){

		Node<T> t = root;
		if(t.data.equals(data)){
			root=t.next;
			return;
		}



		while(t.next!=null){
			if(t.next.data.equals(data)){
				t.next=t.next.next;
				return;	
			}

			t=t.next;

		}

	}
   
	public void print(){
		Node<T> t = root;
		if(t==null) return;
		while(t!=null){
			System.out.print("["+t.data+"],");
			t=t.next;
		}
	 System.out.println();
	}
	
	public static void print(Node<?> root){
		Node<?> t = root;
		if(t==null) return;
		while(t!=null){
			System.out.print("["+t.data+"],");
			t=t.next;
		}
	 System.out.println();
	}
	
	public int size(){
		int count=1;
		Node<T> t = root;
		if(t==null) return 0;
		while(t.next!=null){
			count++;
			t=t.next;
		}
		return count;
	}
	public static int size(Node<?> head){
		int count=1;
		Node<?>t=head;
		if(t==null) return 0;
		while(t.next!=null){
			count++;
			t=t.next;
		}
		return count;
	}

}
