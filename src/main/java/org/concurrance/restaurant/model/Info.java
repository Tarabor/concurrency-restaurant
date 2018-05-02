package org.concurrance.restaurant.model;

public class Info {

	private String info;

	public Info(String i) {
		this.info = i;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Info [info=" + info + "]";
	}

}
