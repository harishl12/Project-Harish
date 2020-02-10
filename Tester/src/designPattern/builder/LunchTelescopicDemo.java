package designPattern.builder;

public class LunchTelescopicDemo {
	public static void main(String[] args) {
		LunchTelescopic lunch = new LunchTelescopic("ragi", "spinach", "curry", "pork");
		System.out.println(lunch.getBread());
		System.out.println(lunch.getCondiment());
		System.out.println(lunch.getDressing());
		System.out.println(lunch.getMeat());
	}
}
