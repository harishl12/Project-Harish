package multithreading;

public class Threader implements Runnable {
	private Thread t;
	private String threadName;

	Threader(String threadName) {
		this.threadName = threadName;
		System.out.println("Thread created -> " + threadName);
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				Thread.sleep(50);
				System.out.println("Running thread -> " + threadName + "->" + i);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Exiting thread -> " + threadName);
	}

	public void start() {
		if (t == null) {
			System.out.println("Starting thread -> " + threadName);
			t = new Thread(this, threadName);
			t.start();
		}

	}

}
