package collections;

public class Queue {
	Qnode front;
	Qnode rear;

	static class Qnode {
		int data;
		Qnode next;

		public Qnode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Queue enQueue(Queue queue, int data) {
		Qnode newNode = new Qnode(data);

		if (queue.rear == null) {
			queue.rear = newNode;
			queue.front = queue.rear;
		} else {
			queue.rear.next = newNode;
			queue.rear = newNode;
		}
		return queue;
	}

	public static void printQueue(Queue queue) {
		System.out.println("printing Queue ");
		Qnode front = queue.front;
		while (front != null) {
			System.out.print(front.data + " ");
			front = front.next;
		}
		System.out.println();
	}

	public static Qnode deQueue(Queue queue) {
		Qnode temp;
		if (queue.front == null) {
			System.out.println("Queue is empty");
			return null;
		} else {
			temp = queue.front;
			System.out.println("Dequeued data is " + temp.data);
			queue.front = queue.front.next;

		}
		return temp;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		enQueue(queue, 1);
		enQueue(queue, 2);
		enQueue(queue, 3);
		enQueue(queue, 4);
		enQueue(queue, 5);
		enQueue(queue, 6);
		enQueue(queue, 7);

		printQueue(queue);
		deQueue(queue);
		printQueue(queue);
		deQueue(queue);
		printQueue(queue);
		deQueue(queue);
		printQueue(queue);
	}
}
