package innerClasses.nestedInnerClass;

public class Demo {
	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		out.outerMethod();
		in.innerMethod();
	}
}
