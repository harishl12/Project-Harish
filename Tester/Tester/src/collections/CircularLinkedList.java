package collections;

public class CircularLinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static CircularLinkedList push(CircularLinkedList list, int data) {
		Node newNode = new Node(data);
		Node headRef = list.head;
		Node temp = headRef;
		newNode.next = headRef;
		// if (list.head == null) {
		// list.head = null;
		// newNode.next = newNode;
		// }
		// newNode.next = list.head;
		// list.head = newNode;
		if (headRef != null) {
			while (temp.next != headRef)
				temp = temp.next;
			temp.next = newNode;
		} else {
			newNode.next = newNode;
			list.head = newNode;
		}
		return list;
	}

	public static void printList(CircularLinkedList list) {
		Node currNode = list.head;
		System.out.println("printing list");
		if (currNode != null) {
			do {
				System.out.print(currNode.data + " ");
				currNode = currNode.next;
			} while (currNode != list.head);
		}
	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		push(list, 1);
		push(list, 2);
		push(list, 3);
		printList(list);
	}
}
