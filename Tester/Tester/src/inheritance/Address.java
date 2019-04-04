package inheritance;

public class Address {
	String city;
	String state;
	String country;

	public Address(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}

	void displayAddress() {
		System.out.println(city + " " + state + " " + country);
	}
}
