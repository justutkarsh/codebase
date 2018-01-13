package syntax;

public class PassByValue {


	static void changet(int d){
		d=4;
	}
	
	static void changet(Integer d){
		d=4;
		System.out.println(d.toString());
	}
	
	static void changeArray(int a[]){
		a[0]=0;
		a[1]=0;
		a[2]=0;
		a[3]=0;
	}
	
	static void printArray(int a[]){
		for (int i:a){
			System.out.print(i+",");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		Integer t=3;
		changet(t);
		System.out.println(t);
		
		int a[]={1,2,3,4};
		printArray(a);
		changeArray(a);
		printArray(a);


	}
}
