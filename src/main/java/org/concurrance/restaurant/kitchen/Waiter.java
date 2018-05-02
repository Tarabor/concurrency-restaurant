package org.concurrance.restaurant.kitchen;

import java.util.concurrent.BlockingQueue;
import org.concurrance.restaurant.model.Dish;

public class Waiter implements Runnable {

	private BlockingQueue<Dish> numbersQueue;
	private Dish dish;

	public Waiter(BlockingQueue<Dish> numbersQueue, Dish dish) {
		this.numbersQueue = numbersQueue;
		this.dish = dish;
	}

	public void run() {
		try {
			numbersQueue.put(dish);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}