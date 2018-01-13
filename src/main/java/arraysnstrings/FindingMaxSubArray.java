package arraysnstrings;

public class FindingMaxSubArray {

	static void maxSubArray(int [] arr){
		int currStartIndex=0;
		int currEndIndex=0;
		int maxStartIndex=0;
		int maxEndIndex=0;


		int maxsum=Integer.MIN_VALUE;
		int currMaxSum=0;
		for(;currEndIndex<arr.length;currEndIndex++){

			currMaxSum+=arr[currEndIndex];

			if(currMaxSum>maxsum){
				maxsum=currMaxSum;
				maxStartIndex=currStartIndex;
				maxEndIndex=currEndIndex;

			}

			if(currMaxSum<0){
				currMaxSum=0;
				currStartIndex=currEndIndex+1;

			}


		}
		System.out.format("max sum:"+maxsum+"%nstart index:" +
				+maxStartIndex+"%nend index:"+maxEndIndex);
	}


	public static void main(String[] args) {
		int arr[]={1,2,-3,-4,1,4,-4,1,5,0};
		int arr1[]={1,-2,-3,-4};
		maxSubArray(arr1);



	}
}
