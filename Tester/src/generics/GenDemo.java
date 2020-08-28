package generics;

public class GenDemo {
	public static void main(String[] args) {
		Gen<Integer> gi = new Gen<Integer>(250);
		System.out.println(gi.getObj());
		gi.showType(300);

		Gen<String> gs = new Gen<String>("Harish");
		System.out.println(gs.getObj());
		gs.showType("Amul");
	}

}
