package sort;

import java.util.Arrays;

public class Insertion2 {
	public static void main(String[] args) {
		int a[] = { 3, 2, 9, 1, 6, 8, 32, 6, 9, 23, 87, 24, 54 };
		System.out.println(Arrays.toString(a));
		for(int i = 1 ; i < a.length ; i++) {
			int key = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
		System.out.println("Sorted "+ Arrays.toString(a));
	}
}
