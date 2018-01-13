package companies.AmazonSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Set {
	private static int coinSum(int n){
		if(n<5) return 0;
		int diff =  (n/2+n/3+n/4)-n;
		diff+=coinSum(n/2)+coinSum(n/3)+coinSum(n/4);
		return diff;
		
		
		

	}
	/*
	 *  1,2,4,3,9,5,10,6,8,7
	    0,0,0,1,0,1,0 ,2,2,3
	//array recomposition
   /*
    * 1   == 0
    * 1,2 ==0	
    * 1,2,4 ==0
    * 1,2,3,4 == 1
    * 1,2,3,4,9 ==0
    * 1,2,3,4,5,9 == 1
    * 1,2,3,4,5,9,10 == 0
    * 1,2,3,4,5,6,9,10 == 2 
    * 1,2,3,4,5,6,8,9,10 == 2
    * 1,2,3,4,5,6,7,8,9,10 ==3   
	/*
	 * 
5,9,3,6,10,7,1,8,4,2
0,0,2,1, 0,2,6,2,6,8
[1-10]
5  => 0
5,9,  => 0
3, 5, 9 => 2
3,5,6,9 => 1,
3,5,6,9,10 => 0,
3,5,6,7,9,10 => 2
1,3,5,6,7,9,10 => 6       10-6 =4 
1,3,5,6,7,8,9,10 => 2     10-2 =8 > 4,2 = 8
1,3,4,5,6,7,8,9,10 => 6   10-6 = 4;4>2 ==4
1,2,3,4,5,6,7,8,9,10 =>8   2

                 *
1,3,4,5,6,7,8,9,10,2
              *
1,3,5,6,7,8,9,10,4,2
             * 
1,3,5,6,7,9,10,8,4,2
           *
3,5,6,7,9,10,1,8,4,2

0,0,2,1, 0,2,6,2,6,8

*/
static int [] original={5,9,3,6,10,7,1,8,4,2};
static int [] sorted = {1,2,3,4,5,6,7,8,9,10};
static int [] shifted= {0,0,2,1,0,2,6,2,6,8};
private static void recompose(){
	int end = 9;
	while(end>0){
		int start=end-shifted[end];
		int temp = sorted[start];
		for(int i=start;i<end;i++){
			sorted[i]=sorted[i+1];
		}
		sorted[end] = temp;
		end--;
	}
	System.out.println(Arrays.toString(sorted));
	
	
}
//4 geeksforgeeks
//Question 1:- Given an array of infinite size containing 0/1 only and in sorted order, find position of first one.
static int arr[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

private static int findOneInfiniteArray(int offset){
	 if(arr[0]==1) return 0;
	 if(arr[offset]==1&& arr[offset-1]==0)	return offset;
	
	 for(int i=1;true;i=i<<1){
		 System.out.println(offset+"-"+i+"-"+arr[i]);
			if(arr[offset+i]==1){
				if(arr[offset+i-1]==0)
					return offset+i;
				else
				return findOneInfiniteArray(offset+(i>>1));
				
			}
		
	}
	
}
/*
 * 1. Sort the intervals based on increasing order of starting time.
2. Push the first interval on to a stack.
3. For each interval do the following
��..a. If the current interval does not overlap with the stack top, push it.
��..b. If the current interval overlaps with stack top and ending time of current interval is more than that of stack top, update stack top with the ending time of current interval.
4. At the end stack contains the merged intervals.
 */

static class Interval implements Comparable<Interval>{
	int start;
	int end;
	static Random rand = new Random();
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	public Interval() {
	}
	@Override
	public int compareTo(Interval i) {
		// TODO Auto-generated method stub
		if(start<i.start) return -1;
		else if(start>i.start) return 1;
		else return 0;
	}
	
	public static  Interval next(){
		int start = rand.nextInt(55);
		return new Interval(start,start+rand.nextInt(10));
	}
	
	@Override
	public String toString() {
    return start+"-"+end;
	}
}
//static int [][] intervals ={{1,3}, {2,4}, {5,7}, {6,8} };

public static void mergeOverlappingIntervals(){
	List<Interval> ilist = new ArrayList<Interval>();
	Stack<Interval> stack = new Stack<Interval>();
	for(int i=0;i<50;i++){
		ilist.add(Interval.next());
	}
	System.out.println("original list"+Arrays.toString(ilist.toArray()));
	Collections.sort(ilist);
	System.out.println("sorted list"+Arrays.toString(ilist.toArray()));
	
	stack.push(ilist.get(0));
	  for(int i =1;i<ilist.size()-1;i++)
	  {
		Interval curr = ilist.get(i);
		Interval stackTop = stack.peek();
		if(curr.start>stackTop.end)
			stack.push(curr);
		else{
			Interval merged = new Interval(stackTop.start,curr.end>=stackTop.end?curr.end:stackTop.end);
			stack.pop();
			stack.push(merged);
		}
		
	  }
	
	  System.out.println("Merged Intervals");
	 while(!stack.isEmpty()) 
		 System.out.println(stack.pop());
	
}
//Given life time of different elephants find period when maximum number of elephants lived. ex [5, 10], [6, 15], [2, 7] etc. year in which max no elephants exists.
static class MaxInterval extends Interval{
     String span;
	public MaxInterval(int start, int end) {
		super(start, end);
		
		// TODO Auto-generated constructor stub
	}
	
	public MaxInterval(Interval next) {
		super(next.start,next.end);
		span = String.format("%03d", next.start)+"b"+String.format("%03d", next.end)+"e";	
		}

	public int compareTo(MaxInterval s) {
		// TODO Auto-generated method stub
		return s.span.compareTo(span);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
public static void maxiumumOverlappingIntervals(){
	List<MaxInterval> list = new ArrayList<MaxInterval>();
	for(int i=0;i<12;i++){
		list.add(new MaxInterval(Interval.next()));
	}
	List<String> span = new ArrayList<String>();
	for(MaxInterval i:list){
		
		span.add(i.span);
	}
	Collections.sort(span);
	Integer max_count =Integer.MIN_VALUE;
	int count=0;
	for(String s:span){
		if(s.contains("b"))
			count++;
		else
			count--;
		if(count>max_count) max_count=count;
		System.out.println(count+"-"+max_count);
	}
	System.out.println(Arrays.toString(span.toArray()));
	System.out.println(Arrays.toString(list.toArray()));
	System.out.println("Maximum Elephanst lived="+max_count);
}

public static void main(String[] args) {
	//System.out.println(findOneInfiniteArray(0));
	mergeOverlappingIntervals();
	maxiumumOverlappingIntervals();
}
}
