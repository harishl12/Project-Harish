package multithreading;

public class UsingRunnableDemo {
	public static void main(String[] args) {
		UsingRunnable t1 = new UsingRunnable("T1");
		UsingRunnable t2 = new UsingRunnable("T2");
		t1.start();
		t2.start();

	}
}
