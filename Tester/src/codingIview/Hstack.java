package codingIview;

public class Hstack {
	Node top;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static Hstack push(Hstack stack, int data) {
		Node newNode = new Node(data);
		if (stack.top == null)
			stack.top = newNode;
		else {
			newNode.next = stack.top;
			stack.top = newNode;
		}

		return stack;
	}

	public static void print(Hstack stack) {
		if (stack.top == null)
			System.out.println("Empty stack");
		else {
			Node current = stack.top;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	public static Node pop(Hstack stack) {
		Node current = null;
		if (stack.top == null)
			System.out.println("Empty stack");
		else {
			System.out.println("Node removed " + stack.top.data);
			current = stack.top;
			stack.top = stack.top.next;
		}
		return current;
	}

	public static void peek(Hstack stack) {
		if (stack.top == null)
			System.out.println("Empty stack");
		else {
			System.out.println("Top of stack is " + stack.top.data);
		}
	}

	public static void main(String[] args) {
		int[] info = { 2, 3, 5, 1, 6, 2, 3, 7, 8, 4, 8, 9 };
		Hstack stack = new Hstack();
		for (int i = 0; i < info.length; i++) {
			push(stack, info[i]);
		}
		print(stack);
		pop(stack);
		print(stack);
		peek(stack);
		print(stack);
	}

}
