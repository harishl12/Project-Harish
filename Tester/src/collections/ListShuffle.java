package collections;

import java.util.ArrayList;
import java.util.Collections;

public class ListShuffle {
	public static void main(String[] args) {
		ArrayList<Integer> capacity = new ArrayList<Integer>();
		for (int i = 100; i < 875; i = i + 25) {
			capacity.add(i);
		}
		System.out.println(capacity);
		Collections.shuffle(capacity);
		System.out.println(capacity.size());
	}
}
