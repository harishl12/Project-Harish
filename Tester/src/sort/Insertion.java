package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Insertion {
	public static void main(String[] args) {
		int num[] = { 4, 2, 6, 23, 8, 34, 22, 8, 0, 1 };
		System.out.println(Arrays.toString(num));
		for (int i = 1; i < num.length; i++) {
			int key = num[i];
			int j = i - 1;
			while (j >= 0 && num[j] > key) {
				num[j + 1] = num[j];
				j--;

			}
			num[j+1] = key;
		}
		System.out.println(Arrays.toString(num));
	}
}
