package staticTest;

public class CountStatic {
	static int count = 0;

	public CountStatic() {
		count++;
		System.out.println(count);
	}

	public static void main(String[] args) {
		CountStatic c1 = new CountStatic();
		// System.out.println(count);
		CountStatic c2 = new CountStatic();
		// System.out.println(count);
		CountStatic c3 = new CountStatic();
		// System.out.println(count);

	}
}