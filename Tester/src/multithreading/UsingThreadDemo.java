package multithreading;

public class UsingThreadDemo {
	public static void main(String[] args) {
		UsingThread t1 = new UsingThread("t1");
		UsingThread t2 = new UsingThread("t2");
		t1.start();
		t2.start();
	}
}
