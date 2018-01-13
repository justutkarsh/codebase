package algoritms;

public class QuickSort {

	int[] elements;
	
	public QuickSort(int []a){
		this.elements=a;
		quicksort(0,elements.length-1);
	}
	
	
	public void quicksort(int low,int high){
	
		int mid= (low+high)/2;
		int pivot=elements[mid];
		
		int i=low,j=high;
		
		while(i<=j){
			
			while(elements[i]<pivot){
				i++;
			}
			
			while(elements[j]>pivot){
				j--;
			}
			
			if(i<=j){				
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j]=temp;
				i++;
				j--;
			}
			
			
		print();	
			
		}
		if(low<j)
		quicksort(low,j);
		if(i<high)
		quicksort(i,high);
	
	}
	
	public void print(){
		for(int a:elements){
			System.out.format("%d,",a);
		}
		System.out.println();
	}
	
   public static void main(String[] args) {
	int a[]={1,4,3,12,8,4,6,9,0};
	QuickSort q =new QuickSort(a);
	q.print();
}   

}
