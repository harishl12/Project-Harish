package innerClasses.nestedInterfaces;

public interface Outer {
	void show();

	interface Inner {
		void msg();
	}

}

class TestInterFace implements Outer.Inner {
	public void msg() {
		System.out.println("Message implemented");
	}
}