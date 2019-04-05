package collections;

public class DoubleLinkedList {
	Node head;

	static class Node {
		int data;
		Node prev, next;

		Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	public static DoubleLinkedList push(DoubleLinkedList list, int data) {
		Node newNode = new Node(data);
		newNode.next = list.head;
		newNode.prev = null;
		if (list.head != null)
			list.head.prev = newNode;
		list.head = newNode;
		return list;
	}

	public static DoubleLinkedList insertAfter(DoubleLinkedList list, Node prev, int data) {
		Node newNode = new Node(data);
		if (prev == null) {
			System.out.println(prev + " Cannot be null");
			return list;
		}
		newNode.next = prev.next;
		newNode.prev = prev;
		prev.next = newNode;

		if (newNode.next != null)
			newNode.next.prev = newNode;

		return list;
	}

	public static DoubleLinkedList append(DoubleLinkedList list, int data) {
		Node newNode = new Node(data);
		Node last = list.head;
		newNode.next = null;

		if (list.head == null) {
			newNode.prev = null;
			list.head = newNode;
			return list;

		}
		while (last.next != null)
			last = last.next;

		last.next = newNode;
		newNode.prev = last;

		return list;
	}

	public static DoubleLinkedList deleteByKey(DoubleLinkedList list, int keyToDelete) {
		Node currNode = list.head;
		Node prev = null, next = null;

		if (currNode != null && currNode.data == keyToDelete) {
			list.head = currNode.next;
			list.head.prev = null;
			System.out.println(keyToDelete + " found and deleted");
			return list;
		}

		while (currNode != null && currNode.data != keyToDelete) {
			prev = currNode;
			currNode = currNode.next;

		}

		if (currNode != null) {
			prev.next = currNode.next;
			currNode.next.prev = prev;
			System.out.println(keyToDelete + " found and deleted");
		}

		if (currNode == null)
			System.out.println(keyToDelete + " Key not found in list");

		return list;
	}

	public static DoubleLinkedList deleteByPosition(DoubleLinkedList list, int position) {
		Node currNode = list.head;
		Node prev = null, next = null;
		if (currNode != null && position == 0) {
			list.head = currNode.next;
			currNode.next.prev = null;
			System.out.println("Key deleted from position " + position);
		}
		int counter = 0;
		while (currNode != null) {
			if (counter == position) {
				prev.next = currNode.next;
				currNode.next.prev = prev;
				System.out.println("Key deleted from position " + position);
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}
		return list;
	}

	public static void printList(Node node) {
		Node last = null;

		System.out.println("Forward traversal : ");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Reverse traversal");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		push(list, 3);
		push(list, 1);
		insertAfter(list, list.head, 2);
		append(list, 4);
		append(list, 5);
		append(list, 6);
		append(list, 7);
		// deleteByKey(list, 5);
		// push(list, 1);
		// deleteByPosition(list, 0);
		deleteByPosition(list, 3);
		printList(list.head);
	}

}
