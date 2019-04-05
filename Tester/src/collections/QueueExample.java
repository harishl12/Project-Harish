package collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
	public static void display(Queue<String> qe) {
		for (String e : qe)
			System.out.println(e);

	}

	public static void main(String[] args) {
		PriorityQueue<String> qe = new PriorityQueue<>();

		qe.add("Sachin");
		qe.add("Amul");
		qe.add("Rahul");
		qe.add("Harry");

		for (String s : qe)
			System.out.println(s);
		qe.remove();
		System.out.println();
		System.out.println("After remove");
		QueueExample.display(qe);

		qe.poll();
		System.out.println();
		System.out.println();
		System.out.println("After poll");
		QueueExample.display(qe);

	}
}
