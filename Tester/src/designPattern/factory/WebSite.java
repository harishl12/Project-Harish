package designPattern.factory;

import java.util.ArrayList;

public abstract class WebSite {

	ArrayList<Page> pages = new ArrayList<Page>();

	public WebSite() {
		this.createWebsite();
	}

	public ArrayList<Page> getPages() {
		return pages;
	}

	public abstract void createWebsite();

}
