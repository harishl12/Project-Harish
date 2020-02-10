package designPattern.builder;

public class LunchTelescopic {

	private String bread;
	private String dressing;
	private String condiment;
	private String meat;

	public LunchTelescopic() {

	}

	public LunchTelescopic(String bread) {
		this.bread = bread;
	}

	public LunchTelescopic(String bread, String dressing) {
		this(bread);
		this.dressing = dressing;
	}

	public LunchTelescopic(String bread, String dressing, String condiment) {
		this(bread, dressing);
		this.condiment = condiment;
	}

	public LunchTelescopic(String bread, String dressing, String condiment, String meat) {
		this(bread, dressing, condiment);
		this.meat = meat;
	}

	public String getBread() {
		return bread;
	}

	public String getDressing() {
		return dressing;
	}

	public String getCondiment() {
		return condiment;
	}

	public String getMeat() {
		return meat;
	}

}
