package codingIview;

import java.util.HashSet;

public class LinkedList1 {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static LinkedList1 insert(LinkedList1 list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node currNode = list.head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
		}
		return list;
	}

	public static void print(LinkedList1 list) {
		Node currNode = list.head;
		if (currNode == null)
			System.out.println("List is empty");
		else {
			while (currNode != null) {
				System.out.print(currNode.data + " ");
				currNode = currNode.next;
			}
			System.out.println();
		}
	}

	public static LinkedList1 deleteDuplicates(LinkedList1 list) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Node current = list.head;
		Node prev = null;
		if (current == null) {
			return list;
		} else {
			while (current != null) {
				if (hs.contains(current.data)) {
					prev.next = current.next;
				} else {
					hs.add(current.data);
					prev = current;
				}
				current = current.next;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		int[] info = { 1, 5, 3, 7, 8, 9, 3, 0, 8, 5, 1, 8, 2, 0, 9, 7, 6 };
		LinkedList1 ll = new LinkedList1();
		for (int i = 0; i < info.length; i++) {
			insert(ll, info[i]);
		}
		print(ll);
		deleteDuplicates(ll);
		print(ll);

	}
}
