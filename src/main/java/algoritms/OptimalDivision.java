package algoritms;

public class OptimalDivision {
	static int result = 0;
	static int argSor = 3;
	static int argDent = 100;
	static int argQ = 1;

	static int optDiv(int dent, int sor, int q) {
		while (dent >= argSor) {
			System.out.println(dent + "-" + sor + "-" + q);
			int rest = dent - sor;

			if (rest < 0) {
				// result = result + q;
				sor = argSor;
				q = argQ;

			} else {
				dent = rest;
				result += q;
				sor = sor * 2;
				q = q * 2;
			}
		}
		return result;

	}

	// [89,90,108,109,1,2,3,4,5,8,13,23,44,68]
	static int rotationPoint(int arr[], int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;

		if (arr[mid] < arr[mid - 1] && mid > start)
			return mid;
		if (arr[mid] > arr[mid + 1] && mid < end)
			return mid + 1;
		if(arr[end]>arr[start])
			return start;

		if (arr[mid] < arr[end])
			return rotationPoint(arr, start, mid);
		else if (arr[mid] > arr[start])
			return rotationPoint(arr, mid, end);

		return -1;

	}
	
	static void printSpiral(int [][] arr){
		int rowStart = 0,rowEnd=arr.length-1;
		int colStart =0,colEnd=arr[0].length-1;
		
		int i =0;
		
		while(rowStart<=rowEnd && colStart<=colEnd){
			//printing top row
			for(i=colStart;i<=colEnd;i++){
				System.out.print(arr[rowStart][i]+",");
			}
			rowStart++;
			System.out.println();
			//printing right column
			for(i=rowStart;i<=rowEnd;i++){
				System.out.print(arr[i][colEnd]+",");
			}
			colEnd--;
			System.out.println();
			//printing bottom row
			for(i=colEnd;i>=colStart;i--){
				System.out.print(arr[rowEnd][i]+",");
			}
			rowEnd--;
			System.out.println();
			//printing left column
			for(i=rowEnd;i>=rowStart;i--){
				System.out.print(arr[i][colStart]+",");
			}
			colStart++;
			System.out.println();
			
		}
		
	}

	public static void main(String[] args) {
		System.out.println(optDiv(100, 3, 1));
		int arr[] = {2,3,4,5,8,13,23,44,68,1};
		System.out.println(rotationPoint(arr, 0, arr.length - 1));
		
		int [][]arr2d = {{2,3,4,5,8,13,23,44,68,1},
				         {2,3,4,5,8,13,23,44,68,1},
				         {2,3,4,5,8,13,23,44,68,1},
				         {2,3,4,5,8,13,23,44,68,1},
				         {2,3,4,5,8,13,23,44,68,1}};
printSpiral(arr2d);
		
	}
}
