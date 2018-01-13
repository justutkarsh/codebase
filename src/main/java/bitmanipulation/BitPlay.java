package bitmanipulation;

public class BitPlay {

	public static void swap(Integer i,Integer j,int start,int end)
	{		
		System.out.println("i="+Integer.toBinaryString(i));	
		System.out.println("j="+Integer.toBinaryString(j));	
		System.out.println("start="+start);	
		System.out.println("end="+end);	

		j<<=2;
		int temp=0xFFFF;
		int maskLength=end-start+1;

		temp<<=maskLength;

		for(int m=0;m<start;m++){
			temp<<=1;
			temp|=1;
		}

		
		Integer result=(i&temp)|j;
		System.out.println(Integer.toBinaryString(result));
	}
	
	
	public static int stringtoBinary(String input){
		//44.78
		
	return 44;	
		
	}
	//find those two non-repeating elements using XOR
	
	public static void get(int [] arr){
		
	}


	public static void main(String[] args) {

		//swap(98,5,2,4);
//		System.out.println(1<<68);
//		for(int i=0;i<31;i++){
//			System.out.println(Integer.toBinaryString(1<<i));
//	
//		}
		int xor=0;
		int arr[]={2, 4, 7, 9, 2, 4};
		for(int i:arr){
			System.out.println(Integer.toBinaryString(i));
			xor^=i;
		}
		System.out.println(Integer.toBinaryString(xor));
		
		
	}
}
