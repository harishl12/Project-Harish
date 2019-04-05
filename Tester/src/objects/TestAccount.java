package objects;

public class TestAccount {
	public static void main(String[] args) throws CloneNotSupportedException {
		Account ac = new Account();
		ac.insert(17, "Harry", 4500);
		ac.checkBalance();
		ac.display();
		ac.deposit(500);
		ac.display();
		ac.checkBalance();
		ac.display();
		ac.withdraw(1000);
		ac.checkBalance();
		Account ac2 = (Account) ac.clone();
		ac2.display();
		System.out.println(ac2.equals(ac));

	}
}
