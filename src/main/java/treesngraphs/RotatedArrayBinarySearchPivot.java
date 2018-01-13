package treesngraphs;

public class RotatedArrayBinarySearchPivot {
	static int arr[] = { 6, 7, 8, 9, 10, 12, 13, 14, 15, 1, 2, 3, 4 };

	static int findPivot(int low, int high) {
		if (low > high)
			return -1;
		if (arr[low] < arr[high])
			return low;
		int mid = low + (high - low) / 2;
		if (arr[low] <= arr[mid - 1] && arr[mid + 1] <= arr[high])
			return mid;

		else if (arr[mid] >= arr[low])
			return findPivot(mid, high);
		else
			return findPivot(low, mid);

	}

	static int findElement(int element, int low, int high) {
		int pivot = findPivot(low, high);
		if (element <= arr[high])
			return binarySearch(element, pivot, high);
		else
			return binarySearch(element, low, pivot);
	}

	static int binarySearch(int element, int low, int high) {
		if (low > high)
			return -1;
		int mid = low + (high - low) / 2;
		if (arr[mid] == element)
			return mid;
		if (element >= arr[mid])
			return binarySearch(element, mid + 1, high);
		else
			return binarySearch(element, low, mid - 1);

	}

	public static void main(String[] args) {
		System.out.println(findPivot(0, arr.length - 1));
		System.out.println(findElement(22,0,arr.length-1));
		System.out.println(findElement(-1,0,arr.length-1));
		System.out.println(findElement(8,0,arr.length-1));
		System.out.println(findElement(15,0,arr.length-1));
	}

}
