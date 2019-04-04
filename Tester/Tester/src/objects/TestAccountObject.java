package objects;

public class TestAccountObject {
	public static void main(String[] args) throws InterruptedException {
		Account acc = new Account();
		System.out.println(acc.toString());
		System.out.println(acc.getClass());
		System.out.println(acc.hashCode());
		System.out.println(acc.equals(acc));
		acc.wait();
	}
}
