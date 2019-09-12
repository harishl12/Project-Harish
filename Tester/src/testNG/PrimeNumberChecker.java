package testNG;

public class PrimeNumberChecker {
	public boolean validate(int number) {
		boolean isPrime = false;
		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0)
				return false;
		}
		return true;

	}
}
