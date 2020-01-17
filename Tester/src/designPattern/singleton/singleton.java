package designPattern.singleton;

public class singleton {

// Example for eagerly loaded below
//	private static singleton instance = new singleton();  

//	example for lazy load

	// Make instance volatile to make it threadsafe
	private static volatile singleton instance = null;

	// remove private to test runTime Exception
	private singleton() {
		if (instance != null)
			throw new RuntimeException("Use getInstance method to create instance");

	}

	public static singleton getInstance() {
		if (instance == null) {
			// use Synchronized to make sure instance is synchronized and cannot be
			// instantiated using reflection
			synchronized (singleton.class) {
				if (instance == null)
					instance = new singleton();
			}

		}
		return instance;
	}

}
