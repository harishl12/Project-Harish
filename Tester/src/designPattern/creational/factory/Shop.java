package designPattern.creational.factory;

public class Shop extends WebSite {

	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new SearchPage());
		pages.add(new ItemPage());
	}

}
