package codingIview;

public class HQueue {
	Node first;
	Node last;

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static HQueue add(HQueue queue, int data) {
		Node newNode = new Node(data);
		if (queue.last != null) {
			queue.last.next = newNode;
		}
		queue.last = newNode;
		if (queue.first == null)
			queue.first = queue.last;
		return queue;
	}

	public static void print(HQueue queue) {
		if (queue.first == null) {
			System.out.println("Empty queue");
		} else {
			Node current = queue.first;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	public static void peek(HQueue queue) {
		if (queue.first == null)
			System.out.println("Empty queue");
		else
			System.out.println("first element is " + queue.first.data);
	}

	public static HQueue remove(HQueue queue) {
		if (queue.first == null)
			System.out.println("Empty queue");
		else {
			Node current = queue.first;
			System.out.println("first element removed -> " + current.data);
			queue.first = current.next;
		}

		return queue;
	}

	public static void main(String[] args) {
		int[] info = { 4, 6, 1, 7, 2, 8, 3, 0, 5, 9 };
		HQueue queue = new HQueue();
		for (int i = 0; i < info.length; i++) {
			add(queue, info[i]);
		}
		print(queue);
		remove(queue);
		print(queue);
	}

}
