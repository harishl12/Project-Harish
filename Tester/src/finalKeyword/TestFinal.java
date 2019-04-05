package finalKeyword;

public class TestFinal {
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println(c instanceof Car);
//		c.speedLimit = 155;
		c.move();
		System.out.println(c.speedLimit);
	}
}
