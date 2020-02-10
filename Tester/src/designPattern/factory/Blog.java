package designPattern.factory;

public class Blog extends WebSite {

	@Override
	public void createWebsite() {
		pages.add(new AboutPage());
		pages.add(new CommentsPage());
		pages.add(new ContactPage());
	}

}
