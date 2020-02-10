package designPattern.builder;

public class LunchDemo {
	public static void main(String[] args) {
		LunchOrderBean lunch = new LunchOrderBean();
		lunch.setBread("Rice");
		lunch.setCondiment("Jam");
		lunch.setDressing("lettuce");
		lunch.setMeat("chicken");

		System.out.println(lunch.getBread());
		System.out.println(lunch.getCondiment());
		System.out.println(lunch.getDressing());
		System.out.println(lunch.getMeat());

	}
}
