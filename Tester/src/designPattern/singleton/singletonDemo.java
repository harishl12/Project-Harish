package designPattern.singleton;

public class singletonDemo {
	public static void main(String[] args) {
//		Not able to instantiate class as constructor s private
//		singleton newInstance = new singleton();

		singleton instance = singleton.getInstance();
		System.out.println(instance);
		singleton anotherInstance = singleton.getInstance();
		System.out.println(anotherInstance);

//		singleton new2Instance = new singleton();

	}
}
