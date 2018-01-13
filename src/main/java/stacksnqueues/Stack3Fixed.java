package stacksnqueues;

//using fixed divisions
public class Stack3Fixed {

	Integer[] buffer;
	int STACK_SIZE=100;
	int [] stackPointer ={0,0,0};
	public Stack3Fixed(){
		buffer=new Integer[3*STACK_SIZE];	
	}

	public Boolean push(int stackNum,int element){

		if(stackPointer[stackNum]>STACK_SIZE) return false;
		else{
			int index=(stackNum)*STACK_SIZE+stackPointer[stackNum];
			buffer[index]= element;	
			stackPointer[stackNum]++;
			return true;
		}
	}
	public Integer pop(int stackNum){
		
		if(0==stackPointer[stackNum]){
			System.out.println("Empty Stack");
			return null;
		}	
		else{
			int index=(stackNum)*STACK_SIZE+stackPointer[stackNum]-1;
			stackPointer[stackNum]--;
			int data=buffer[index];
			buffer[index]=0;
			return data;
		}
	}

    public static void main(String[] args) {
    	Stack3Fixed st = new Stack3Fixed();
    	st.push(0, 1);
    	st.push(1, 1);
    	st.push(2, 1);
    	st.push(2, 3);
    	st.push(0, 3);
    	st.push(1, 5);
    	st.push(1, 6);
    	st.push(1, 7);
    	
    	System.out.println(st.pop(0));
    	System.out.println(st.pop(0));
    	System.out.println(st.pop(1));
    	System.out.println(st.pop(1));
    	System.out.println(st.pop(1));
		
	}
}