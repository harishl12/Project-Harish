package abstractClass;

public abstract class Banks {
	abstract void getInterestRate();
}

class SBI extends Banks {
	void getInterestRate() {
		System.out.println(" Rate is 9%");
	}
}

class ICICI extends Banks {
	void getInterestRate() {
		System.out.println("Rate is 10%");
	}
}