package org.concurrance.restaurant.kitchen;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.concurrance.restaurant.model.CookedDish;
import org.concurrance.restaurant.model.Dish;

public class Chef implements Runnable {
	private BlockingQueue<Dish> queue;
	private String id;
	private List<CookedDish> list;
	private int cookingTime = 0;

	public Chef(BlockingQueue<Dish> queue, String id, List<CookedDish> l) {
		this.queue = queue;
		this.id = id;
		this.list = l;
	}

	public void run() {
		try {
			while (true) {
				Dish dish = queue.take();

				int cookingTimeFin = cookingTime + dish.getCooking_time();

				CookedDish cooked = new CookedDish(dish.getTable(), dish.getName(), id, cookingTime, cookingTimeFin);
				Thread.sleep(dish.getCooking_time());
				synchronized (list) {
					list.add(cooked);
				}

				cookingTime = cookingTimeFin;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
