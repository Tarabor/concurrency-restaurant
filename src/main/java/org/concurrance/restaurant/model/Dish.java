package org.concurrance.restaurant.model;

import org.springframework.stereotype.Component;

@Component
public class Dish {

	private String name;
	private int cooking_time;
	private int table;

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCooking_time() {
		return cooking_time;
	}

	public void setCooking_time(int cooking_time) {
		this.cooking_time = cooking_time;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", cooking_time=" + cooking_time + ", table=" + table + "]";
	}

}
