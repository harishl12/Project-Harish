package designPattern.creational.prototype;

public class PrototypeDemo {
	public static void main(String[] args) {
		Registry registry = new Registry();
		Movies movie = (Movies) registry.createItem("Movies");
		movie.setTitle("Tenet");
		movie.setPrice(25.66);
		movie.setRunTime(145);
		movie.setUrl("online.com");
		System.out.println(movie + "\n" + movie.getTitle() + "\n" + movie.getRunTime() + "\n" + movie.getPrice() + "\n"
				+ movie.getUrl());

		Movies nextMovie = (Movies) registry.createItem("Movies");
		nextMovie.setTitle("Nagarahaavu");
		nextMovie.setRunTime(188);
		nextMovie.setPrice(10.32);
		nextMovie.setUrl("youtube .com");
		System.out.println(nextMovie + "\n" + nextMovie.getTitle() + "\n" + nextMovie.getRunTime() + "\n"
				+ nextMovie.getPrice() + "\n" + movie.getUrl());
	}
}
