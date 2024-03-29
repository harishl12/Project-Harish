package collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;

public class PrioritQueueExample {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		pq.add(null);
		for (int i = 1; i < 10; i++) {
			pq.add(new Integer(i));
		}
		
		System.out.println(pq);

		// System.out.println(pq.element());
		//
		// System.out.println(pq.peek());
		pq.poll();
		System.out.println(pq);
		System.out.println(pq.peek());
	}
}
