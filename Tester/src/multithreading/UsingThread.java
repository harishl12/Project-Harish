package multithreading;

public class UsingThread extends Thread {
	String threadName;
	Thread t;

	public UsingThread(String threadName) {
		this.threadName = threadName;
		System.out.println("Thread created -> " + threadName);
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println("thread " + threadName + " -> " + i + " running");
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("thread " + threadName + " exiting");
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			System.out.println("thread " + threadName + " started");
			t.start();
		}

	}

}
