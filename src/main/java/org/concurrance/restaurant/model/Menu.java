package org.concurrance.restaurant.model;

import java.util.Map;

public class Menu {

	private Map<String, Integer> menu;

	public Map<String, Integer> getMenu() {
		return menu;
	}

	public void setMenu(Map<String, Integer> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Menu [menu=" + menu + "]";
	}

}
