package staticTest;

public class CountNoStatic {
	int count;

	public CountNoStatic() {
		count++;
	}

	public static void main(String[] args) {
		CountNoStatic c1 = new CountNoStatic();
		System.out.println(c1.count);
		CountNoStatic c2 = new CountNoStatic();
		System.out.println(c2.count);
		CountNoStatic c3 = new CountNoStatic();
		System.out.println(c3.count);

	}
}
