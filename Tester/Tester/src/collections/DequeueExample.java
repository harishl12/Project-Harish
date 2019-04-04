package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueExample {
	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<Integer>();

		for (int i = 20; i > 10; i--) {
			dq.add(i);
		}
		System.out.println(dq);
		dq.poll();
		System.out.println(dq);
	}

}
