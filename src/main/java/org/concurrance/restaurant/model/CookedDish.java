package org.concurrance.restaurant.model;

public class CookedDish {

	private int table;
	private String food;
	private String cooked_by;
	private int started_at;
	private int finished_at;

	public CookedDish(int table, String food, String cooked_by, int started_at, int finished_at) {
		super();
		this.table = table;
		this.food = food;
		this.cooked_by = cooked_by;
		this.started_at = started_at;
		this.finished_at = finished_at;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getCooked_by() {
		return cooked_by;
	}

	public void setCooked_by(String cooked_by) {
		this.cooked_by = cooked_by;
	}

	public int getStarted_at() {
		return started_at;
	}

	public void setStarted_at(int started_at) {
		this.started_at = started_at;
	}

	public int getFinished_at() {
		return finished_at;
	}

	public void setFinished_at(int finished_at) {
		this.finished_at = finished_at;
	}

	@Override
	public String toString() {
		return "CookedDish [table=" + table + ", food=" + food + ", cooked_by=" + cooked_by + ", started_at="
				+ started_at + ", finished_at=" + finished_at + "]";
	}

}
