package algoritms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import algoritms.TripleSum.Triplets;

//find a,b,c such that a+b+c=0;
public class TripleSum {

	static class Triplets {
		int a, b, c;

		public Triplets(int a, int b, int c) {
			super();
			List<Integer> sortedList = new ArrayList<Integer>();
			sortedList.add(a);
			sortedList.add(b);
			sortedList.add(c);
			Collections.sort(sortedList);
			this.a = sortedList.get(0);
			this.b = sortedList.get(1);
			this.c = sortedList.get(2);
		}

		public Triplets() {
			// TODO Auto-generated constructor stub
		}

		public String toString() {
			return (a + "," + b + "," + c);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			Triplets t = (Triplets) obj;
			if (a == t.a && b == t.b && c == t.c)
				return true;
			else
				return false;
		}

		@Override
		public int hashCode() {
			int prime = 37;
			prime = prime * a ;
			prime = prime * b + c;
			return prime;
		}
	}

	static Set<Triplets> findTriplets(int arr[]) {
		Set<Triplets> tList = new HashSet<Triplets>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				findPairs(arr, Math.abs(arr[i]), tList);
			}

		}
		return tList;
	}

	static private void findPairs(int[] arr, int sum, Set<Triplets> tList) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(sum - arr[i])) {
				// System.out.println(arr[i] + "-" + (sum - arr[i]));
				Triplets t = new Triplets(arr[i], sum - arr[i], -sum);
				tList.add(t);

			} else
				map.put(arr[i], 1);
		}

	}

	public static void main(String[] args) throws IOException {
		final int arr[] = { 1, 4, 6, 8, -1, 10, 2, 4, 5, 9, -9 };
		// int newarr[] = readInput();
		Set<Triplets> resultSet = findTriplets(arr);
		List<Triplets> list = new ArrayList<Triplets>(resultSet);
		Collections.sort(list, new Comparator<Triplets>() {
			public int compare(Triplets o1, Triplets o2) {
				if (o1.a < o2.a)
					return -1;
				else if (o1.a > o2.a)
					return 1;
				else if (o1.b < o2.b)
					return -1;
				else if (o1.b > o2.b)
					return 1;
				else if (o1.c < o2.c)
					return -1;
				else if (o1.c > o2.c)
					return 1;
				else
					return 0;
			}
		});

		System.out.print(list.toString());

	}

	private static int[] readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = reader.readLine();
		line = line.trim();
		String[] tmp = line.split("\\s+");
		int[] result = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			result[i] = Integer.parseInt(tmp[i]);
		}
		return result;
	}
}
