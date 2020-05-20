package abstractClass;

public class TestBanks {
	public static void main(String[] args) {
		Banks b1 = new SBI();
		b1.getInterestRate();
		Banks b2 = new ICICI();
		b2.getInterestRate();
	}
}
