package progs2;

import java.util.Arrays;

public class TrainMinimumPlatforms {

	static int minimumPlatforms(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int platformsNeeded = 1;
		int result = 1;

		int i = 1;
		int j = 0;

		while (i < n && j < n) {
			if (arr[i] < dep[j]) {
				platformsNeeded++;
				i++;
			} else {
				platformsNeeded--;
				j++;
			}
			if (platformsNeeded > result)
				result = platformsNeeded;

		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = arr.length;
		System.out.println("Minimum Number of stations required is " + minimumPlatforms(arr, dep, n));
	}
}
