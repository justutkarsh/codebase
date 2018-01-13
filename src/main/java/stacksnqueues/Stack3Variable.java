package stacksnqueues;

public class Stack3Variable {

	StackNode[] buffer;
	Integer[] stackPointer={-1,-1,-1};
	int STACK_SIZE=100;
	int indexUsed=0;

	public class StackNode{
		int data;
		int prev;
		public StackNode(int data,int p){
			this.data=data;
			this.prev=p;
			buffer=new StackNode[3*STACK_SIZE];
		}
		public StackNode(int data2) {
			// TODO Auto-generated constructor stub
			this.data=data2;
		}
	}


	public void push(int stackNum,int data){

		int lastIndex=stackPointer[stackNum];
		stackPointer[stackNum]=indexUsed;
		buffer[stackPointer[stackNum]]=new StackNode(data,lastIndex);

	}
	public int pop(int stackNum){

		StackNode top =buffer[stackPointer[stackNum]];
		buffer[stackPointer[stackNum]]=null;
		indexUsed--;
		int newTop=top.prev;
		stackPointer[stackNum]=newTop;
		return top.data;

	}

	int peek(int stack) { return buffer[stackPointer[stack]].data; }
	boolean isEmpty(int stackNum) { return stackPointer[stackNum] == -1; }
	
	public static void main(String[] args) {
		
	}

}
