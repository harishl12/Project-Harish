package multithreading;

public class UsingRunnable implements Runnable {
	String threadName;
	Thread t;

	public UsingRunnable(String threadName) {
		this.threadName = threadName;
		System.out.println("Thread created -> " + threadName);
	}

	public void run() {
		try {

			for (int i = 5; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(" thread running " + threadName + i);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Thread exited -> " + threadName);
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			System.out.println("Thread started -> " + threadName);
			t.start();
		}
	}

}
