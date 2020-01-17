package test;

import java.util.Arrays;

public class SplitTest {
	public static void main(String[] args) {
		String raid = "Raid5-7+1";

		System.out.println(Arrays.toString(raid.split("-")[1].split("\\+")));
	}
}
