package interfaceClass;

public class Multi implements Multiple, show {
	public void show() {
		System.out.println("showng");
	}

	public void print() {
		System.out.println("printing");
	}

	public static void main(String[] args) {
		Multi m1 = new Multi();
		m1.show();
		m1.print();
	}
}
