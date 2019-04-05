package abstractClass;

public class TestShape {
	public static void main(String[] args) {
		Shape s1 = new Circle();
		s1.draw();
		Shape s2 = new Square();
		s2.draw();
	}
}
