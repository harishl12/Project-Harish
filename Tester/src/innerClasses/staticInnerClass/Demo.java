package innerClasses.staticInnerClass;

import innerClasses.staticInnerClass.Outer.Inner;

public class Demo {
	public static void main(String[] args) {
		Outer.Inner in = new Outer.Inner();
		in.show();
	}
}
