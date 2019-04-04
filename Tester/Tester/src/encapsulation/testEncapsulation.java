package encapsulation;

public class testEncapsulation {
	public static void main(String[] args) {
		Account a1 = new Account();
		a1.setName("Harry");
		a1.setEmail("HarryMail");
		a1.setId(17);
		a1.setSalary(2000);
		System.out.println(a1.getName() + " " + a1.getEmail() + " " + a1.getId() + " " + a1.getSalary());

	}
}
