package multithreading;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Threader t1 = new Threader("T1");
		Threader t2 = new Threader("T2");
		t1.start();
		t2.start();
	}
}
