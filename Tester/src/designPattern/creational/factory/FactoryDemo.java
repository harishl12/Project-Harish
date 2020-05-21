package designPattern.creational.factory;

public class FactoryDemo {
	public static void main(String[] args) {
		WebSite site = WebSiteFactory.getwebSite(WebsiteType.BLOG);
		System.out.println(site.getPages());

		site = WebSiteFactory.getwebSite(WebsiteType.SHOP);
		System.out.println(site.getPages());
	}
}
