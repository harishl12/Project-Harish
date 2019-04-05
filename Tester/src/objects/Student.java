package objects;

public class Student implements Cloneable {
	int id;
	String name;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Student st = new Student();
		System.out.println(st.id);
		System.out.println(st.name);
		Student st2 = (Student) st.clone();
		System.out.println(st2.name);
	}
}
