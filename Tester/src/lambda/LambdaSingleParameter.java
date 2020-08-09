package lambda;

public class LambdaSingleParameter {
	public static void main(String[] args) {
		Sayable2 s2 = (name) -> {
			return "Myname is " + name;
		};
		System.out.println(s2.say("Harry"));
	}
}
