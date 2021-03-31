package objects;

public class Cloner implements Cloneable{

	@Override
	public String toString() {
		return "Cloner [name=" + name + "]";
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
