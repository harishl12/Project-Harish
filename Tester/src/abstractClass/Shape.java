package abstractClass;

public abstract class Shape {
	abstract void draw();
}

class Circle extends Shape {
	void draw() {
		System.out.println("Drawing circle");
	}
}

class Square extends Shape {
	void draw() {
		System.out.println("Drawing Square");
	}
}
