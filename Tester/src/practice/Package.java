package practice;

public class Package {
	String pack;
	int id;

	public Package(String pack, int id) {
		this.pack = pack;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 50 && id < 0) {
			System.out.println("Invalid ID ");
		} else {
			this.id = id;
		}
	}

}
