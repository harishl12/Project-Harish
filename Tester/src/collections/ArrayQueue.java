package collections;

import java.util.ArrayDeque;

public class ArrayQueue {
	public static void main(String[] args) {
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		ad.push(1);
		ad.push(2);
		ad.push(3);
		ad.push(4);
		System.out.println(ad.peek());
	}
}
