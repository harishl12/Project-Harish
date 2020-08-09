package lambda;

public class LambdaNoParameter {
	public static void main(String[] args) {

		Sayable say = () -> {
			return "Nothing to say";
		};
		System.out.println(say.say());

	}
}
