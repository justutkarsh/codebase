package arraysnstrings;

import java.util.Arrays;

public class MinMissingPositiveInteger {

	public static void main(String[] args) {

		int a[]={-14,-7,7,4,2,5,6,1,0,29,30};

		System.out.println(findMin(a,a.length));

	}

	private static int findMin(int[] a, int length) {
		// TODO Auto-generated method stub


		for(int i=0;i<length;i++){
			if(a[i]>length)
				a[i]=-1;
		}

		System.out.println("before : = " + Arrays.toString(a));
		//special case if all integers are -ve return 0
		int tempElement = -1;
		for(int i=0;i<length;i++){
			if(a[i]>=0&&a[i]!=i){

				tempElement = a[i];
				a[i]=-1;

				while(tempElement>=0){
					int temp2=a[tempElement];
					a[tempElement]=tempElement;
					tempElement=temp2;
				}

			}


		}
		System.out.println("after="+Arrays.toString(a));
		
		for(int i=0;i<length;i++){
			if(a[i]<0){
				return i;
			}
		}
		
		return -1;
	}
	
}
