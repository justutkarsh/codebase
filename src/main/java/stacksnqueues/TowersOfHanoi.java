package stacksnqueues;
import java.util.Iterator;
import java.util.Stack;

public class TowersOfHanoi {

	public static class Tower<T> extends Stack<T>{
		private static final long serialVersionUID = 1L;
		int towerNo;
		public Tower(int tNo){
			towerNo=tNo;
		}

		int getNo(){
			return towerNo;
		}
	}

	/*solving by recursion
	                     disk1|           |            |
	 *                   disk2|           |            |
	 *                   disk3|           |            |
	 *                  ------------   --------    ----------
	 *                  tower-1        tower-2        tower-3
	 * if n=1: we can move directly disc1(1->3)
	 * lets call this as move(t1,t3,t2,1) 
	 * 
	 * if n=2 disk1(1->2) disk2(1->3) disk1(2->3) we have moved disk 1&2 from tower-1 to tower-3 using tower-2 as buffer
	 * lets call this as move(t1,t3,t2,2)
	 * 
	 * if n=3 disk1(1->3) disk2(1->2) disk1(3->2)
	 *        till now we have moved disk 1&2 to tower-2 using tower-3 as buffer
	 *        now, disk3(1->3)
	 *        and now we can move disk 1&2 to tower-3 using tower-1 as buffer
	    so move(t1,t3,t2,3)= move(t1,t2,t3,2)+move(t1,t3,t2,1)+move(t2,t3,t1,2)
	 * */
	public static void move(Tower<Disc> origin,Tower<Disc> destination,
			Tower<Disc> buffer, int n){

		if(n==1)
		{
			System.out.println("never here");
			Disc d =origin.pop();
			destination.push(d);
			return;
		}
		if(n==2)
		{
			Disc d = origin.pop();
			buffer.push(d);
			destination.push(origin.pop());
			destination.push(buffer.pop());
			return;
		}

		move(origin,buffer,destination,n-1);
		move(origin,destination,buffer,1);
		move(buffer,destination,origin,n-1);


	}

	public static class Disc{
		int radius;

		public Disc(int r){
			radius=r;
		}

		public String toString(){
			return String.valueOf(radius);
		}
	}

	public static void main(String[] args) {
		Tower<Disc> t1 = new Tower<Disc>(1);

		for(int i=1;i<10;i++){
			t1.push(new Disc(10-i));
		}

		Tower<Disc> buffer = new Tower<Disc>(2);
		Tower<Disc> t2 = new Tower<Disc>(3);

		print(t1);
		print(buffer);
		print(t2);
		move(t1,t2,buffer,9);
		print(t1);
		print(buffer);
		print(t2);


	}

	public static void print(Tower t){
		Iterator it =t.iterator();
		System.out.format("tower no:%d ",t.getNo());
		while(it.hasNext()){
			System.out.format("%s,",it.next());
		}
		System.out.println();
	}
}
