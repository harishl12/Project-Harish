package generics;

public class Gen<T> {
	T obj;

	Gen(T obj) {
		this.obj = obj;
	}

	T getObj() {
		return obj;
	}

	void showType(T obj) {
		System.out.println(obj + " is of type " + obj.getClass().getName());
	}

}
