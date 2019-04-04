package objects;

public class Account implements Cloneable {
	int acc;
	String name;
	int amount;

	void insert(int a, String n, int am) {
		acc = a;
		name = n;
		amount = am;

	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	void display() {
		System.out.println("account-> " + acc);
		System.out.println("name -> " + name);
		System.out.println("amount -> " + amount);
	}

	void deposit(int amt) {
		amount = amount + amt;
		System.out.println("deposited ->" + amt);

	}

	void checkBalance() {
		System.out.println("Balance -> " + amount);
	}

	void withdraw(int with) {
		if (with > amount) {
			System.out.println("Insufficient balance");
		}
		amount = amount - with;

	}
}
