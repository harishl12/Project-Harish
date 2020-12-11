package collections;

public class LinkedListImplement {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static LinkedListImplement insert(LinkedListImplement list, int data) {
		Node new_node = new Node(data);
		// new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}

		return list;

	}

	public static LinkedListImplement reverse(LinkedListImplement list) {

		Node prev = null;
		Node current = list.head;
		Node next = null;

		while (current.next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return list;

	}

	public static LinkedListImplement push(LinkedListImplement list, int data) {
		Node new_node = new Node(data);
		new_node.next = list.head;
		list.head = new_node;
		return list;
	}

	public static LinkedListImplement insertAfter(LinkedListImplement list, Node prev, int data) {
		if (prev == null) {
			System.out.println(prev + " does not exist");
			return list;
		}

		Node new_node = new Node(data);
		new_node.next = prev.next;
		prev.next = new_node;
		return list;
	}

	public static LinkedListImplement append(LinkedListImplement list, int data) {
		Node new_node = new Node(data);
		if (list.head == null) {
			list.head = new_node;
			return list;
		}
		Node last = list.head;

		while (last.next != null)
			last = last.next;

		last.next = new_node;

		return list;
	}

	public static LinkedListImplement insertAtPosition(LinkedListImplement list, int data, int position) {
		Node new_node = new Node(data);
		if (list.head == null) {
			list.head = new_node;
			return list;
		}
		if (position == 0) {
			new_node.next = list.head;
			list.head = new_node;
			return list;
		}
		Node node = list.head;
		int listSize = 0;
		while (node.next != null) {
			node = node.next;
			listSize++;
		}
		System.out.println(listSize);

		if (position > listSize) {
			System.out.println(position + " is out of index");
			return list;
		}
		Node curr_node = list.head;
		int counter = 0;
		while (curr_node != null) {
			if (counter == position) {
				new_node.next = curr_node.next;
				curr_node.next = new_node;
				break;
			} else {
				curr_node = curr_node.next;
				counter++;
			}
		}
		return list;
	}

	public static LinkedListImplement deleteByKey(LinkedListImplement list, int keyToDelete) {
		Node curr_node = list.head;
		Node prev = null;

		if (curr_node != null && curr_node.data == keyToDelete) {
			list.head = curr_node.next;
			System.out.println(keyToDelete + " found and deleted");
			return list;
		}

		while (curr_node != null && curr_node.data != keyToDelete) {
			prev = curr_node;
			curr_node = curr_node.next;
		}

		if (curr_node != null) {
			prev.next = curr_node.next;
			System.out.println(keyToDelete + " found and deleted");
		}

		if (curr_node == null)
			System.out.println(keyToDelete + " Key not found in list");

		return list;

	}

	public static LinkedListImplement deleteByPosition(LinkedListImplement list, int index) {
		Node curr_node = list.head, prev = null;
		if (index == 0 && curr_node != null) {
			list.head = curr_node.next;
			System.out.println(index + " position is found and deleted");
			return list;
		}

		int counter = 0;
		while (curr_node != null) {
			if (counter == index) {
				prev.next = curr_node.next;
				System.out.println(index + " position is found and deleted");
				break;
			} else {
				prev = curr_node;
				curr_node = curr_node.next;
				counter++;
			}
		}
		if (curr_node == null)
			System.out.println(index + " position not in list");

		return list;
	}

	public static void printList(LinkedListImplement list) {
		Node curr_node = list.head;
		System.out.println("Linked list : ");
		while (curr_node != null) {
			System.out.print(curr_node.data + " ");
			curr_node = curr_node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListImplement list = new LinkedListImplement();
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);
		list = insert(list, 9);
		list = insert(list, 10);

		printList(list);

		// System.out.println("delete by key");

		// deleteByKey(list, 3);
		// printList(list);
		//
		// deleteByKey(list, 77);
		// printList(list);

		// deleteByPosition(list, 10);
		// printList(list);

		System.out.println("push");
		push(list, 0);
		printList(list);

		System.out.println("insert after");
		insertAfter(list, list.head.next, 11);
		printList(list);

		System.out.println("append");
		append(list, 12);
		printList(list);

		System.out.println("insert node at postion ");
		insertAtPosition(list, 13, 11);
		printList(list);

		System.out.println("reverse list ");
		reverse(list);
		printList(list);

	}

}
