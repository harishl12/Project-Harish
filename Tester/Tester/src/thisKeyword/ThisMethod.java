package thisKeyword;
//2) this: to invoke current class method

public class ThisMethod {
	void m() {
		System.out.println("Myself m");
	}

	void n() {
		System.out.println(" i am N");
		this.m();
	}

	public static void main(String[] args) {
		ThisMethod t = new ThisMethod();
		t.n();
	}
}
