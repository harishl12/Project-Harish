package inheritance;

public class Aggregation {
	public static void main(String[] args) {
		Address ad1 = new Address("benglur", "Karnataka", "India");
		Address ad2 = new Address("mumbai", "maharashtra", "India");

		Emp e1 = new Emp(17, "Harish", ad1);
		Emp e2 = new Emp(18, "amul", ad2);

		e1.displayEmp();
		e2.displayEmp();
	}
}
