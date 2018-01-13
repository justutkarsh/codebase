package algoritms;

public class MergeSort {

	int [] helper;
	int [] elements;
	
	public MergeSort(int [] values){
		this.elements=values;
		this.helper = new int[values.length];
		mergesort(0,values.length-1);
	}

	public void mergesort(int low, int high){
          System.out.format("mergesort(%d,%d) called",low,high);
          System.out.println();

		//end conditions
		if(high>low){
			int mid = (low + high)/2;
			mergesort(low,mid);
			mergesort(mid+1,high);
			merge(low,mid,high);
		}
	}

	private  void merge( int low, int mid, int high) {
		System.out.format("merge(%d,%d,%d) called",low,mid,high);
		System.out.println();
		// TODO Auto-generated method stub
	//	print();
		for(int i=low;i<=high;i++){
			helper[i]=elements[i];
		}

		int a=low;
		int b=mid+1;
		
		int count=low;
		while(a<=mid && b<=high){
			if(helper[a]<helper[b]){
				elements[count++]=helper[a];
				a++;
			}
			else{
				elements[count++]=helper[b];
				b++;

			}
		}
	//	print();
		for(int i=a;i<=mid;i++){
			elements[count++]=helper[i];
		}
		
	}

	public void print(){
		for (int i:elements){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		int a[] = {3,2,6,4,5,8,49,19,33,1,25,30,58};
		MergeSort m =new MergeSort(a);
		m.print();
		
		

	}
}
