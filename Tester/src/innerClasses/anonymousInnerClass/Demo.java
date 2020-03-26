package innerClasses.anonymousInnerClass;

class Demo {
	public static void main(String[] args) {
		Outer out = new Outer() {

			@Override
			public void eat() {
				System.out.println("I am eating");
			}
		};
		out.eat();
	}
}