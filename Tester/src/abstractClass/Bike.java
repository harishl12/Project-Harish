package abstractClass;

public abstract class Bike {
	Bike() {
		System.out.println("Bike is created");
	}

	void run() {
		System.out.println("running");
	}

	abstract void model();
}

class Pulsar extends Bike {
	void model() {
		System.out.println("Model is 2014");
	}
}

class Access extends Bike {

	void model() {
		System.out.println("2017 model");
	}
}