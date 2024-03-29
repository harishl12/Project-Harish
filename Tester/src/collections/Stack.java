package collections;

public class Stack {
	Top top;

	static class Top {
		int data;
		Top next;

		Top(int data) {
			this.data = data;
			next = null;
		}
	}

	public static Stack push(Stack stack, int data) {
		Top newNode = new Top(data);
		if (stack.top == null) {
			stack.top = newNode;
		} else {
			newNode.next = stack.top;
			stack.top = newNode;
		}
		return stack;

	}

	public static Stack pop(Stack stack) {
		if (stack.top == null) {
			System.out.println("Stack empty");
		} else {
			stack.top = stack.top.next;
		}

		return stack;
	}

	public static void printStack(Stack stack) {
		Top currNode = stack.top;
		System.out.println("printing stack");

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		push(stack, 1);
		push(stack, 2);
		push(stack, 3);
		push(stack, 4);
		printStack(stack);
		pop(stack);
		printStack(stack);
		pop(stack);
		printStack(stack);
	}

}
