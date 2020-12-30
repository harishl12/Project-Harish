package multithreading;

public class ThreadDeadLock {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		t1.start();
		t2.start();

	}

	static class T1 extends Thread {
		public void run() {
			synchronized (lock1) {
				System.out.println("T1 holding lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.out.println("T1 waiting for lock2");
				synchronized (lock2) {
					System.out.println("T1 holding lock1 and lock2");
				}
			}
		}
	}

	static class T2 extends Thread {
		public void run() {
			synchronized (lock1) {
				System.out.println("T2 holding lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.out.println("T2 waiting for lock1");
				synchronized (lock2) {
					System.out.println("T2 holding lock1 and lock2");
				}
			}
		}
	}

}
