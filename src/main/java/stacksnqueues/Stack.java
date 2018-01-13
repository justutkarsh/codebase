package stacksnqueues;

public class Stack<T> {

	Object[] data;
	int top;
	int capacity;
	int DEFAULT_CAPACITY=20;

	public Stack() {
		data=new Object[DEFAULT_CAPACITY];
		capacity=DEFAULT_CAPACITY;
		top=0;
	}

	public Stack(int size) {
		data=new Object[size];
		capacity=size;
		top=0;
	}

	public Boolean push(T element){
		if(top>capacity)
			return false;
		else{
			data[top++]=element;
			return true;
		}

	}

	public T pop(){
		if (top==0)
			return null;
		else{			
			return (T) data[--top];

		}


	}
	
	public int size(){
		return top;
	}

	public T  peek(){
		return (T) data[top];
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		
		System.out.println(st.pop());
		System.out.println(st.pop());
		
		
	}

}
