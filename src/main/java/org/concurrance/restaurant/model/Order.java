package org.concurrance.restaurant.model;

import java.util.List;

public class Order {

	private int table;
	private List<String> food;

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public List<String> getFood() {
		return food;
	}

	public void setFood(List<String> food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Order [table=" + table + ", food=" + food + "]";
	}

}
