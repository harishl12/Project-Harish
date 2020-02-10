package designPattern.builder;

public class LunchBuilderDemo {
	public static void main(String[] args) {
		LunchBuilder.Builder builder = new LunchBuilder.Builder();
		builder.bread("Corn").condiment("Soya").meat("Koli");
//		builder.bread("Corn").condiment("Soya").dressing("Mint").meat("Koli");
		LunchBuilder lunch = builder.build();

		System.out.println(lunch.getBread());
		System.out.println(lunch.getCondiment());
		System.out.println(lunch.getDressing());
		System.out.println(lunch.getMeat());

	}
}
