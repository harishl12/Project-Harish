package practice;

public class LockerTest {
	public static void main(String[] args) {
		Locker lk = new Locker();
		Package pk1 = new Package("dog", 21);
		if (lk.isLockerEmpty(pk1.getId()))
			lk.putPackageInLocker(pk1, pk1.getId());

	}
}
