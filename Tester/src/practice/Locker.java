package practice;

import java.util.ArrayList;

public class Locker {
	static int size = 50;
	ArrayList<Package> LockerId = new ArrayList<Package>(size);

	boolean isLockerEmpty(int id) {
		boolean empty = false;
		try {
			if (LockerId.get(id) != null) {
				empty = false;
			}

		} catch (IndexOutOfBoundsException ie) {
			empty = true;
		}

		return empty;

	}

	void putPackageInLocker(Package pkg, int id) {
		int pkid = pkg.getId();
		if (isLockerEmpty(pkid)) {
			LockerId.add(pkid, pkg);
		} else {
			System.out.println("Locker is not empty");
		}

	}

}
