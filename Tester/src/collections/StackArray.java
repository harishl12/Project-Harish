package collections;

public class StackArray {
	int top;
	int[] arr;
	int size;

	public StackArray(int size) {
		this.top = -1;
		this.arr = new int[size];
		this.size = size;
	}

	public boolean isFull() {
		return (size - 1 == top);
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int ele) {
		if (!isFull()) {
			top++;
			System.out.println(" pushed element ->" + ele);
			arr[top] = ele;
		} else {
			System.out.println("stack is full");
		}
	}

	public int pop() {
		if (!isEmpty()) {
			int ele = arr[top];
			top--;
			System.out.println(" popped element -> " + ele);
			return ele;
		} else {
			System.out.println("Stack empty");
			return -1;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			System.out.println(" peek element -> " + arr[top]);
			return arr[top];
		} else
			System.out.println("Stack empty");
		return -1;

	}

	public void printStack() {
		System.out.println("Printing stack ");
		while (top != -1) {
			System.out.println(arr[top]);
			top--;
		}
	}

	public static void main(String[] args) {
		StackArray sa = new StackArray(10);
		sa.pop();
		System.out.println("----------------");
		sa.push(5);
		sa.push(3);
		sa.push(4);
		sa.push(8);
		sa.peek();
		sa.pop();
		sa.printStack();

	}
}
