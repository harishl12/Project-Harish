package misc;

public class CallByValue {
	int data = 50;

	void change(int data) {
		data = data + 100;
	}

	void change(CallByValue c1) {
		c1.data = c1.data + 100;
	}

	public static void main(String[] args) {
		CallByValue c1 = new CallByValue();
		System.out.println("Data -> " + c1.data);
		c1.change(100);
		System.out.println("After chaneg data -> " + c1.data);
		c1.change(c1);
		System.out.println("After change to c1 refe data -> " + c1.data);
	}
}
