package designPattern.creational.factory;

public class WebSiteFactory {
	public static WebSite getwebSite(WebsiteType type) {
		switch (type) {
		case BLOG:
			return new Blog();

		case SHOP:
			return new Shop();

		default:
			return null;
		}

	}
}
